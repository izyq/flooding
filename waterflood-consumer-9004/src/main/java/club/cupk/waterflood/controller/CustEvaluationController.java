package club.cupk.waterflood.controller;

import club.cupk.waterflood.common.vo.AjaxResult;
import club.cupk.waterflood.domain.CustEvaluation;
import club.cupk.waterflood.service.ICustEvaluationService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.PageEntity;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/evaluation/scheme")
public class CustEvaluationController{
    @DubboReference(check = false)
    private ICustEvaluationService custEvaluationService;
    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity,CustEvaluation custEvaluation){
        return AjaxResult.success(custEvaluationService.getPage(pageEntity.toPage(), custEvaluation));
    }
    @GetMapping("/list")
    public AjaxResult list(CustEvaluation custEvaluation){
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
     * @author izyq
     * @param pageEntity
     * @param custEvaluation
     * @return club.cupk.waterflood.common.vo.AjaxResult
     **/
    @GetMapping("/vo/page")
    public AjaxResult pageVo(PageEntity pageEntity,CustEvaluation custEvaluation){
        return AjaxResult.success(custEvaluationService.pageVo(pageEntity.toPage(), custEvaluation));
    }
    /**
     * 获取一个评价方案的具体信息
     * @author izyq
     * @param custEvaluation
     * @return club.cupk.waterflood.common.vo.AjaxResult
     **/
    @GetMapping("/get")
    public AjaxResult getDetailScheme(CustEvaluation custEvaluation){
        return AjaxResult.success(custEvaluationService.listVo(custEvaluation));
    }
    @GetMapping(value = "/vo/detail/{evalId}")
    public AjaxResult detailVo(@PathVariable("evalId") Long evalId) {
        return AjaxResult.success(custEvaluationService.getOneVo(evalId));
    }
}
