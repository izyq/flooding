package club.cupk.group06.api.core.controller;

import club.cupk.group06.api.core.service.IUserRoleService;
import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.core.domain.Role;
import club.cupk.group06.data.core.domain.User;
import club.cupk.group06.data.core.domain.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.PageEntity;

import java.util.Arrays;

@RestController
@RequestMapping("/waterflood/user/role")
@RequiredArgsConstructor
public class UserRoleController {
    private IUserRoleService userRoleService;

    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity, UserRole userRole) {
        return AjaxResult.success(userRoleService.getPage(pageEntity.toPage(), userRole));
    }

    @GetMapping("/list")
    public AjaxResult list(UserRole userRole) {
        return AjaxResult.success(userRoleService.getList(userRole));
    }

    @PostMapping("/push")
    public AjaxResult add(@RequestBody UserRole userRole) {
        return AjaxResult.success(userRoleService.save(userRole));
    }

    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody UserRole userRole) {
        return AjaxResult.success(userRoleService.updateById(userRole));
    }

    @DeleteMapping("/delete/{roleIds}")
    public AjaxResult delete(@PathVariable Long[] roleIds) {
        return AjaxResult.success(userRoleService.removeByIds(Arrays.asList(roleIds)));
    }

    @GetMapping(value = "/detail/{roleId}")
    public AjaxResult detail(@PathVariable("roleId") Long roleId) {
        return AjaxResult.success(userRoleService.getById(roleId));
    }

    @GetMapping("/user/page")
    public AjaxResult pageVo(PageEntity pageEntity, User user) {
        return AjaxResult.success(userRoleService.pageVo(pageEntity.toPage(), user));
    }

    @GetMapping("/role/page")
    public AjaxResult pageVo(PageEntity pageEntity, Role role) {
        return AjaxResult.success(userRoleService.pageVo(pageEntity.toPage(), role));
    }

    @GetMapping("/user/list")
    public AjaxResult listVo(User user) {
        return AjaxResult.success(userRoleService.listVo(user));
    }

    @GetMapping("/role/list")
    public AjaxResult listVo(Role role) {
        return AjaxResult.success(userRoleService.listVo(role));
    }

    @GetMapping(value = "/user/detail/{userId}")
    public AjaxResult detailUserVo(@PathVariable("userId") Long userId) {
        return AjaxResult.success(userRoleService.getUserVo(userId));
    }

    @GetMapping(value = "/role/detail/{roleId}")
    public AjaxResult detailRoleVo(@PathVariable("roleId") Long roleId) {
        return AjaxResult.success(userRoleService.getRoleVo(roleId));
    }
}
