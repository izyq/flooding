package club.cupk.group06.ability.auth.controller;

import club.cupk.group06.ability.auth.service.AuthService;
import club.cupk.group06.data.system.dto.LoginDto;
import club.cupk.group06.data.system.dto.RegisterDto;
import club.cupk.group06.data.system.dto.ResetDto;
import club.cupk.group06.data.system.dto.VerifyDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.Pattern;

/**
 * Icyの模块
 *
 * @author Icy
 * @version 1.0.0
 * @since 1.0.0
 */

@Api(tags = "认证模块")
@Validated
@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping
public class AuthController {

    private final AuthService authService;

    /**
     * 前端请求发送验证码
     * @param phone 手机号
     */
    @ApiOperation("给定手机发送验证码")
    @PreAuthorize("permitAll()")
    @GetMapping("/code/send")
    public void codeSend(
            @ApiParam(value = "手机号", required = true)
            @Pattern(regexp = "^1[3-9]\\d{9}$")
            @RequestParam("phone") String phone) {
        authService.codeSend(phone);
    }

    /**
     * 前端请求验证手机号
     * @param form 手机号，验证码
     * @return 进行下次操作所需的token标记
     */
    @ApiOperation("验证手机号")
    @PreAuthorize("permitAll()")
    @PostMapping("/code/verify")
    public String codeVerify(
            @Validated @NotNull @RequestBody VerifyDto form) {
        return authService.codeVerify(form.getPhone(), form.getCode());
    }

    /**
     * 新用户注册
     * @param form 注册信息表单
     * @return token和权限
     */
    @ApiOperation("用户注册")
    @PreAuthorize("isAnonymous()")
    @PostMapping("/register")
    public Object register(@NotNull @RequestBody RegisterDto form) {
        return authService.register(form.getToken(), form.getName(), form.getPassword());
    }

    /**
     * 手机号密码登录
     * @param form 密码登录表单
     * @return token和权限
     */
    @ApiOperation("手机号密码登录")
    @PreAuthorize("isAnonymous()")
    @PostMapping("/login/password")
    public Object loginByPassword(@NotNull @RequestBody LoginDto form) {
        return authService.loginByPassword(form.getName(), form.getPassword());
    }

    /**
     * 手机验证码登录
     * @param form 验证码表单
     * @return token和权限
     */
    @ApiOperation("手机号验证码登录")
    @PreAuthorize("isAnonymous()")
    @PostMapping("/login/verifyCode")
    public Object loginByVerifyCode(@NotNull @RequestBody VerifyDto form) {
        return authService.loginByVerifyCode(form.getPhone(), form.getCode());
    }

    /**
     * 用户登出
     */
    @ApiOperation("用户登出")
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/logout")
    public void logout() {
        authService.logout();
    }

    /**
     * 重置密码
     * @param form 重置密码表单
     */
    @ApiOperation("重置密码")
    @PreAuthorize("permitAll()")
    @PostMapping("/reset")
    public void reset(@NotNull @RequestBody ResetDto form) {
        authService.reset(form.getToken(), form.getPassword());
    }

}
