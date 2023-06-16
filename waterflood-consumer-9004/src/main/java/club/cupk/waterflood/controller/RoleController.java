package club.cupk.waterflood.controller;

import club.cupk.waterflood.common.vo.AjaxResult;
import club.cupk.waterflood.domain.Role;
import club.cupk.waterflood.service.IRoleService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.PageEntity;

import java.util.Arrays;
@RestController
@RequestMapping("/waterflood/role")
public class RoleController{
    @DubboReference(check = false)
    private IRoleService roleService;
    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity,Role role){
        return AjaxResult.success(roleService.getPage(pageEntity.toPage(),role));
    }
    @GetMapping("/list")
    public AjaxResult list(Role role){
        return AjaxResult.success(roleService.getList(role));
    }
    @PostMapping("/push")
    public AjaxResult add(@RequestBody Role role) {
        return AjaxResult.success(roleService.save(role));
    }
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody Role role) {
        return AjaxResult.success(roleService.updateById(role));
    }
    @DeleteMapping("/delete/{roleIds}")
    public AjaxResult delete(@PathVariable Long[] roleIds) {
        return AjaxResult.success(roleService.removeByIds(Arrays.asList(roleIds)));
    }
    @GetMapping(value = "/detail/{roleId}")
    public AjaxResult detail(@PathVariable("roleId") Long roleId) {
        return AjaxResult.success(roleService.getById(roleId));
    }
}
