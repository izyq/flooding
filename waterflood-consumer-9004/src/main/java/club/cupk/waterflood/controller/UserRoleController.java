package club.cupk.waterflood.controller;

import club.cupk.waterflood.domain.Role;
import club.cupk.waterflood.domain.User;
import club.cupk.waterflood.domain.UserRole;
import club.cupk.waterflood.service.IUserRoleService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.AjaxResult;
import xin.altitude.cms.common.entity.PageEntity;

import java.util.Arrays;
@RestController
@RequestMapping("/waterflood/user/role")
public class UserRoleController{
    @DubboReference(check = false)
    private IUserRoleService userRoleService;
    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity,UserRole userRole){
        return AjaxResult.success(userRoleService.page(pageEntity.toPage(), Wrappers.lambdaQuery(userRole)));
    }
    @GetMapping("/list")
    public AjaxResult list(UserRole userRole){
        return AjaxResult.success(userRoleService.list(Wrappers.lambdaQuery(userRole)));
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
    public AjaxResult pageVo(PageEntity pageEntity,User user){
        return AjaxResult.success(userRoleService.pageVo(pageEntity.toPage(), user));
    }
    @GetMapping("/role/page")
    public AjaxResult pageVo(PageEntity pageEntity,Role role){
        return AjaxResult.success(userRoleService.pageVo(pageEntity.toPage(), role));
    }
    @GetMapping("/user/list")
    public AjaxResult listVo(User user){
        return AjaxResult.success(userRoleService.listVo(user));
    }
    @GetMapping("/role/list")
    public AjaxResult listVo(Role role){
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
