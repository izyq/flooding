package club.cupk.group06.api.core.controller;

import club.cupk.group06.api.core.service.WaterFloodingPlanService;
import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.core.domain.WaterFloodingPlan;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.cms.common.entity.PageEntity;

@RestController
@RequestMapping("/waterflood/water/flooding/plan")
@AllArgsConstructor
public class WaterFloodingPlanController {

    private WaterFloodingPlanService waterFloodingPlanService;

    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity, WaterFloodingPlan waterFloodingPlan) {
        return AjaxResult.success(waterFloodingPlanService.getPage(pageEntity.toPage(), waterFloodingPlan));
    }

    @GetMapping("/list")
    public AjaxResult list(WaterFloodingPlan waterFloodingPlan) {
        return AjaxResult.success(waterFloodingPlanService.getList(waterFloodingPlan));
    }
}
