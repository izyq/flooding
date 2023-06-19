package club.cupk.group06.api.core.controller;

import club.cupk.group06.api.core.service.RecordService;
import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.core.common.QueryTime;
import club.cupk.group06.data.core.domain.Indicator;
import club.cupk.group06.data.core.domain.Record;
import club.cupk.group06.data.core.domain.Well;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.PageEntity;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/data/record")
@AllArgsConstructor
public class RecordController {

    private RecordService recordService;

    @GetMapping("/uselessPage")
    public AjaxResult uselessPage(PageEntity pageEntity, Record record) {
        return AjaxResult.success(recordService.getPage(pageEntity.toPage(), record));
    }

    @GetMapping("/recordWellPage")
    public AjaxResult recordWellVoPage(PageEntity pageEntity, Record record) {
        return AjaxResult.success(recordService.recordWellVoIPage(pageEntity.toPage(), record));
    }

    @GetMapping("/page")
    public AjaxResult pageProduct(PageEntity pageEntity, Well well, QueryTime queryTime) {
        return AjaxResult.success(recordService.pageProductVo(pageEntity.toPage(), well, queryTime));
    }


    @GetMapping("/list")
    public AjaxResult list(Record record) {
        return AjaxResult.success(recordService.getList(record));
    }

    @PostMapping("/addSingle")
    public AjaxResult add(@RequestBody Record record) {
        return AjaxResult.success(recordService.save(record));
    }

    // 批量添加
    @PostMapping("/add")
    public AjaxResult add(@RequestBody List<Record> records) {
        return AjaxResult.success(recordService.saveBatch(records));
    }

    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody Record record) {
        return AjaxResult.success(recordService.updateById(record));
    }

    @DeleteMapping("/delete/{recordIds}")
    public AjaxResult delete(@PathVariable Long[] recordIds) {
        return AjaxResult.success(recordService.removeByIds(Arrays.asList(recordIds)));
    }

    @GetMapping(value = "/detail/{recordId}")
    public AjaxResult detail(@PathVariable("recordId") Long recordId) {
        return AjaxResult.success(recordService.getById(recordId));
    }

    @GetMapping("/well/page")
    public AjaxResult pageVo(PageEntity pageEntity, Well well) {
        return AjaxResult.success(recordService.pageVo(pageEntity.toPage(), well));
    }

    @GetMapping("/indicator/page")
    public AjaxResult pageVo(PageEntity pageEntity, Indicator indicator) {
        return AjaxResult.success(recordService.pageVo(pageEntity.toPage(), indicator));
    }

    /**
     * 根据注水井id查找注水记录和指标
     *
     * @param well
     * @return club.cupk.group06.common.web.vo.AjaxResult
     * @author izyq
     **/
    @GetMapping("/well/list")
    public AjaxResult wellIndicator(QueryTime queryTime, Well well) {
        return AjaxResult.success(recordService.listVo(well,queryTime));
    }

    /**
     * 查找使用该指标的所有井和对应的注水记录
     *
     * @param indicator
     * @return club.cupk.group06.common.web.vo.AjaxResult
     * @author izyq
     **/
    @GetMapping("/indicator/list")
    public AjaxResult indicatorWell(Indicator indicator) {
        return AjaxResult.success(recordService.listVo(indicator));
    }

    @GetMapping(value = "/well/detail/{wellId}")
    public AjaxResult detailWellVo(@PathVariable("wellId") Long wellId) {
        return AjaxResult.success(recordService.getRecordVo(wellId));
    }

    @GetMapping(value = "/indicator/detail/{indicatorId}")
    public AjaxResult detailIndicatorVo(@PathVariable("indicatorId") Long indicatorId) {
        return AjaxResult.success(recordService.getIndicatorVo(indicatorId));
    }
}
