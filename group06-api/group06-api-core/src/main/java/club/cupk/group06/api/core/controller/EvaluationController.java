package club.cupk.group06.api.core.controller;

import club.cupk.group06.api.core.service.EvaluationService;
import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.core.domain.Evaluation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.PageEntity;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/evaluation/scheme")
@AllArgsConstructor
public class EvaluationController {

    @Autowired
    private EvaluationService evaluationService;

    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity, Evaluation evaluation) {
        return AjaxResult.success(evaluationService.getPage(pageEntity.toPage(), evaluation));
    }

    @GetMapping("/list")
    public AjaxResult list(Evaluation evaluation) {
        return AjaxResult.success(evaluationService.getList(evaluation));
    }

    @PostMapping("/add")
    public AjaxResult add(@RequestBody List<Evaluation> evaluationList) {
        return evaluationService.addEvaluationList(evaluationList);
    }

    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody Evaluation evaluation) {
        return AjaxResult.success(evaluationService.updateById(evaluation));
    }

    @DeleteMapping("/delete/{evalIds}")
    public AjaxResult delete(@PathVariable Long[] evalIds) {
        return AjaxResult.success(evaluationService.removeByIds(Arrays.asList(evalIds)));
    }

    @GetMapping(value = "/detail/{evalId}")
    public AjaxResult detail(@PathVariable("evalId") Long evalId) {
        return AjaxResult.success(evaluationService.getById(evalId));
    }

    /**
     * valuation和indicator连表
     *
     * @param pageEntity
     * @param evaluation
     * @return club.cupk.group06.common.web.vo.AjaxResult
     * @author izyq
     **/
    @GetMapping("/vo/page")
    public AjaxResult pageVo(PageEntity pageEntity, Evaluation evaluation) {
        return AjaxResult.success(evaluationService.pageVo(pageEntity.toPage(), evaluation));
    }

    /**
     * 获取一个评价方案的具体信息
     *
     * @param evaluation
     * @return club.cupk.group06.common.web.vo.AjaxResult
     * @author izyq
     **/
    @GetMapping("/get")
    public AjaxResult getDetailScheme(Evaluation evaluation) {
        return AjaxResult.success(evaluationService.listVo(evaluation));
    }

    @GetMapping(value = "/vo/detail/{evalId}")
    public AjaxResult detailVo(@PathVariable("evalId") Long evalId) {
        return AjaxResult.success(evaluationService.getOneVo(evalId));
    }
}
