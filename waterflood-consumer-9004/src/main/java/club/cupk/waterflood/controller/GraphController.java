package club.cupk.waterflood.controller;

import club.cupk.waterflood.common.vo.AjaxResult;
import club.cupk.waterflood.service.IGraphService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangdaff
 * @date 2023-06-16 16:45
 * @description
 */
@RestController
@RequestMapping("/graph/get-indicator")
public class GraphController {

    @DubboReference
    IGraphService graphService;

    @PostMapping("/indicator/add")
    public AjaxResult addVisualIndicator(@RequestParam Integer indicatorId){
        return graphService.addVisualIndicator(indicatorId);
    }

    @GetMapping("/indicator/get")
    public AjaxResult getVisualIndicator(){
        return graphService.getVisualIndicator();
    }
}
