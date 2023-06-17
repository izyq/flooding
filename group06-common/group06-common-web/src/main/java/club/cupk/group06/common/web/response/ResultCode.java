package club.cupk.group06.common.web.response;

import lombok.Getter;

/**
 * Icyの模块
 *
 * @author Icy
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
public enum ResultCode {
    SUCCESS(200, "Done"),
    GATEWAY_DOWNSTREAM_RESOURCE_NOT_FOUND(404, "资源不可用"),
    METHOD_NOT_ALLOWED(405, "方法出错"),
    UNSUPPORTED_MEDIA_TYPE(415, "不支持的media"),
    GATEWAY_DOWNSTREAM_ERROR_INFO_FORMAT_ERROR(500, "网关格式错误"),
    ERROR(500, "未知错误"),

    VERIFY_MISMATCH(1000, "验证码不匹配"),
    VERIFY_MISMATCH_TOO_MANY(1001, "验证码错误次数过多"),
    VERIFY_TOO_FAST_PHONE(1002, "发送太快，请稍候重试"),
    PHONE_ALREADY_EXISTS(1004, "手机号已注册"),
    API_SMS_ERROR(1010, "短信API错误"),
    VERIFY_TIMEOUT(1011, "验证超时"),
    TOKEN_TIMEOUT(1012, "Token超时"),
    USER_NOT_FOUND(1100, "用户不存在"),
    WRONG_PASSWORD(1101, "密码错误"),
    SAME_PASSWORD(1110, "新旧密码相同"),
    AUTH_FAILURE(1200, "认证失败"),
    AUTH_ILLEGAL_TOKEN(1201, "认证非法"),


    SQL_ERROR(4000, "数据库未知错误")
    ;

    private final Integer code;

    private String msg = "No message";

    ResultCode(int code) {
        this.code = code;
    }
    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
