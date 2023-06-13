package club.cupk.waterflood.domain;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "role")
public class Role{
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
