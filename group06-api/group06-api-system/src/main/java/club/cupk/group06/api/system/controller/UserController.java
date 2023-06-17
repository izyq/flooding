package club.cupk.group06.api.system.controller;

import club.cupk.group06.api.system.service.UserService;
import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.system.domain.UserPo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.PageEntity;

import java.util.Arrays;

@RestController
@RequestMapping("/waterflood/user")
@RequiredArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity, UserPo userPo) {
        return AjaxResult.success(userService.getPage(pageEntity.toPage(), userPo));
    }

    @GetMapping("/list")
    public AjaxResult list(UserPo userPo) {
        return AjaxResult.success(userService.getList(userPo));
    }

    @PostMapping("/push")
    public AjaxResult add(@RequestBody UserPo userPo) {
        return AjaxResult.success(userService.save(userPo));
    }

    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody UserPo userPo) {
        return AjaxResult.success(userService.updateById(userPo));
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
