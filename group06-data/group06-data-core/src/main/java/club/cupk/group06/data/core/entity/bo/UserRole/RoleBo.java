package club.cupk.group06.data.core.entity.bo.UserRole;


import club.cupk.group06.data.core.domain.Role;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * xin.altitude.cms.code.domain.MetaTable@27649293
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class RoleBo extends Role {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "用户代表的油田/注水井", position = 3)
    private Long assetId;
    @ApiModelProperty(value = "用户id", position = 1)
    private Long userId;

    public RoleBo() {
    }

    public RoleBo(Role role) {
        super(role);
    }
}
