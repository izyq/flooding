package club.cupk.group06.api.core.controller;

import club.cupk.group06.common.web.vo.AjaxResult;
import club.cupk.waterflood.domain.WaterFloodingPlan;
import club.cupk.waterflood.service.IWaterFloodingPlanService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.cms.common.entity.PageEntity;
@RestController
@RequestMapping("/waterflood/water/flooding/plan")
public class WaterFloodingPlanController{
    @DubboReference(check = false)
    private IWaterFloodingPlanService waterFloodingPlanService;
    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity, WaterFloodingPlan waterFloodingPlan){
        return AjaxResult.success(waterFloodingPlanService.getPage(pageEntity.toPage(), waterFloodingPlan));
    }
    @GetMapping("/list")
    public AjaxResult list(WaterFloodingPlan waterFloodingPlan){
        return AjaxResult.success(waterFloodingPlanService.getList(waterFloodingPlan));
    }
}
