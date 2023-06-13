package club.cupk.waterflood.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Service状态码
 * @author Icy
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum ServiceCode implements StatusCode {

    PARAM_FORMAT_ERROR("B0000", "（业务层）参数格式错误"),
    SERVICE_ERROR("B0001", "服务出现未知错误"),
    TOKEN_TIMEOUT("B0003", "凭证无效或超时"),
    VERIFY_TOO_FAST_PHONE("B1000", "验证码请求频率过高（当前手机号）"),
    VERIFY_MISMATCH("B1001", "验证码不匹配"),
    VERIFY_MISMATCH_TOO_MANY("B1002", "验证码错误次数过多"),
    VERIFY_TIMEOUT("B1003", "验证码不存在或超时"),
    API_SMS_ERROR("C1000", "短信api调用失败"),
    ;

    private String code;

    private String message;
}
