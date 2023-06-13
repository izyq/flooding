package club.cupk.waterflood.controller;

import club.cupk.waterflood.domain.CustEvaluation;
import club.cupk.waterflood.service.ICustEvaluationService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.AjaxResult;
import xin.altitude.cms.common.entity.PageEntity;

import java.util.Arrays;
@RestController
@RequestMapping("/waterflood/cust/evaluation")
public class CustEvaluationController{
    @DubboReference
    private ICustEvaluationService custEvaluationService;
    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity,CustEvaluation custEvaluation){
        return AjaxResult.success(custEvaluationService.page(pageEntity.toPage(), Wrappers.lambdaQuery(custEvaluation)));
    }
    @GetMapping("/list")
    public AjaxResult list(CustEvaluation custEvaluation){
        return AjaxResult.success(custEvaluationService.list(Wrappers.lambdaQuery(custEvaluation)));
    }
    @PostMapping("/push")
    public AjaxResult add(@RequestBody CustEvaluation custEvaluation) {
        return AjaxResult.success(custEvaluationService.save(custEvaluation));
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
    @GetMapping("/vo/page")
    public AjaxResult pageVo(PageEntity pageEntity,CustEvaluation custEvaluation){
        return AjaxResult.success(custEvaluationService.pageVo(pageEntity.toPage(), custEvaluation));
    }
    @GetMapping("/vo/list")
    public AjaxResult listVo(CustEvaluation custEvaluation){
        return AjaxResult.success(custEvaluationService.listVo(custEvaluation));
    }
    @GetMapping(value = "/vo/detail/{evalId}")
    public AjaxResult detailVo(@PathVariable("evalId") Long evalId) {
        return AjaxResult.success(custEvaluationService.getOneVo(evalId));
    }
}
