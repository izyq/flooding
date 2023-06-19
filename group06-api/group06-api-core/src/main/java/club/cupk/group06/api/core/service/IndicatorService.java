package club.cupk.group06.api.core.service;

import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.core.domain.Indicator;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IndicatorService extends IService<Indicator> {

    /**

     根据指标名称、淹没计划和指标类型进行分页查询 Indicator。
     @param page 分页对象。
     @param indicatorName 指标名称。
     @param floodingPlan 淹没计划。
     @param indicatorType 指标类型。
     @return 分页结果的 Indicator 对象。
     */
    IPage<Indicator> pageIndicator(IPage<Indicator> page, String indicatorName, String floodingPlan, String indicatorType);
    /**

     根据条件查询 Indicator 列表。
     @param indicator Indicator 对象。
     @return Indicator 列表。
     */
    List<Indicator> getList(Indicator indicator);
    /**

     级联删除指标。
     @param indicatorIds 指标ID数组。
     @return 操作结果的 AjaxResult 对象。
     */
    AjaxResult removeCascade(Long[] indicatorIds);
    /**

     根据指标ID获取指标详情。
     @param indicatorId 指标ID。
     @return 指标详情。
     */
    AjaxResult getDetailById(Long indicatorId);
}
