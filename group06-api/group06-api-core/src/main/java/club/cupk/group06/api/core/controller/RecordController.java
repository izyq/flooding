package club.cupk.group06.api.core.controller;

import club.cupk.group06.api.core.service.RecordService;
import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.core.common.QueryTime;
import club.cupk.group06.data.core.domain.Indicator;
import club.cupk.group06.data.core.domain.Record;
import club.cupk.group06.data.core.domain.Well;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.PageEntity;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/data/record")
@AllArgsConstructor
@Slf4j
public class RecordController {

    private RecordService recordService;

    /**

     分页查询无用页面。
     @param pageEntity 分页参数实体。
     @param record 记录对象。
     @return 包含无用页面分页结果的 AjaxResult 对象。
     */
    @GetMapping("/uselessPage")
    public AjaxResult uselessPage(PageEntity pageEntity, Record record) {
        return AjaxResult.success(recordService.getPage(pageEntity.toPage(), record));
    }
    /**

     分页查询记录井页面。
     @param pageEntity 分页参数实体。
     @param record 记录对象。
     @return 包含记录井页面分页结果的 AjaxResult 对象。
     */
    @GetMapping("/recordWellPage")
    public AjaxResult recordWellVoPage(PageEntity pageEntity, Record record) {
        return AjaxResult.success(recordService.recordWellVoIPage(pageEntity.toPage(), record));
    }
    /**

     分页查询产品页面。
     @param pageEntity 分页参数实体。
     @param well 井对象。
     @param queryTime 查询时间对象。
     @return 包含产品页面分页结果的 AjaxResult 对象。
     */
    @GetMapping("/page")
    public AjaxResult pageProduct(PageEntity pageEntity, Well well, QueryTime queryTime) {
        return AjaxResult.success(recordService.pageProductVo(pageEntity.toPage(), well, queryTime));
    }
    /**

     获取记录列表。
     @param record 记录对象。
     @return 包含记录列表的 AjaxResult 对象。
     */
    @GetMapping("/list")
    public AjaxResult list(Record record) {
        return AjaxResult.success(recordService.getList(record));
    }
    /**

     添加单个记录。
     @param record 记录对象。
     @return 包含添加结果的 AjaxResult 对象。
     */
    @PostMapping("/addSingle")
    public AjaxResult add(@RequestBody Record record) {
        log.info("添加单个记录-----------------------------------");
        return AjaxResult.success(recordService.save(record));
    }
    /**

     批量添加记录。
     @param records 记录列表。
     @return 包含添加结果的 AjaxResult 对象。
     */
    @PostMapping("/add")
    public AjaxResult add(@RequestBody List<Record> records) {
        log.info("添加多个记录-----------------------------------");
        return AjaxResult.success(recordService.saveBatch(records));
    }
    /**

     编辑记录。
     @param record 记录对象。
     @return 包含编辑结果的 AjaxResult 对象。
     */
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody Record record) {
        return AjaxResult.success(recordService.updateById(record));
    }
    /**

     删除记录。
     @param recordIds 记录ID数组。
     @return 包含删除结果的 AjaxResult 对象。
     */
    @DeleteMapping("/delete/{recordIds}")
    public AjaxResult delete(@PathVariable Long[] recordIds) {
        log.warn("删除记录-----------------------------------");
        return AjaxResult.success(recordService.removeByIds(Arrays.asList(recordIds)));
    }
    /**

     获取记录详情。
     @param recordId 记录ID。
     @return 包含记录详情的 AjaxResult 对象。
     */
    @GetMapping(value = "/detail/{recordId}")
    public AjaxResult detail(@PathVariable("recordId") Long recordId) {
        return AjaxResult.success(recordService.getById(recordId));
    }
    /**

     分页查询井页面。
     @param pageEntity 分页参数实体。
     @param well 井对象。
     @return 包含井页面分页结果的 AjaxResult 对象。
     */
    @GetMapping("/well/page")
    public AjaxResult pageVo(PageEntity pageEntity, Well well) {
        return AjaxResult.success(recordService.pageVo(pageEntity.toPage(), well));
    }
    /**

     分页查询指标页面。
     @param pageEntity 分页参数实体。
     @param indicator 指标对象。
     @return 包含指标页面分页结果的 AjaxResult 对象。
     */
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
