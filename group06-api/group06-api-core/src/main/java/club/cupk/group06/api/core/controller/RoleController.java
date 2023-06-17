package club.cupk.group06.api.core.controller;

import club.cupk.group06.api.core.service.IRoleService;
import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.core.domain.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.PageEntity;

import java.util.Arrays;

@RestController
@RequestMapping("/waterflood/role")
@RequiredArgsConstructor
public class RoleController {
    private IRoleService roleService;

    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity, Role role) {
        return AjaxResult.success(roleService.getPage(pageEntity.toPage(), role));
    }

    @GetMapping("/list")
    public AjaxResult list(Role role) {
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
