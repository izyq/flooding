package club.cupk.group06.api.system.service.impl;

import club.cupk.group06.api.system.service.RoleService;
import club.cupk.group06.api.system.service.UserRoleService;
import club.cupk.group06.api.system.service.UserService;
import club.cupk.group06.data.system.domain.Role;
import club.cupk.group06.data.system.domain.UserPo;
import club.cupk.group06.data.system.domain.UserRole;
import club.cupk.group06.data.system.entity.RoleBo;
import club.cupk.group06.data.system.entity.UserBo;
import club.cupk.group06.data.system.mapper.UserRoleMapper;
import club.cupk.group06.data.system.vo.RoleVo;
import club.cupk.group06.data.system.vo.UserVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Table;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import xin.altitude.cms.common.util.BeanCopyUtils;
import xin.altitude.cms.common.util.EntityUtils;
import xin.altitude.cms.common.util.TableUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    private UserService userService;

    private RoleService roleService;

    @Override
    public Page getPage(Page page, UserRole userRole) {
        return page(page, Wrappers.lambdaQuery(userRole));
    }

    @Override
    public List<UserRole> getList(UserRole userRole) {
        return list(Wrappers.lambdaQuery(userRole));
    };

    @Override
    public UserVo getUserVo(Long userId) {
        UserVo userVo = EntityUtils.toObj(userService.getById(userId), UserVo::new);
        List<UserRole> userRoles = list(Wrappers.lambdaQuery(UserRole.class).eq(UserRole::getUserId, userId));
        Set<Long> roleIds = EntityUtils.toSet(userRoles, UserRole::getRoleId);
        if (userVo != null && roleIds.size() > 0) {
            LambdaQueryWrapper<Role> queryWrapper = Wrappers.lambdaQuery(Role.class).in(Role::getRoleId, roleIds);
            List<RoleBo> subBoList = EntityUtils.toList(roleService.list(queryWrapper), RoleBo::new);
            Table<Long, Long, UserRole> table = TableUtils.createHashTable(userRoles, UserRole::getUserId, UserRole::getRoleId);
            subBoList.forEach(e -> BeanCopyUtils.copyProperties(table.get(userId, e.getRoleId()), e));
            userVo.setRoleBoList(subBoList);
        }
        return userVo;
    }

    public List<UserVo> listVo(UserPo userPo) {
        List<UserVo> userVoList = EntityUtils.toList(userService.list(Wrappers.lambdaQuery(userPo)), UserVo::new);
        Set<Long> userIds = EntityUtils.toSet(userVoList, UserPo::getUserId);
        if (userIds.size() == 0) {
            return userVoList;
        }
        List<UserRole> userRoles = list(Wrappers.lambdaQuery(UserRole.class).in(UserRole::getUserId, userIds));
        Set<Long> roleIds = EntityUtils.toSet(userRoles, UserRole::getRoleId);
        Map<Long, List<Long>> map = userRoles.stream().collect(Collectors.groupingBy(UserRole::getUserId, Collectors.mapping(UserRole::getRoleId, Collectors.toList())));
        if (roleIds.size() == 0) {
            return userVoList;
        }
        Table<Long, Long, UserRole> table = TableUtils.createHashTable(userRoles, UserRole::getUserId, UserRole::getRoleId);
        LambdaQueryWrapper<Role> queryWrapper = Wrappers.lambdaQuery(Role.class).in(Role::getRoleId, roleIds);
        List<RoleBo> roleBoList = EntityUtils.toList(roleService.list(queryWrapper), RoleBo::new);
        for (UserVo userVo : userVoList) {
            List<RoleBo> list = roleBoList.stream().filter(e -> map.get(userVo.getUserId()) != null && map.get(userVo.getUserId()).contains(e.getRoleId())).collect(Collectors.toList());
            list.forEach(e -> BeanCopyUtils.copyProperties(table.get(userVo.getUserId(), e.getRoleId()), e));
            userVo.setRoleBoList(list);
        }
        return userVoList;
    }

    public IPage<UserVo> pageVo(IPage<UserPo> page, UserPo userPo) {
        IPage<UserVo> userVoPage = EntityUtils.toPage(userService.page(page, Wrappers.lambdaQuery(userPo)), UserVo::new);
        Set<Long> userIds = EntityUtils.toSet(userVoPage.getRecords(), UserPo::getUserId);
        if (userIds.size() == 0) {
            return userVoPage;
        }
        List<UserRole> userRoles = list(Wrappers.lambdaQuery(UserRole.class).in(UserRole::getUserId, userIds));
        Set<Long> roleIds = EntityUtils.toSet(userRoles, UserRole::getRoleId);
        if (roleIds.size() == 0) {
            return userVoPage;
        }
        Table<Long, Long, UserRole> table = TableUtils.createHashTable(userRoles, UserRole::getUserId, UserRole::getRoleId);
        Map<Long, List<Long>> map = userRoles.stream().collect(Collectors.groupingBy(UserRole::getUserId, Collectors.mapping(UserRole::getRoleId, Collectors.toList())));
        List<RoleBo> roleBoList = EntityUtils.toList(roleService.list(Wrappers.lambdaQuery(Role.class).in(Role::getRoleId, roleIds)), RoleBo::new);
        for (UserVo userVo : userVoPage.getRecords()) {
            List<RoleBo> list = roleBoList.stream().filter(e -> map.get(userVo.getUserId()) != null && map.get(userVo.getUserId()).contains(e.getRoleId())).collect(Collectors.toList());
            list.forEach(e -> BeanCopyUtils.copyProperties(table.get(userVo.getUserId(), e.getRoleId()), e));
            userVo.setRoleBoList(list);
        }
        return userVoPage;
    }

    public RoleVo getRoleVo(Long roleId) {
        RoleVo roleVo = EntityUtils.toObj(roleService.getById(roleId), RoleVo::new);
        List<UserRole> userRoles = list(Wrappers.lambdaQuery(UserRole.class).eq(UserRole::getRoleId, roleId));
        Set<Long> userIds = EntityUtils.toSet(userRoles, UserRole::getUserId);
        if (roleVo != null && userIds.size() > 0) {
            LambdaQueryWrapper<UserPo> queryWrapper = Wrappers.lambdaQuery(UserPo.class).in(UserPo::getUserId, userIds);
            List<UserBo> subBoList = EntityUtils.toList(userService.list(queryWrapper), UserBo::new);
            Table<Long, Long, UserRole> table = TableUtils.createHashTable(userRoles, UserRole::getRoleId, UserRole::getUserId);
            subBoList.forEach(e -> BeanCopyUtils.copyProperties(table.get(roleId, e.getUserId()), e));
            roleVo.setUserBoList(subBoList);
        }
        return roleVo;
    }

    public List<RoleVo> listVo(Role role) {
        List<RoleVo> roleVoList = EntityUtils.toList(roleService.list(Wrappers.lambdaQuery(role)), RoleVo::new);
        Set<Long> roleIds = EntityUtils.toSet(roleVoList, Role::getRoleId);
        if (roleIds.size() == 0) {
            return roleVoList;
        }
        List<UserRole> userRoles = list(Wrappers.lambdaQuery(UserRole.class).in(UserRole::getRoleId, roleIds));
        Set<Long> userIds = EntityUtils.toSet(userRoles, UserRole::getUserId);
        Map<Long, List<Long>> map = userRoles.stream().collect(Collectors.groupingBy(UserRole::getRoleId, Collectors.mapping(UserRole::getUserId, Collectors.toList())));
        if (userIds.size() == 0) {
            return roleVoList;
        }
        Table<Long, Long, UserRole> table = TableUtils.createHashTable(userRoles, UserRole::getRoleId, UserRole::getUserId);
        LambdaQueryWrapper<UserPo> queryWrapper = Wrappers.lambdaQuery(UserPo.class).in(UserPo::getUserId, userIds);
        List<UserBo> userBoList = EntityUtils.toList(userService.list(queryWrapper), UserBo::new);
        for (RoleVo roleVo : roleVoList) {
            List<UserBo> list = userBoList.stream().filter(e -> map.get(roleVo.getRoleId()) != null && map.get(roleVo.getRoleId()).contains(e.getUserId())).collect(Collectors.toList());
            list.forEach(e -> BeanCopyUtils.copyProperties(table.get(roleVo.getRoleId(), e.getUserId()), e));
            roleVo.setUserBoList(list);
        }
        return roleVoList;
    }

    public IPage<RoleVo> pageVo(IPage<Role> page, Role role) {
        IPage<RoleVo> roleVoPage = EntityUtils.toPage(roleService.page(page, Wrappers.lambdaQuery(role)), RoleVo::new);
        Set<Long> roleIds = EntityUtils.toSet(roleVoPage.getRecords(), Role::getRoleId);
        if (roleIds.size() == 0) {
            return roleVoPage;
        }
        List<UserRole> userRoles = list(Wrappers.lambdaQuery(UserRole.class).in(UserRole::getRoleId, roleIds));
        Set<Long> userIds = EntityUtils.toSet(userRoles, UserRole::getUserId);
        if (userIds.size() == 0) {
            return roleVoPage;
        }
        Table<Long, Long, UserRole> table = TableUtils.createHashTable(userRoles, UserRole::getRoleId, UserRole::getUserId);
        Map<Long, List<Long>> map = userRoles.stream().collect(Collectors.groupingBy(UserRole::getRoleId, Collectors.mapping(UserRole::getUserId, Collectors.toList())));
        List<UserBo> userBoList = EntityUtils.toList(userService.list(Wrappers.lambdaQuery(UserPo.class).in(UserPo::getUserId, userIds)), UserBo::new);
        for (RoleVo roleVo : roleVoPage.getRecords()) {
            List<UserBo> list = userBoList.stream().filter(e -> map.get(roleVo.getRoleId()) != null && map.get(roleVo.getRoleId()).contains(e.getUserId())).collect(Collectors.toList());
            list.forEach(e -> BeanCopyUtils.copyProperties(table.get(roleVo.getRoleId(), e.getUserId()), e));
            roleVo.setUserBoList(list);
        }
        return roleVoPage;
    }
}
