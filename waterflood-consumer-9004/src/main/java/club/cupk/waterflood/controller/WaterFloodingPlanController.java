package club.cupk.waterflood.controller;

import club.cupk.waterflood.domain.WaterFloodingPlan;
import club.cupk.waterflood.service.IWaterFloodingPlanService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.cms.common.entity.AjaxResult;
import xin.altitude.cms.common.entity.PageEntity;
@RestController
@RequestMapping("/waterflood/water/flooding/plan")
public class WaterFloodingPlanController{
    @DubboReference
    private IWaterFloodingPlanService waterFloodingPlanService;
    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity,WaterFloodingPlan waterFloodingPlan){
        return AjaxResult.success(waterFloodingPlanService.page(pageEntity.toPage(), Wrappers.lambdaQuery(waterFloodingPlan)));
    }
    @GetMapping("/list")
    public AjaxResult list(WaterFloodingPlan waterFloodingPlan){
        return AjaxResult.success(waterFloodingPlanService.list(Wrappers.lambdaQuery(waterFloodingPlan)));
    }
}
