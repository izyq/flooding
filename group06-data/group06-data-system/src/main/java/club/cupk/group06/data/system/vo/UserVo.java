package club.cupk.group06.data.system.vo;

import club.cupk.group06.data.system.domain.User;
import club.cupk.group06.data.system.entity.RoleBo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class UserVo extends User {
    private List<RoleBo> roleBoList;

    public UserVo(User user) {
        super(user);
    }
}
