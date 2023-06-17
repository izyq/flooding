package club.cupk.group06.common.web.exception;

import club.cupk.group06.common.web.response.ResultCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * 后端Api异常
 * @author Icy
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@NoArgsConstructor
public class ApiException extends RuntimeException {

    private static final long serialVersionUID = -7680905182505160327L;

    private ResultCode code = ResultCode.ERROR;

    private Object data;

    public ApiException(ResultCode code) {
        this.code = code;
        this.data = null;
    }

    public ApiException(ResultCode code, Object data) {
        this.code = code;
        this.data = data;
    }

}
