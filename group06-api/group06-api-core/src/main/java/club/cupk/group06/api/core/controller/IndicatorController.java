package club.cupk.group06.api.core.controller;

import club.cupk.group06.api.core.service.IndicatorService;
import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.core.domain.Indicator;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.PageEntity;

import java.util.Arrays;

@RestController
@RequestMapping("/data/indicator")
@AllArgsConstructor
public class IndicatorController {

    private IndicatorService indicatorService;

    @GetMapping("/page")
    public AjaxResult page(@NotNull PageEntity pageEntity, String indicatorName, String floodingPlan, String indicatorType) {
        return AjaxResult.success(indicatorService.pageIndicator(pageEntity.toPage(), indicatorName, floodingPlan, indicatorType));
    }

    @GetMapping("/list")
    public AjaxResult list(Indicator indicator) {
        try {
            return AjaxResult.success(indicatorService.getList(indicator));
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

    @PostMapping("/add")
    public AjaxResult add(@RequestBody Indicator indicator) {
        try {
            return AjaxResult.success(indicatorService.save(indicator));
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }

    }

    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody Indicator indicator) {
        try {
            return AjaxResult.success(indicatorService.updateById(indicator));
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }

    }

    @DeleteMapping("/delete/{indicatorId}")
    public AjaxResult delete(@PathVariable Long indicatorId) {
        Long[] ids = {indicatorId};
        return AjaxResult.success(indicatorService.removeByIds(Arrays.asList(ids)));
    }

    @GetMapping(value = "/detail/{indicatorId}")
    public AjaxResult detail(@PathVariable("indicatorId") Long indicatorId) {
        return AjaxResult.success(indicatorService.getById(indicatorId));
    }

//    @GetMapping("/vo/page")
//    public AjaxResult pageVo(PageEntity pageEntity,Indicator indicator){
//        return AjaxResult.success(indicatorService.pageVo(pageEntity.toPage(), indicator));
//    }
//    @GetMapping("/vo/list")
//    public AjaxResult listVo(Indicator indicator){
//        return AjaxResult.success(indicatorService.listVo(indicator));
//    }
//    @GetMapping(value = "/vo/detail/{indicatorId}")
//    public AjaxResult detailVo(@PathVariable("indicatorId") Long indicatorId) {
//        return AjaxResult.success(indicatorService.getOneVo(indicatorId));
//    }
}
