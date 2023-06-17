package club.cupk.group06.data.system.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Pattern;

/**
 * 注册表单
 * @author Icy
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class RegisterDto {

    @ApiModelProperty(value = "校验token", required = true)
    private String token;

    @ApiModelProperty(value = "用户名", required = true)
    private String name;

    @ApiModelProperty(value = "密码", required = true)
    @Pattern(regexp = "[A-Za-z\\d.]{6,16}")
    private String password;

}
