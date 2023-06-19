package club.cupk.group06.api.core.service;

import club.cupk.group06.data.core.common.QueryTime;
import club.cupk.group06.data.core.domain.Indicator;
import club.cupk.group06.data.core.domain.Record;
import club.cupk.group06.data.core.domain.Well;
import club.cupk.group06.data.core.vo.record.IndicatorVo;
import club.cupk.group06.data.core.vo.record.RecordVo;
import club.cupk.group06.data.core.vo.record.WellRecordVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface RecordService extends IService<Record> {

    /**

     获取指定井的记录信息。
     @param wellId 井的ID。
     @return 井记录的 WellRecordVo 对象。
     */
    WellRecordVo getRecordVo(Long wellId);
    /**

     根据井和查询时间获取井记录列表。
     @param well 井对象。
     @param queryTime 查询时间对象。
     @return 井记录的 WellRecordVo 列表。
     */
    List<WellRecordVo> listVo(Well well, QueryTime queryTime);
    /**

     过滤井记录列表中的井信息。
     @param wellVoList 井记录的 WellRecordVo 列表。
     @return 过滤后的井记录列表。
     */
    List<WellRecordVo> filterWell(List<WellRecordVo> wellVoList);
    /**

     过滤井记录中的井信息。
     @param wellVo 井记录的 WellRecordVo 对象。
     @return 过滤后的井记录。
     */
    WellRecordVo filterWell(WellRecordVo wellVo);
    /**

     根据分页信息和条件查询井记录列表。
     @param page 分页信息。
     @param wellVoList 查询条件。
     @return 分页的井记录结果。
     */
    IPage<WellRecordVo> pageVo(IPage<Well> page, Well wellVoList);
    /**

     获取指定指标的详细信息。
     @param indicatorId 指标的ID。
     @return 指标的 IndicatorVo 对象。
     */
    IndicatorVo getIndicatorVo(Long indicatorId);
    /**

     根据条件查询指标列表。
     @param indicator 查询条件。
     @return 指标的 IndicatorVo 列表。
     */
    List<IndicatorVo> listVo(Indicator indicator);
    /**

     根据分页信息和条件查询指标列表。
     @param page 分页信息。
     @param indicator 查询条件。
     @return 分页的指标结果。
     */
    IPage<IndicatorVo> pageVo(IPage<Indicator> page, Indicator indicator);
    /**

     根据分页信息和条件查询记录列表。
     @param page 分页信息。
     @param record 查询条件。
     @return 分页的记录结果。
     */
    Page getPage(Page page, Record record);
    /**

     根据条件查询记录列表。
     @param record 查询条件。
     @return 记录列表。
     */
    List<Record> getList(Record record);
    /**

     根据分页信息和条件查询井记录列表。
     @param page 分页信息。
     @param record 查询条件。
     @return 分页的井记录结果。
     */
    IPage<RecordVo> recordWellVoIPage(IPage<Record> page, Record record);
    /**

     根据分页信息、井和查询时间获取井产品列表。
     @param page 分页信息。
     @param well 井对象。
     @param queryTime 查询时间对象。
     @return 分页的井产品结果。
     */
    IPage<WellRecordVo> pageProductVo(IPage<Well> page, Well well, QueryTime queryTime);
}
