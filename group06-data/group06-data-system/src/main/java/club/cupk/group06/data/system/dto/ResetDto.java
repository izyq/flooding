package club.cupk.group06.data.system.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Pattern;

/**
 * 重置密码表单
 * @author Icy
 * @version 1.0.0
 * @since 版本
 */
@Data
public class ResetDto {

    @ApiModelProperty(value = "校验token", required = true)
    private String token;

    @ApiModelProperty(value = "密码", required = true)
    @Pattern(regexp = "[A-Za-z\\d.]{6,16}")
    private String password;

}
