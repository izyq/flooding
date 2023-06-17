package club.cupk.group06.data.system.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Pattern;

/**
 * 验证码表单
 * @author Icy
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class VerifyDto {

    @ApiModelProperty(value = "手机号", required = true)
    @Pattern(regexp = "^1[3-9]\\d{9}$")
    private String phone;

    @ApiModelProperty(value = "验证码", required = true)
    @Pattern(regexp = "^\\d{6}$")
    private String code;

}
