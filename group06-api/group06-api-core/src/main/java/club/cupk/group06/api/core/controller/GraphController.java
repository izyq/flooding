package club.cupk.group06.api.core.controller;

import club.cupk.group06.api.core.service.GraphService;
import club.cupk.group06.common.web.response.AjaxResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.PageEntity;

import java.time.Year;

/**
 * @author wangdaff
 * @date 2023-06-16 16:45
 * @description
 */
@RestController
@RequestMapping("/graph")
@AllArgsConstructor
public class GraphController {

    /**

     GraphService 的私有字段。
     */
    private GraphService graphService;
    /**

     添加可视化指标。
     @param indicatorId 可视化指标ID。
     @return 包含添加可视化指标结果的 AjaxResult 对象。
     */
    @PostMapping("/indicator/add")
    public AjaxResult addVisualIndicator(@RequestParam Integer indicatorId) {
        return graphService.addVisualIndicator(indicatorId);
    }
    /**

     获取可视化指标。
     @return 包含可视化指标的 AjaxResult 对象。
     */
    @GetMapping("/get-indicator")
    public AjaxResult getVisualIndicator() {
        return graphService.getVisualIndicator();
    }
    /**

     获取图形数据。
     @param pageEntity 分页参数实体。
     @param indicatorId 指标ID。
     @param year 年份。
     @param factory 工厂名称。
     @return 包含图形数据的 AjaxResult 对象。
     */
    @GetMapping("/get")
    public AjaxResult getGraph(PageEntity pageEntity, Long indicatorId, Long year, String factory) {
        return graphService.getGraph(pageEntity.toPage(), indicatorId, year, factory);
    }
}
