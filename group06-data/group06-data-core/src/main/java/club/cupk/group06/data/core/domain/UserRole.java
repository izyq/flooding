package club.cupk.waterflood.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "user_role")
public class UserRole implements Serializable{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户代表的油田/注水井", position = 3)
    private Long assetId;

    @TableField("role_id")
    @ApiModelProperty(value = "用户的角色id", position = 2)
    private Long roleId;

    @TableField("user_id")
    @ApiModelProperty(value = "用户id", position = 1)
    private Long userId;
    
    public UserRole(UserRole userRole) {
        if (Objects.nonNull(userRole)) {
            this.assetId=userRole.assetId;
            this.roleId=userRole.roleId;
            this.userId=userRole.userId;
        }
    }
}
