package club.cupk.group06.api.core.controller;

import club.cupk.group06.api.core.service.IndicatorService;
import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.core.domain.Indicator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.PageEntity;

import java.util.Arrays;

@RestController
@RequestMapping("/data/indicator")
@AllArgsConstructor
@Slf4j
public class IndicatorController {

    /**

     IndicatorService 的私有字段。
     */
    private IndicatorService indicatorService;
    /**

     分页查询指标列表。
     @param pageEntity 分页参数实体。
     @param indicatorName 指标名称。
     @param floodingPlan 淹没计划。
     @param indicatorType 指标类型。
     @return 包含指标分页结果的 AjaxResult 对象。
     */
    @GetMapping("/page")
    public AjaxResult page(@NotNull PageEntity pageEntity, String indicatorName, String floodingPlan, String indicatorType) {
        return AjaxResult.success(indicatorService.pageIndicator(pageEntity.toPage(), indicatorName, floodingPlan, indicatorType));
    }
    /**

     获取指标列表。
     @param indicator 指标对象。
     @return 包含指标列表的 AjaxResult 对象。
     */
    @GetMapping("/list")
    public AjaxResult list(Indicator indicator) {
        return AjaxResult.success(indicatorService.getList(indicator));
    }
    /**

     添加指标。
     @param indicator 指标对象。
     @return 包含添加指标结果的 AjaxResult 对象。
     */
    @PostMapping("/add")
    public AjaxResult add(@RequestBody Indicator indicator) {
        log.info("添加油田-=-------------------------------");
        return AjaxResult.success(indicatorService.save(indicator));
    }
    /**

     编辑指标。
     @param indicator 指标对象。
     @return 包含编辑后的指标对象的 AjaxResult 对象。
     */
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody Indicator indicator) {
        log.info("修改油田-=-------------------------------");
        return AjaxResult.success(indicatorService.updateById(indicator));
    }
    /**

     删除指标。
     @param indicatorId 指标ID。
     @return 表示删除指标操作结果的 AjaxResult 对象。
     */
    @DeleteMapping("/delete/{indicatorId}")
    public AjaxResult delete(@PathVariable Long indicatorId) {
        log.warn("删除油田-=-------------------------------");
        Long[] ids = {indicatorId};
        return AjaxResult.success(indicatorService.removeByIds(Arrays.asList(ids)));
    }
    /**

     获取指标详情。
     @param indicatorId 指标ID。
     @return 包含指标详情的 AjaxResult 对象。
     */
    @GetMapping(value = "/detail/{indicatorId}")
    public AjaxResult detail(@PathVariable("indicatorId") Long indicatorId) {
        return AjaxResult.success(indicatorService.getById(indicatorId));
    }
}
