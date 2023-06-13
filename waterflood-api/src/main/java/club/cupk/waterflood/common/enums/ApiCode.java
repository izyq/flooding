package club.cupk.waterflood.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Api状态码
 * @author Icy
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum ApiCode implements StatusCode {
    SUCCESS("00000", "Done"),

    PARAM_FORMAT_ERROR("A0000", "（用户输入）参数格式错误"),
    API_ERROR("A0001", "Api层出现未知错误"),
    TIMEOUT("A0002", "请求超时"),
    AUTH_ILLEGAL_TOKEN("A0010", "token非法"),
    AUTH_FAILURE("A0011", "用户未登录"),
    AUTH_MISMATCH("A0012", "用户权限不足"),
    VERIFY_TOO_FAST_SESSION("A1000", "验证码请求频率过高（当前Session）"),
    VERIFY_MISMATCH("A1001", "验证码不匹配"),
    DATA_NOT_SUPPORT("A3000", "不支持的数据类型")
    ;

    private String code;

    private String message;
}
