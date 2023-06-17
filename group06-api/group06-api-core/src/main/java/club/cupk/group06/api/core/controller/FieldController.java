package club.cupk.group06.api.core.controller;

import club.cupk.group06.api.core.service.IFieldService;
import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.core.domain.Field;
import club.cupk.group06.data.core.dto.filed.EditFieldDTO;
import club.cupk.waterflood.dto.filed.FieldDTO;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.PageEntity;

import java.util.List;

@RestController
@RequestMapping("/asset/field/")
public class FieldController {
    private IFieldService fieldService;

    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity, String name) {
        return AjaxResult.success(fieldService.getPage(pageEntity.toPage(), Field.builder().fieldName(name).build()));
    }

    @PostMapping("/add")
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

    @PutMapping("/edit")
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
        try {
            return AjaxResult.success(fieldService.deleteField(id));
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

    @GetMapping(value = "/detail/{fieldId}")
    public AjaxResult detail(@PathVariable("fieldId") Long fieldId) {
        return AjaxResult.success(fieldService.getById(fieldId));
    }

    @GetMapping("/list")
    public AjaxResult list(String name) {
        List<Field> list = fieldService.getList(Field.builder().fieldName(name).build());
        return AjaxResult.success(list);
    }
}
