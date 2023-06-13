package club.cupk.waterflood.controller;

import club.cupk.waterflood.domain.Indicator;
import club.cupk.waterflood.domain.WaterFloodingRecord;
import club.cupk.waterflood.domain.Well;
import club.cupk.waterflood.service.IWaterFloodingRecordService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.AjaxResult;
import xin.altitude.cms.common.entity.PageEntity;

import java.util.Arrays;
@RestController
@RequestMapping("/waterflood/water/flooding/record")
public class WaterFloodingRecordController{
    @DubboReference(check = false)
    private IWaterFloodingRecordService waterFloodingRecordService;
    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity,WaterFloodingRecord waterFloodingRecord){
        return AjaxResult.success(waterFloodingRecordService.page(pageEntity.toPage(), Wrappers.lambdaQuery(waterFloodingRecord)));
    }
    @GetMapping("/list")
    public AjaxResult list(WaterFloodingRecord waterFloodingRecord){
        return AjaxResult.success(waterFloodingRecordService.list(Wrappers.lambdaQuery(waterFloodingRecord)));
    }
    @PostMapping("/push")
    public AjaxResult add(@RequestBody WaterFloodingRecord waterFloodingRecord) {
        return AjaxResult.success(waterFloodingRecordService.save(waterFloodingRecord));
    }
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody WaterFloodingRecord waterFloodingRecord) {
        return AjaxResult.success(waterFloodingRecordService.updateById(waterFloodingRecord));
    }
    @DeleteMapping("/delete/{recordIds}")
    public AjaxResult delete(@PathVariable Long[] recordIds) {
        return AjaxResult.success(waterFloodingRecordService.removeByIds(Arrays.asList(recordIds)));
    }
    @GetMapping(value = "/detail/{recordId}")
    public AjaxResult detail(@PathVariable("recordId") Long recordId) {
        return AjaxResult.success(waterFloodingRecordService.getById(recordId));
    }
    @GetMapping("/well/page")
    public AjaxResult pageVo(PageEntity pageEntity,Well well){
        return AjaxResult.success(waterFloodingRecordService.pageVo(pageEntity.toPage(), well));
    }
    @GetMapping("/indicator/page")
    public AjaxResult pageVo(PageEntity pageEntity,Indicator indicator){
        return AjaxResult.success(waterFloodingRecordService.pageVo(pageEntity.toPage(), indicator));
    }
    @GetMapping("/well/list")
    public AjaxResult listVo(Well well){
        return AjaxResult.success(waterFloodingRecordService.listVo(well));
    }
    @GetMapping("/indicator/list")
    public AjaxResult listVo(Indicator indicator){
        return AjaxResult.success(waterFloodingRecordService.listVo(indicator));
    }
    @GetMapping(value = "/well/detail/{wellId}")
    public AjaxResult detailWellVo(@PathVariable("wellId") Long wellId) {
        return AjaxResult.success(waterFloodingRecordService.getWellVo(wellId));
    }
    @GetMapping(value = "/indicator/detail/{indicatorId}")
    public AjaxResult detailIndicatorVo(@PathVariable("indicatorId") Long indicatorId) {
        return AjaxResult.success(waterFloodingRecordService.getIndicatorVo(indicatorId));
    }
}
