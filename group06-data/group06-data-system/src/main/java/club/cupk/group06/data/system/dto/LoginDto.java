package club.cupk.group06.data.system.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Icyの模块
 *
 * @author Icy
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class LoginDto {

    @ApiModelProperty(value = "用户名", required = true)
    private String name;

    @ApiModelProperty(value = "密码", required = true)
    private String password;

}
