package club.cupk.group06.common.web.exception;

import club.cupk.group06.common.web.response.ResultCode;
import lombok.Getter;

/**
 * 数据库异常
 * @author Icy
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
public class DbException extends ApiException {

    private static final long serialVersionUID = 4294601765233334817L;

    public DbException(ResultCode code) {
        super(code);
    }
    public DbException(ResultCode code, Object data) {
        super(code, data);
    }
}
