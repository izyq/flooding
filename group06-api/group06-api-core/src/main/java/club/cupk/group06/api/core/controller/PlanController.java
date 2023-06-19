package club.cupk.group06.api.core.controller;

import club.cupk.group06.api.core.service.PlanService;
import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.core.domain.Plan;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.cms.common.entity.PageEntity;

@RestController
@RequestMapping("/waterflood/water/flooding/plan")
@AllArgsConstructor
public class PlanController {

    private PlanService planService;

    /**

     分页查询计划列表。
     @param pageEntity 分页参数实体。
     @param plan 计划对象。
     @return 包含计划分页结果的 AjaxResult 对象。
     */
    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity, Plan plan) {
        return AjaxResult.success(planService.getPage(pageEntity.toPage(), plan));
    }
    /**

     获取计划列表。
     @param plan 计划对象。
     @return 包含计划列表的 AjaxResult 对象。
     */
    @GetMapping("/list")
    public AjaxResult list(Plan plan) {
        return AjaxResult.success(planService.getList(plan));
    }
}
