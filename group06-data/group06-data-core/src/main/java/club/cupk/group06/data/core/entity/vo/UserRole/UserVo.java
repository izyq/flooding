package club.cupk.waterflood.entity.vo.UserRole;
import club.cupk.waterflood.domain.User;
import club.cupk.waterflood.entity.bo.UserRole.RoleBo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class UserVo extends User {
    private List<RoleBo> roleBoList;
    
    public UserVo(User user) {
        super(user);
    }
}
