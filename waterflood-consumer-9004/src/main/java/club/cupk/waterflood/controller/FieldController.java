package club.cupk.waterflood.controller;

import club.cupk.waterflood.domain.Field;
import club.cupk.waterflood.service.IFieldService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.AjaxResult;
import xin.altitude.cms.common.entity.PageEntity;

import java.util.Arrays;
@RestController
@RequestMapping("/waterflood/field")
public class FieldController{
    @DubboReference
    private IFieldService fieldService;
    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity,Field field){
        return AjaxResult.success(fieldService.page(pageEntity.toPage(), Wrappers.lambdaQuery(field)));
    }
    @GetMapping("/list")
    public AjaxResult list(Field field){
        return AjaxResult.success(fieldService.list(Wrappers.lambdaQuery(field)));
    }
    @PostMapping("/push")
    public AjaxResult add(@RequestBody Field field) {
        return AjaxResult.success(fieldService.save(field));
    }
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody Field field) {
        return AjaxResult.success(fieldService.updateById(field));
    }
    @DeleteMapping("/delete/{fieldIds}")
    public AjaxResult delete(@PathVariable Long[] fieldIds) {
        return AjaxResult.success(fieldService.removeByIds(Arrays.asList(fieldIds)));
    }
    @GetMapping(value = "/detail/{fieldId}")
    public AjaxResult detail(@PathVariable("fieldId") Long fieldId) {
        return AjaxResult.success(fieldService.getById(fieldId));
    }
}
