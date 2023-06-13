package club.cupk.waterflood.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Db状态码
 * @author Icy
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum DbCode implements StatusCode {

    SQL_ERROR("B8000", "数据库存取出错"),
    PHONE_ALREADY_EXISTS("B8010", "手机号已被使用"),
    USER_NOT_FOUND("B8011", "用户不存在"),
    WRONG_PASSWORD("B8012", "密码错误"),
    SAME_PASSWORD("B8013", "新密码不能与旧密码相同"),
    DATA_NOT_SUPPORT("B9000", "不支持的数据类型"),
    ;

    private String code;

    private String message;
}
