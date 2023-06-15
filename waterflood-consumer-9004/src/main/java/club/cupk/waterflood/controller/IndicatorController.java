package club.cupk.waterflood.controller;

import club.cupk.waterflood.common.vo.AjaxResult;
import club.cupk.waterflood.domain.Indicator;
import club.cupk.waterflood.service.IIndicatorService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.PageEntity;

import java.util.Arrays;
@RestController
@RequestMapping("/waterflood/indicator")
public class IndicatorController{
    @DubboReference(check = false)
    private IIndicatorService indicatorService;
    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity,Indicator indicator){
        return AjaxResult.success(indicatorService.getPage(pageEntity.toPage(),indicator));
    }
    @GetMapping("/list")
    public AjaxResult list(Indicator indicator){
        return AjaxResult.success(indicatorService.getList(indicator));
    }
    @PostMapping("/push")
    public AjaxResult add(@RequestBody Indicator indicator) {
        return AjaxResult.success(indicatorService.save(indicator));
    }
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody Indicator indicator) {
        return AjaxResult.success(indicatorService.updateById(indicator));
    }
    @DeleteMapping("/delete/{indicatorIds}")
    public AjaxResult delete(@PathVariable Long[] indicatorIds) {
        return AjaxResult.success(indicatorService.removeByIds(Arrays.asList(indicatorIds)));
    }
    @GetMapping(value = "/detail/{indicatorId}")
    public AjaxResult detail(@PathVariable("indicatorId") Long indicatorId) {
        return AjaxResult.success(indicatorService.getById(indicatorId));
    }
    @GetMapping("/vo/page")
    public AjaxResult pageVo(PageEntity pageEntity,Indicator indicator){
        return AjaxResult.success(indicatorService.pageVo(pageEntity.toPage(), indicator));
    }
    @GetMapping("/vo/list")
    public AjaxResult listVo(Indicator indicator){
        return AjaxResult.success(indicatorService.listVo(indicator));
    }
    @GetMapping(value = "/vo/detail/{indicatorId}")
    public AjaxResult detailVo(@PathVariable("indicatorId") Long indicatorId) {
        return AjaxResult.success(indicatorService.getOneVo(indicatorId));
    }
}
