package club.cupk.waterflood.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName(value = "role")
public class Role implements Serializable{
    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "角色id", position = 1)
    private Long roleId;

    @ApiModelProperty(value = "角色名", position = 2)
    private String roleName;
    
    public Role(Role role) {
        if (Objects.nonNull(role)) {
            this.roleId=role.roleId;
            this.roleName=role.roleName;
        }
    }
}
