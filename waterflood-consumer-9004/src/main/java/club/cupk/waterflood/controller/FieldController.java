package club.cupk.waterflood.controller;

import club.cupk.waterflood.domain.Field;
import club.cupk.waterflood.dto.filed.EditFieldDTO;
import club.cupk.waterflood.dto.filed.FieldDTO;
import club.cupk.waterflood.service.IFieldService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.AjaxResult;
import xin.altitude.cms.common.entity.PageEntity;

@RestController
@RequestMapping("/asset/field/")
public class FieldController{
    @DubboReference
    private IFieldService fieldService;
    @GetMapping("/page")
    public Object page(PageEntity pageEntity,String name){
        return fieldService.page(pageEntity.toPage(), Wrappers.lambdaQuery(Field.builder().fieldName(name).build()));
    }
    @PutMapping("/add")
    public Object add(@RequestBody FieldDTO field) {

        return fieldService.save(Field
                .builder()
                .fieldName(field.getName())
                .fieldDesc(field.getDesc())
                .fieldArea(field.getArea())
                .fieldAddress(field.getAddress())
                .build()
        );
    }
    @PostMapping("/edit")
    public Object edit(@RequestBody EditFieldDTO field) {
        return fieldService.updateById(Field
                .builder()
                .fieldId(field.getId())
                .fieldName(field.getName())
                .fieldDesc(field.getDesc())
                .fieldArea(field.getArea())
                .fieldAddress(field.getAddress())
                .build());
    }
    @DeleteMapping("/delete/{id}")
    public Object delete(@PathVariable Long fieldId) {
        return fieldService.removeById(fieldId);
    }
    @GetMapping(value = "/detail/{fieldId}")
    public AjaxResult detail(@PathVariable("fieldId") Long fieldId) {
        return AjaxResult.success(fieldService.getById(fieldId));
    }
    @GetMapping("/list")
    public AjaxResult list(String name){
        return AjaxResult.success(fieldService.getList(Field.builder().fieldName(name).build()));
    }
}
