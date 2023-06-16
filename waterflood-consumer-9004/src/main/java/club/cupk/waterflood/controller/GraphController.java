package club.cupk.waterflood.controller;

import club.cupk.waterflood.common.vo.AjaxResult;
import club.cupk.waterflood.service.IGraphService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.dubbo.config.annotation.DubboReference;
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
public class GraphController {

    @DubboReference
    IGraphService graphService;

    @PostMapping("/indicator/add")
    public AjaxResult addVisualIndicator(@RequestParam Integer indicatorId){
        return graphService.addVisualIndicator(indicatorId);
    }

    @GetMapping("/get-indicator")
    public AjaxResult getVisualIndicator(){
        return graphService.getVisualIndicator();
    }

    @GetMapping("/get")
    public AjaxResult getGraph(PageEntity pageEntity, Year year, String factory){
        return graphService.getGraph(pageEntity.toPage(),year,factory);
    }
}
