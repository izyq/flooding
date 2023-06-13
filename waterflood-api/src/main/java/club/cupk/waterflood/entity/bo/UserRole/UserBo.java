package club.cupk.waterflood.entity.bo.UserRole;
import club.cupk.waterflood.domain.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
/** xin.altitude.cms.code.domain.MetaTable@30225465 */
@Data
@AllArgsConstructor
public class UserBo extends User{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "用户代表的油田/注水井", position = 3)
    private Long assetId;
    @ApiModelProperty(value = "用户的角色id", position = 2)
    private Long roleId;
    
    public UserBo() {
    }
    
    public UserBo(User user) {
        super(user);
    }
}
