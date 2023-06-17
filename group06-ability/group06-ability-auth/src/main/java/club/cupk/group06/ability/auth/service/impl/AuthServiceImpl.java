package club.cupk.group06.ability.auth.service.impl;

import club.cupk.group06.ability.auth.service.AuthService;
import club.cupk.group06.common.core.util.RedisUtil;
import club.cupk.group06.common.core.util.SmsUtil;
import club.cupk.group06.common.web.response.ResultCode;
import club.cupk.group06.config.JwtConfig;
import club.cupk.group06.data.system.domain.SmsCodeToken;
import club.cupk.group06.data.system.domain.User;
import club.cupk.group06.data.system.domain.UserPo;
import club.cupk.group06.data.system.domain.UserRole;
import club.cupk.group06.data.system.mapper.UserMapper;
import club.cupk.group06.data.system.mapper.UserRoleMapper;
import club.cupk.group06.data.system.vo.LoginVo;
import cn.hutool.jwt.JWTUtil;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import club.cupk.group06.common.web.exception.ServiceException;
import club.cupk.group06.common.web.exception.DbException;

import javax.annotation.Resource;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Icyの模块
 *
 * @author Icy
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService, UserDetailsService {

    private UserMapper userMapper;

    private UserRoleMapper userRoleMapper;

    private RedisUtil redisUtil;

    private SmsUtil smsUtil;

    private JwtConfig jwtConfig;

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private PasswordEncoder passwordEncoder;

    /**
     * 实现spring-security登录所用接口，Username实际是Phone
     * @param s 用户手机号
     * @return 用户实体
     * @throws DbException 用户手机号未找到
     */
    @Override
    public UserDetails loadUserByUsername(@Validated @NotEmpty String s) {
        // 查询用户信息
        UserPo userPo = userMapper.selectByPhone(s);
        if (userPo == null) {
            throw new DbException(ResultCode.USER_NOT_FOUND);
        }

        List<UserRole> roleList = userMapper.listRoleById(userPo.getUserId());
        // 把数据封装成UserDetails返回
        return new User(userPo, roleList);
    }

    @Override
    public void codeSend(String phone) throws ServiceException {
        smsUtil.codeSend(phone);
    }

    @Override
    public String codeVerify(String phone, String code) throws ServiceException {
        String value = (String)redisUtil.get("verify:" + phone);
        if (value == null) {
            throw new ServiceException(ResultCode.VERIFY_TIMEOUT);
        }

        // 检查错误次数
        smsUtil.checkTimes(phone);

        // redis存储错误次数
        String verifyTimes = "verifyTimes:" + phone;
        // 输入正确生成token存redis，返回临时token
        if (value.equals(code)) {
            redisUtil.delete("verify:" + phone);
            redisUtil.delete(verifyTimes);
            Map<String, Object> map = redisUtil.createMap("verified", phone);
            String token = JWTUtil.createToken(map, jwtConfig.getPrivateKey().getBytes());
            redisUtil.set(token, phone, 10, TimeUnit.MINUTES);
            return token;
        }

        // 输入错误
        Integer times = (Integer) redisUtil.get(verifyTimes);
        // 第一次输错，还没存储错误次数
        if (times == null) {
            redisUtil.set(verifyTimes, 2, 60, TimeUnit.MINUTES);
            throw new ServiceException(ResultCode.VERIFY_MISMATCH, 2);
        }

        // 第二次输错，存2写1，还能输一次；存1自减变0不满足该分支
        if (--times > 0) {
            redisUtil.set(verifyTimes, times, 60, TimeUnit.MINUTES);
            throw new ServiceException(ResultCode.VERIFY_MISMATCH, times);
        }

        // 第三次输错，锁住
        redisUtil.set(verifyTimes, 0, 60, TimeUnit.MINUTES);
        throw new ServiceException(ResultCode.VERIFY_MISMATCH_TOO_MANY, 15);

    }

    @Override
    public LoginVo register(String token, String name, String password) throws ServiceException, DbException {
        String phone = verifyToken(token);
        String code = passwordEncoder.encode(password);
        UserPo user = UserPo.builder()
                .userName(name)
                .userPhone(phone)
                .userPassword(code)
                .build();
        if (userMapper.existsByPhone(phone)) {
            throw new DbException(ResultCode.PHONE_ALREADY_EXISTS);
        }

        try {
            userMapper.insert(user);
            //TODO role 枚举类
            userRoleMapper.insert(
                    UserRole.builder()
                            .userId(user.getUserId())
                            .roleId(4L)
                            .build()
            );
        } catch (Exception e) {
            throw new DbException(ResultCode.SQL_ERROR);
        }

        redisUtil.delete(token);
        // 注册完自动登录，返回token
        return loginByPassword(phone, password);
    }

    @Override
    public LoginVo loginByPassword(String phone, String password) throws DbException {
        try {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(phone, password);
            return loginRedisToken(authenticationToken);

        } catch (AuthenticationException e) {
            // 判断用户是否存在
            throw new DbException(
                    userMapper.existsByPhone(phone)
                            ? ResultCode.WRONG_PASSWORD
                            : ResultCode.USER_NOT_FOUND
            );
        }
    }

    @Override
    public LoginVo loginByVerifyCode(String phone, String verifyCode) throws ServiceException {
        try {
            SmsCodeToken authenticationToken =
                    new SmsCodeToken(phone, verifyCode);
            return loginRedisToken(authenticationToken);
        } catch (AuthenticationException e) {
            throw new DbException(
                    userMapper.existsByPhone(phone)
                            ? ResultCode.WRONG_PASSWORD
                            : ResultCode.USER_NOT_FOUND
            );
        }
    }

    @Override
    public void logout() {
        // 获取用户id
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        // 如果无值会被Filter拦截，无需ifn判断
        Long uid = user.getUser().getUserId();
        redisUtil.delete("login:" + uid);
    }

    @Override
    public void reset(String token, String password) throws ServiceException, DbException {
        String phone = verifyToken(token);
        String code = passwordEncoder.encode(password);
        UserPo user = userMapper.selectByPhone(phone);
        if (passwordEncoder.matches(password, user.getUserPassword())) {
            throw new DbException(ResultCode.SAME_PASSWORD);
        }

        userMapper.updatePassword(phone, code);
        redisUtil.delete(token);
        // 强制重新登录
        try {
            logout();
        } catch (Exception ignored) {}
    }

    // 封装以便于多种登录方法共用
    private LoginVo loginRedisToken(Authentication authenticationToken) {
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        User user = (User)authenticate.getPrincipal();
        String uid = user.getUser().getUserId().toString();
        Map<String, Object> map = redisUtil.createMap("uid", uid);
        redisUtil.set("login:" + uid, user);
        return LoginVo.builder()
                .name(user.getUser().getUserName())
                .token(JWTUtil.createToken(map, jwtConfig.getPrivateKey().getBytes()))
                .roles(user.getRoleList()).build();
    }

    @NotNull
    private String verifyToken(String token) throws ServiceException {
        String phone = (String)redisUtil.get(token);
        if (phone == null) {
            throw new ServiceException(ResultCode.TOKEN_TIMEOUT);
        }

        return phone;
    }
}
