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

    private GraphService graphService;

    @PostMapping("/indicator/add")
    public AjaxResult addVisualIndicator(@RequestParam Integer indicatorId) {
        return graphService.addVisualIndicator(indicatorId);
    }

    @GetMapping("/get-indicator")
    public AjaxResult getVisualIndicator() {
        return graphService.getVisualIndicator();
    }

    @GetMapping("/get")
    public AjaxResult getGraph(PageEntity pageEntity,Long indicatorId, Long year, String factory) {
        return graphService.getGraph(pageEntity.toPage(),indicatorId, year, factory);
    }
}
