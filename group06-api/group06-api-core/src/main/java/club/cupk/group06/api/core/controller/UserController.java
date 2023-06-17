package club.cupk.group06.api.core.controller;

import club.cupk.group06.common.web.vo.AjaxResult;
import club.cupk.waterflood.domain.User;
import club.cupk.waterflood.service.IUserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.PageEntity;

import java.util.Arrays;
@RestController
@RequestMapping("/waterflood/user")
public class UserController{
    @DubboReference(check = false)
    private IUserService userService;
    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity, User user){
        return AjaxResult.success(userService.getPage(pageEntity.toPage(),user));
    }
    @GetMapping("/list")
    public AjaxResult list(User user){
        return AjaxResult.success(userService.getList(user));
    }
    @PostMapping("/push")
    public AjaxResult add(@RequestBody User user) {
        return AjaxResult.success(userService.save(user));
    }
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody User user) {
        return AjaxResult.success(userService.updateById(user));
    }
    @DeleteMapping("/delete/{userIds}")
    public AjaxResult delete(@PathVariable Long[] userIds) {
        return AjaxResult.success(userService.removeByIds(Arrays.asList(userIds)));
    }
    @GetMapping(value = "/detail/{userId}")
    public AjaxResult detail(@PathVariable("userId") Long userId) {
        return AjaxResult.success(userService.getById(userId));
    }
}
