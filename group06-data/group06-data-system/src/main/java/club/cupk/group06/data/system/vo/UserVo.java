package club.cupk.group06.data.system.vo;

import club.cupk.group06.data.system.domain.UserPo;
import club.cupk.group06.data.system.entity.RoleBo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class UserVo extends UserPo {
    private List<RoleBo> roleBoList;

    public UserVo(UserPo userPo) {
        super(userPo);
    }
}
