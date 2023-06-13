package club.cupk.waterflood.domain;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName(value = "user_role")
public class UserRole{
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
