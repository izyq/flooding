package club.cupk.group06.common.web.response;

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

    private String msg;

    private Object data;

    public static ResponseVO ok() {
        return ResponseVO.builder()
                .success(true)
                .code(ResultCode.SUCCESS.getCode())
                .msg("Done").build();
    }

    public static ResponseVO ok(ResultCode resultCode,Object data){
        return ResponseVO.builder()
                .success(true)
                .code(resultCode.getCode())
                .msg(resultCode.getMsg())
                .data(data).build();
    }

    public static ResponseVO ok(Object jsonObject) {
        return ResponseVO.builder()
                .success(true)
                .code(ResultCode.SUCCESS.getCode())
                .msg("Done")
                .data(jsonObject).build();
    }

    public static ResponseVO error() {
        return ResponseVO.builder()
                .success(false)
                .code(ResultCode.ERROR.getCode())
                .msg(ResultCode.ERROR.getMsg()).build();
    }

    public static ResponseVO error(ResultCode resultCode) {
        return ResponseVO.builder()
                .success(false)
                .code(resultCode.getCode())
                .msg(resultCode.getMsg()).build();

    }

    public static ResponseVO error(int code, String message) {
        return ResponseVO.builder()
                .success(false)
                .code(code)
                .msg(message).build();

    }

    public static ResponseVO error(ResultCode resultCode, String message) {
        return ResponseVO.builder()
                .success(false)
                .code(resultCode.getCode())
                .msg(message).build();

    }


    public static Object error(Integer code, String message, byte[] originalBody) {
        return ResponseVO.builder()
                .success(false)
                .code(code)
                .msg(message)
                .data(originalBody).build();
    }
}