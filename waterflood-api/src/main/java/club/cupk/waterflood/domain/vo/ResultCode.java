package club.cupk.waterflood.domain.vo;


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
    SUCCESS(200),
    GATEWAY_DOWNSTREAM_RESOURCE_NOT_FOUND(404),
    METHOD_NOT_ALLOWED(405),
    UNSUPPORTED_MEDIA_TYPE(415),
    GATEWAY_DOWNSTREAM_ERROR_INFO_FORMAT_ERROR(500),
    ERROR(500);
    private final Integer code;

    private String message = "No message";

    ResultCode(int code) {
        this.code = code;
    }
    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
