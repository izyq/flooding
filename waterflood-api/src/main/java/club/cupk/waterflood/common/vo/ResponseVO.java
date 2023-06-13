package club.cupk.waterflood.common.vo;

import club.cupk.waterflood.common.enums.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseVO {
    private Boolean success;

    private Integer code;

    private String message;

    private Object data;

    public static ResponseVO ok() {
        return ResponseVO.builder()
                .success(true)
                .code(ResultCode.SUCCESS.getCode())
                .message("Done").build();
    }

    public static ResponseVO ok(Object jsonObject) {
        return ResponseVO.builder()
                .success(true)
                .code(ResultCode.SUCCESS.getCode())
                .message("Done")
                .data(jsonObject).build();
    }

    public static ResponseVO error() {
        return ResponseVO.builder()
                .success(false)
                .code(ResultCode.ERROR.getCode())
                .message(ResultCode.ERROR.getMsg()).build();
    }

    public static ResponseVO error(ResultCode resultCode) {
        return ResponseVO.builder()
                .success(false)
                .code(resultCode.getCode())
                .message(resultCode.getMsg()).build();

    }

    public static ResponseVO error(int code, String message) {
        return ResponseVO.builder()
                .success(false)
                .code(code)
                .message(message).build();

    }

    public static ResponseVO error(ResultCode resultCode, String message) {
        return ResponseVO.builder()
                .success(false)
                .code(resultCode.getCode())
                .message(message).build();

    }


    public static Object error(Integer code, String message, byte[] originalBody) {
        return ResponseVO.builder()
                .success(false)
                .code(code)
                .message(message)
                .data(originalBody).build();
    }
}