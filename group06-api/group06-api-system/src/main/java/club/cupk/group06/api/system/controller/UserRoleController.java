package club.cupk.group06.api.system.controller;

import club.cupk.group06.api.system.service.UserRoleService;
import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.system.domain.Role;
import club.cupk.group06.data.system.domain.UserPo;
import club.cupk.group06.data.system.domain.UserRole;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.PageEntity;

import javax.annotation.Resource;
import java.util.Arrays;

@RestController
@RequestMapping("/user/role")
@AllArgsConstructor
public class UserRoleController {

    /**

     用户角色管理类。
     */
    @Resource
    private UserRoleService userRoleService;
    /**

     获取用户角色的分页数据。
     @param pageEntity 分页信息。
     @param userRole 用户角色过滤条件。
     @return 包含用户角色分页数据的 AjaxResult 对象。
     */
    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity, UserRole userRole) {
        return AjaxResult.success(userRoleService.getPage(pageEntity.toPage(), userRole));
    }
    /**

     获取用户角色列表。
     @param userRole 用户角色过滤条件。
     @return 包含用户角色列表的 AjaxResult 对象。
     */
    @GetMapping("/list")
    public AjaxResult list(UserRole userRole) {
        return AjaxResult.success(userRoleService.getList(userRole));
    }
    /**

     添加新的用户角色。
     @param userRole 要添加的用户角色。
     @return 表示操作成功的 AjaxResult 对象。
     */
    @PostMapping("/push")
    public AjaxResult add(@RequestBody UserRole userRole) {
        return AjaxResult.success(userRoleService.save(userRole));
    }
    /**

     更新现有用户角色。
     @param userRole 要更新的用户角色。
     @return 表示操作成功的 AjaxResult 对象。
     */
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody UserRole userRole) {
        return AjaxResult.success(userRoleService.updateById(userRole));
    }
    /**

     根据ID删除用户角色。
     @param roleIds 要删除的用户角色ID数组。
     @return 表示操作成功的 AjaxResult 对象。
     */
    @DeleteMapping("/delete/{roleIds}")
    public AjaxResult delete(@PathVariable Long[] roleIds) {
        return AjaxResult.success(userRoleService.removeByIds(Arrays.asList(roleIds)));
    }
    /**

     根据角色ID获取用户角色的详细信息。
     @param roleId 角色ID。
     @return 包含用户角色详细信息的 AjaxResult 对象。
     */
    @GetMapping(value = "/detail/{roleId}")
    public AjaxResult detail(@PathVariable("roleId") Long roleId) {
        return AjaxResult.success(userRoleService.getById(roleId));
    }
    /**

     获取用户角色视图的分页数据。
     @param pageEntity 分页信息。
     @param userPo 用户信息过滤条件。
     @return 包含用户角色视图分页数据的 AjaxResult 对象。
     */
    @GetMapping("/user/page")
    public AjaxResult pageVo(PageEntity pageEntity, UserPo userPo) {
        return AjaxResult.success(userRoleService.pageVo(pageEntity.toPage(), userPo));
    }
    /**

     获取角色视图的分页数据。
     @param pageEntity 分页信息。
     @param role 角色过滤条件。
     @return 包含角色视图分页数据的 AjaxResult 对象。
     */
    @GetMapping("/role/page")
    public AjaxResult pageVo(PageEntity pageEntity, Role role) {
        return AjaxResult.success(userRoleService.pageVo(pageEntity.toPage(), role));
    }
    /**

     获取用户信息列表。
     @param userPo 用户信息过滤条件。
     @return 包含用户信息列表的 AjaxResult 对象。
     */
    @GetMapping("/user/list")
    public AjaxResult listVo(UserPo userPo) {
        return AjaxResult.success(userRoleService.listVo(userPo));
    }
    /**

     获取角色列表。
     @param role 角色过滤条件。
     @return 包含角色列表的 AjaxResult 对象。
     */
    @GetMapping("/role/list")
    public AjaxResult listVo(Role role) {
        return AjaxResult.success(userRoleService.listVo(role));
    }
    /**

     根据用户ID获取用户视图的详细信息。
     @param userId 用户ID。
     @return 包含用户视图详细信息的 AjaxResult 对象。
     */
    @GetMapping(value = "/user/detail/{userId}")
    public AjaxResult detailUserVo(@PathVariable("userId") Long userId) {
        return AjaxResult.success(userRoleService.getUserVo(userId));
    }
    /**

     根据角色ID获取角色视图的详细信息。
     @param roleId 角色ID。
     @return 包含角色视图详细信息的 AjaxResult 对象。
     */
    @GetMapping(value = "/role/detail/{roleId}")
    public AjaxResult detailRoleVo(@PathVariable("roleId") Long roleId) {
        return AjaxResult.success(userRoleService.getRoleVo(roleId));
    }
}
