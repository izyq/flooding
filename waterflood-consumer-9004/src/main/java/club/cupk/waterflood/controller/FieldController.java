package club.cupk.waterflood.controller;

import club.cupk.waterflood.common.vo.AjaxResult;
import club.cupk.waterflood.domain.Field;
import club.cupk.waterflood.dto.filed.EditFieldDTO;
import club.cupk.waterflood.dto.filed.FieldDTO;
import club.cupk.waterflood.service.IFieldService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.PageEntity;

import java.util.List;

@RestController
@RequestMapping("/asset/field/")
public class FieldController{
    @DubboReference
    private IFieldService fieldService;
    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity,String name){
        return AjaxResult.success(fieldService.getPage(pageEntity.toPage(), Field.builder().fieldName(name).build()));
    }
    @PutMapping("/add")
    public AjaxResult add(@RequestBody FieldDTO field) {

        return AjaxResult.success(fieldService.save(Field
                .builder()
                .fieldName(field.getName())
                .fieldDesc(field.getDesc())
                .fieldArea(field.getArea())
                .fieldAddress(field.getAddress())
                .build()
        ));
    }
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody EditFieldDTO field) {
        return AjaxResult.success(fieldService.updateById(Field
                .builder()
                .fieldId(field.getId())
                .fieldName(field.getName())
                .fieldDesc(field.getDesc())
                .fieldArea(field.getArea())
                .fieldAddress(field.getAddress())
                .build()));
    }
    @DeleteMapping("/delete/{id}")
    public AjaxResult delete(@PathVariable Long id) {
        return AjaxResult.success(fieldService.removeById(id));
    }
    @GetMapping(value = "/detail/{fieldId}")
    public AjaxResult detail(@PathVariable("fieldId") Long fieldId) {
        return AjaxResult.success(fieldService.getById(fieldId));
    }
    @GetMapping("/list")
    public AjaxResult list(String name){
        List<Field> list = fieldService.getList(Field.builder().fieldName(name).build());
        return AjaxResult.success(list);
    }
}
