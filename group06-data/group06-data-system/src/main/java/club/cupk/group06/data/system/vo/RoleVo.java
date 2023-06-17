package club.cupk.group06.data.system.vo;

import java.util.List;

import club.cupk.group06.data.system.domain.Role;
import club.cupk.group06.data.system.entity.UserBo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class RoleVo extends Role {
    private List<UserBo> userBoList;

    public RoleVo(Role role) {
        super(role);
    }
}
