package club.cupk.group06.data.core.entity.vo.UserRole;

import club.cupk.group06.data.core.domain.Role;
import club.cupk.group06.data.core.entity.bo.UserRole.UserBo;

import java.util.List;

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
