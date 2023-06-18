package club.cupk.group06.api.core.controller;

import club.cupk.group06.api.core.service.EvalResultService;
import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.core.dto.indicator.EvalResDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.cms.common.entity.PageEntity;

/**
 * @author wangdaff
 * @date 2023-06-18 10:21
 * @description
 */
@RestController
@RequestMapping("/evaluation/result")
@AllArgsConstructor
public class EvalController {
    @Autowired
    private EvalResultService evalResultService;
    @GetMapping("/get")
    public AjaxResult getResult(PageEntity pageEntity, EvalResDTO evalResDTO){
        return evalResultService.getEvaluationResult(pageEntity.toPage(),evalResDTO);
    }
}
