package club.cupk.group06.api.core.controller;

import club.cupk.group06.api.core.service.FieldService;
import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.core.domain.Field;
import club.cupk.group06.data.core.dto.filed.EditFieldDTO;
import club.cupk.group06.data.core.dto.filed.FieldDTO;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.PageEntity;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/asset/field")
@AllArgsConstructor
public class FieldController {

    private FieldService fieldService;

    @GetMapping("/page")
    public AjaxResult page(@NotNull PageEntity pageEntity, String fieldName, String fieldAddress) {
        return AjaxResult.success(fieldService.pageField(pageEntity.toPage(), fieldName, fieldAddress));
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

    @DeleteMapping("/delete/{fieldId}")
    public AjaxResult delete(@PathVariable Long fieldId) {
        return AjaxResult.success(fieldService.deleteField(fieldId));
    }

    @GetMapping(value = "/detail/{fieldId}")
    public AjaxResult detail(@PathVariable("fieldId") Long fieldId) {
        return AjaxResult.success(fieldService.getById(fieldId));
    }

    @GetMapping("/list")
    public AjaxResult list(@RequestBody Map<String, Object> data) {
        String name = data.get("name").toString();
        String fieldAddress = data.get("fieldAddress").toString();
        List<Field> list = fieldService.getList(Field.builder().fieldAddress(fieldAddress).fieldName(name).build());
        return AjaxResult.success(list);
    }
}
