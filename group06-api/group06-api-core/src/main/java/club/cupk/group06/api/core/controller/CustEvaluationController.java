package club.cupk.group06.api.core.controller;

import club.cupk.group06.api.core.service.CustEvaluationService;
import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.core.domain.CustEvaluation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.PageEntity;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/evaluation/scheme")
@AllArgsConstructor
public class CustEvaluationController {

    private CustEvaluationService custEvaluationService;

    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity, CustEvaluation custEvaluation) {
        return AjaxResult.success(custEvaluationService.getPage(pageEntity.toPage(), custEvaluation));
    }

    @GetMapping("/list")
    public AjaxResult list(CustEvaluation custEvaluation) {
        return AjaxResult.success(custEvaluationService.getList(custEvaluation));
    }

    @PostMapping("/add")
    public AjaxResult add(@RequestBody List<CustEvaluation> custEvaluationList) {
        return custEvaluationService.addCustEvaluationList(custEvaluationList);
    }

    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody CustEvaluation custEvaluation) {
        return AjaxResult.success(custEvaluationService.updateById(custEvaluation));
    }

    @DeleteMapping("/delete/{evalIds}")
    public AjaxResult delete(@PathVariable Long[] evalIds) {
        return AjaxResult.success(custEvaluationService.removeByIds(Arrays.asList(evalIds)));
    }

    @GetMapping(value = "/detail/{evalId}")
    public AjaxResult detail(@PathVariable("evalId") Long evalId) {
        return AjaxResult.success(custEvaluationService.getById(evalId));
    }

    /**
     * valuation和indicator连表
     *
     * @param pageEntity
     * @param custEvaluation
     * @return club.cupk.group06.common.web.vo.AjaxResult
     * @author izyq
     **/
    @GetMapping("/vo/page")
    public AjaxResult pageVo(PageEntity pageEntity, CustEvaluation custEvaluation) {
        return AjaxResult.success(custEvaluationService.pageVo(pageEntity.toPage(), custEvaluation));
    }

    /**
     * 获取一个评价方案的具体信息
     *
     * @param custEvaluation
     * @return club.cupk.group06.common.web.vo.AjaxResult
     * @author izyq
     **/
    @GetMapping("/get")
    public AjaxResult getDetailScheme(CustEvaluation custEvaluation) {
        return AjaxResult.success(custEvaluationService.listVo(custEvaluation));
    }

    @GetMapping(value = "/vo/detail/{evalId}")
    public AjaxResult detailVo(@PathVariable("evalId") Long evalId) {
        return AjaxResult.success(custEvaluationService.getOneVo(evalId));
    }
}
