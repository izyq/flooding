package club.cupk.waterflood.entity.vo.UserRole;
import club.cupk.waterflood.domain.Role;
import club.cupk.waterflood.entity.bo.UserRole.UserBo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class RoleVo extends Role {
    private List<UserBo> userBoList;
    
    public RoleVo(Role role) {
        super(role);
    }
}
