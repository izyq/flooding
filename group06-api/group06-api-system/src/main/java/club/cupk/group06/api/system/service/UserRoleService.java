package club.cupk.group06.api.system.service;

import club.cupk.group06.data.system.domain.Role;
import club.cupk.group06.data.system.domain.UserPo;
import club.cupk.group06.data.system.domain.UserRole;
import club.cupk.group06.data.system.vo.RoleVo;
import club.cupk.group06.data.system.vo.UserVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface UserRoleService extends IService<UserRole> {
    Page getPage(Page page, UserRole userRole);

    List<UserRole> getList(UserRole userRole);

    UserVo getUserVo(Long userId);

    List<UserVo> listVo(UserPo userPo);

    IPage<UserVo> pageVo(IPage<UserPo> page, UserPo userPo);

    RoleVo getRoleVo(Long roleId);

    List<RoleVo> listVo(Role role);

    IPage<RoleVo> pageVo(IPage<Role> page, Role role);
}
