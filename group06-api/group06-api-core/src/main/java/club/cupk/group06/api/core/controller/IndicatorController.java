package club.cupk.group06.api.core.controller;

import club.cupk.group06.api.core.service.IIndicatorService;
import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.core.domain.Indicator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.PageEntity;

import java.util.Arrays;

@RestController
@RequestMapping("/data/indicator")
@RequiredArgsConstructor
public class IndicatorController {
    private IIndicatorService indicatorService;

    @GetMapping("/page")
    public AjaxResult pageName(PageEntity pageEntity, String name) {
        return indicatorService.getIndicatorByName(pageEntity.toPage(), Indicator.builder().indicatorName(name).build());
    }

    @GetMapping("/pageAll")
    public AjaxResult page(PageEntity pageEntity, Indicator indicator) {
        try {
            return AjaxResult.success(indicatorService.getPage(pageEntity.toPage(), indicator));
        } catch (Exception e) {
            return AjaxResult.error();
        }

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

    @DeleteMapping("/delete/{indicatorIds}")
    public AjaxResult delete(@PathVariable Long[] indicatorIds) {
        return AjaxResult.success(indicatorService.removeByIds(Arrays.asList(indicatorIds)));
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
