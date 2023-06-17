package club.cupk.group06.ability.auth.service;

import club.cupk.group06.common.web.exception.ServiceException;
import club.cupk.group06.common.web.exception.DbException;
import club.cupk.group06.data.system.vo.LoginVo;

/**
 * Icyの模块
 *
 * @author Icy
 * @version 1.0.0
 * @since 1.0.0
 */
public interface AuthService {

    /**
     * 发送验证码
     *
     * @param phone 发送到的手机号
     * @throws ServiceException 请求过于频繁，第三方api异常
     */
    void codeSend(String phone) throws ServiceException;

    /**
     * 校验验证码
     *
     * @param phone 手机号
     * @param code  验证码
     * @return 临时token
     * @throws ServiceException 验证码超时，验证码不匹配，验证码错误次数过多
     */
    String codeVerify(String phone, String code) throws ServiceException;

    /**
     * 使用校验通过的手机号注册新用户
     *
     * @param token    校验token
     * @param username 用户名
     * @param password 密码
     * @return token
     * @throws ServiceException 请求超时
     * @throws DbException      创建失败
     */
    LoginVo register(String token, String username, String password) throws ServiceException, DbException;

    /**
     * 手机号密码登录
     *
     * @param phone    手机号
     * @param password 密码
     * @return JWT令牌token
     * @throws DbException 手机号或密码错误
     */
    LoginVo loginByPassword(String phone, String password) throws DbException;

    /**
     * 手机号验证码登录
     *
     * @param phone      手机号
     * @param verifyCode 验证码
     * @return JWT令牌token
     * @throws ServiceException 手机号或验证码错误
     */
    LoginVo loginByVerifyCode(String phone, String verifyCode) throws ServiceException;

    /**
     * 用户登出
     */
    void logout();

    /**
     * 重置密码
     *
     * @param token    校验token
     * @param password 新密码
     * @throws ServiceException 请求超时
     * @throws DbException      重置失败
     */
    void reset(String token, String password) throws ServiceException, DbException;
}
