package club.cupk.group06.api.core.service;

import club.cupk.waterflood.domain.Role;
import club.cupk.waterflood.domain.User;
import club.cupk.waterflood.domain.UserRole;
import club.cupk.waterflood.entity.vo.UserRole.RoleVo;
import club.cupk.waterflood.entity.vo.UserRole.UserVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IUserRoleService                extends IService<UserRole>    {
    Page getPage(Page page,UserRole userRole);
    List<UserRole> getList(UserRole userRole);

    UserVo getUserVo(Long userId);
    List<UserVo> listVo(User user);
    IPage<UserVo> pageVo(IPage<User> page, User user);
    RoleVo getRoleVo(Long roleId);
    List<RoleVo> listVo(Role role);
    IPage<RoleVo> pageVo(IPage<Role> page, Role role);
}
