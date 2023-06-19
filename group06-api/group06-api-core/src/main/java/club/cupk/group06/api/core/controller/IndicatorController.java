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
        return AjaxResult.success(indicatorService.getList(indicator));
    }

    @PostMapping("/add")
    public AjaxResult add(@RequestBody Indicator indicator) {
        return AjaxResult.success(indicatorService.save(indicator));
    }

    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody Indicator indicator) {
        return AjaxResult.success(indicatorService.updateById(indicator));
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
}
