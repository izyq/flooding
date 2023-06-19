package club.cupk.group06.api.core.controller;

import club.cupk.group06.api.core.service.FieldService;
import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.core.domain.Field;
import club.cupk.group06.data.core.dto.filed.EditFieldDTO;
import club.cupk.group06.data.core.dto.filed.FieldDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.PageEntity;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/asset/field")
@AllArgsConstructor
@Slf4j
public class FieldController {

    /**

     FieldService 的私有字段。
     */
    private FieldService fieldService;
    /**

     分页查询油田列表。
     @param pageEntity 分页参数实体。
     @param fieldName 油田名称。
     @param fieldAddress 油田地址。
     @return 包含油田分页结果的 AjaxResult 对象。
     */
    @GetMapping("/page")
    public AjaxResult page(@NotNull PageEntity pageEntity, String fieldName, String fieldAddress) {
        return AjaxResult.success(fieldService.pageField(pageEntity.toPage(), fieldName, fieldAddress));
    }
    /**

     添加油田。
     @param field 油田数据传输对象。
     @return 包含添加油田结果的 AjaxResult 对象。
     */
    @PostMapping("/add")
    public AjaxResult add(@RequestBody FieldDTO field) {
        log.info("添加油田-=-------------------------------");
        return AjaxResult.success(fieldService.save(Field
                .builder()
                .fieldName(field.getName())
                .fieldDesc(field.getDesc())
                .fieldArea(field.getArea())
                .fieldAddress(field.getAddress())
                .build()
        ));
    }
    /**

     编辑油田。
     @param field 编辑的油田数据传输对象。
     @return 包含编辑后的油田对象的 AjaxResult 对象。
     */
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody EditFieldDTO field) {
        log.info("编辑油田-=-------------------------------");
        return AjaxResult.success(fieldService.updateById(Field
                .builder()
                .fieldId(field.getId())
                .fieldName(field.getName())
                .fieldDesc(field.getDesc())
                .fieldArea(field.getArea())
                .fieldAddress(field.getAddress())
                .build()));
    }
    /**

     删除油田。
     @param fieldId 要删除的油田ID。
     @return 表示删除油田操作结果的 AjaxResult 对象。
     */
    @DeleteMapping("/delete/{fieldId}")
    public AjaxResult delete(@PathVariable Long fieldId) {
        log.warn("删除油田-=-------------------------------");
        return AjaxResult.success(fieldService.deleteField(fieldId));
    }
    /**

     获取油田详情。
     @param fieldId 油田ID。
     @return 包含油田详情的 AjaxResult 对象。
     */
    @GetMapping(value = "/detail/{fieldId}")
    public AjaxResult detail(@PathVariable("fieldId") Long fieldId) {
        return AjaxResult.success(fieldService.getById(fieldId));
    }
    /**

     查询油田列表。
     @param fieldName 油田名称。
     @return 包含油田列表的 AjaxResult 对象。
     */
    @GetMapping("/list")
    public AjaxResult list(String fieldName) {
        return AjaxResult.success(fieldService.getList(fieldName));
    }
}
