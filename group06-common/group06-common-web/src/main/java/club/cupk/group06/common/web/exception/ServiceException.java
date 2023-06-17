package club.cupk.group06.common.web.exception;

import club.cupk.group06.common.web.response.ResultCode;
import lombok.Getter;

/**
 * Service层异常
 * @author Icy
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
public class ServiceException extends ApiException {

    private static final long serialVersionUID = 4000618294874083090L;

    public ServiceException(ResultCode code) {
        super(code);
    }
    public ServiceException(ResultCode code, Object data) {
        super(code, data);
    }
}
