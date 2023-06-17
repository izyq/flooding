package club.cupk.group06.data.system.entity;

import club.cupk.group06.data.system.domain.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * xin.altitude.cms.code.domain.MetaTable@30225465
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBo extends User {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "用户代表的油田/注水井", position = 3)
    private Long assetId;
    @ApiModelProperty(value = "用户的角色id", position = 2)
    private Long roleId;

    public UserBo(User user) {
        super(user);
    }
}
