package club.cupk.group06.api.system.controller;

import club.cupk.group06.api.system.service.RoleService;
import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.system.domain.Role;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.PageEntity;

import java.util.Arrays;

@RestController
@RequestMapping("/role")
@AllArgsConstructor
@Slf4j
public class RoleController {

    private RoleService roleService;

    /**

     根据分页信息和条件查询角色列表。
     @param pageEntity 分页信息。
     @param role 查询条件。
     @return 分页的角色结果。
     */
    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity, Role role) {
        return AjaxResult.success(roleService.getPage(pageEntity.toPage(), role));
    }
    /**

     根据条件查询角色列表。
     @param role 查询条件。
     @return 角色列表。
     */
    @GetMapping("/list")
    public AjaxResult list(Role role) {
        return AjaxResult.success(roleService.getList(role));
    }
    /**

     添加角色信息。
     @param role 角色对象。
     @return 操作结果。
     */
    @PostMapping("/push")
    public AjaxResult add(@RequestBody Role role) {
        log.info("添加角色----------");
        return AjaxResult.success(roleService.save(role));
    }
    /**

     编辑角色信息。
     @param role 角色对象。
     @return 操作结果。
     */
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody Role role) {
        log.info("修改角色----------");
        return AjaxResult.success(roleService.updateById(role));
    }
    /**

     删除角色。
     @param roleIds 角色ID数组。
     @return 操作结果。
     */
    @DeleteMapping("/delete/{roleIds}")
    public AjaxResult delete(@PathVariable Long[] roleIds) {
        log.info("删除角色----------");
        return AjaxResult.success(roleService.removeByIds(Arrays.asList(roleIds)));
    }
    /**

     获取角色的详细信息。
     @param roleId 角色ID。
     @return 角色的详细信息。
     */
    @GetMapping(value = "/detail/{roleId}")
    public AjaxResult detail(@PathVariable("roleId") Long roleId) {
        return AjaxResult.success(roleService.getById(roleId));
    }
}
