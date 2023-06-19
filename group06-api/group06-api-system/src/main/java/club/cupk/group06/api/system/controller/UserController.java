package club.cupk.group06.api.system.controller;

import club.cupk.group06.api.system.service.UserService;
import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.system.domain.UserPo;
import club.cupk.group06.data.system.dto.UserDto;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.PageEntity;

import javax.annotation.Resource;
import java.util.Arrays;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    @Resource
    private UserService userService;


    /**

     根据查询条件分页获取用户列表。
     @param pageEntity 分页信息。
     @param userPhone 用户手机号。
     @param userName 用户姓名。
     @param userEmail 用户邮箱。
     @param userWell 用户所属井。
     @param userField 用户所属油田。
     @return 分页的用户列表。
     */
    @GetMapping("/get")
    public AjaxResult getUserByQuery(@NotNull PageEntity pageEntity, String userPhone, String userName, String userEmail, String userWell, String userField) {
        return AjaxResult.success(userService.getUserByQuery(pageEntity.toPage(), userPhone, userName, userEmail, userWell, userField));
    }
    /**

     根据分页信息和条件查询用户列表。
     @param pageEntity 分页信息。
     @param userPo 查询条件。
     @return 分页的用户结果。
     */
    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity, UserPo userPo) {
        return AjaxResult.success(userService.getPage(pageEntity.toPage(), userPo));
    }
    /**

     根据条件查询用户列表。
     @param userPo 查询条件。
     @return 用户列表。
     */
    @GetMapping("/list")
    public AjaxResult list(UserPo userPo) {
        return AjaxResult.success(userService.getList(userPo));
    }
    /**

     添加用户信息。
     @param userPo 用户对象。
     @return 操作结果。
     */
    @PostMapping("/push")
    public AjaxResult add(@RequestBody UserPo userPo) {
        return AjaxResult.success(userService.save(userPo));
    }
    /**

     编辑用户信息。
     @param userPo 用户对象。
     @return 操作结果。
     */
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody UserPo userPo) {
        return AjaxResult.success(userService.updateById(userPo));
    }
    /**

     删除用户。
     @param userIds 用户ID数组。
     @return 操作结果。
     */
    @DeleteMapping("/delete/{userIds}")
    public AjaxResult delete(@PathVariable Long[] userIds) {
        return AjaxResult.success(userService.removeByIds(Arrays.asList(userIds)));
    }
    /**

     获取用户的详细信息。
     @param userId 用户ID。
     @return 用户的详细信息。
     */
    @GetMapping(value = "/detail/{userId}")
    public AjaxResult detail(@PathVariable("userId") Long userId) {
        return AjaxResult.success(userService.getById(userId));
    }
}
