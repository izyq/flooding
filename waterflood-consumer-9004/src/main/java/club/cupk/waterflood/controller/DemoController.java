package club.cupk.waterflood.controller;

import club.cupk.waterflood.domain.Field;
import club.cupk.waterflood.service.IFieldService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.PageEntity;

import java.util.Arrays;

/**
 * @author wangdaff
 * @date 2023-06-13 01:54
 * @description
 */
@RestController
public class DemoController {
    @DubboReference
    private IFieldService fieldService;

    @GetMapping("/page")
    public Object page(PageEntity pageEntity,Field field){
        return fieldService.page(pageEntity.toPage(), Wrappers.lambdaQuery(field));
    }
    @GetMapping("/list")
    public Object list(Field field){
        return fieldService.list(Wrappers.lambdaQuery(field));
    }
    @PostMapping("/push")
    public Object add(@RequestBody Field field) {
        return fieldService.save(field);
    }
    @PutMapping("/edit")
    public Object edit(@RequestBody Field field) {
        return fieldService.updateById(field);
    }
    @DeleteMapping("/delete/{fieldIds}")
    public Object delete(@PathVariable Long[] fieldIds) {
        return fieldService.removeByIds(Arrays.asList(fieldIds));
    }
    @GetMapping(value = "/detail/{fieldId}")
    public Object detail(@PathVariable("fieldId") Long fieldId) {
        return fieldService.getById(fieldId);
    }
}
