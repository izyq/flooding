package club.cupk.group06.api.core.controller;

import club.cupk.group06.api.core.service.EvaluationService;
import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.core.domain.Evaluation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.PageEntity;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/evaluation/scheme")
@AllArgsConstructor
@Slf4j
public class EvaluationController {

    /**

     EvaluationService 的自动装配字段。
     */
    @Autowired
    private EvaluationService evaluationService;
    /**

     分页查询评价列表。
     @param pageEntity 分页参数实体。
     @param evaluation 查询条件评价实体。
     @return 包含评价分页结果的 AjaxResult 对象。
     */
    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity, Evaluation evaluation) {
        return AjaxResult.success(evaluationService.getPage(pageEntity.toPage(), evaluation));
    }
    /**

     查询评价列表。
     @param evaluation 查询条件评价实体。
     @return 包含评价列表的 AjaxResult 对象。
     */
    @GetMapping("/list")
    public AjaxResult list(Evaluation evaluation) {
        return AjaxResult.success(evaluationService.getList(evaluation));
    }
    /**

     添加评价。
     @param evaluationList 评价列表。
     @return AjaxResult 对象，表示添加评价的结果。
     */
    @PostMapping("/add")
    public AjaxResult add(@RequestBody List<Evaluation> evaluationList) {
        log.info("添加客制化指标-----------------------");
        return evaluationService.addEvaluationList(evaluationList);
    }
    /**

     编辑评价。
     @param evaluation 编辑的评价实体。
     @return 包含编辑后的评价对象的 AjaxResult 对象。
     */
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody Evaluation evaluation) {
        log.info("修改客制化指标---------------------------");
        return AjaxResult.success(evaluationService.updateById(evaluation));
    }
    /**
     @param evalIds 要删除的评价ID数组。
     @return 表示删除评价操作结果的 AjaxResult 对象。
     */
    @DeleteMapping("/delete/{evalIds}")
    public AjaxResult delete(@PathVariable Long[] evalIds) {
        log.info("删除了客制化指标--------------------------");
        return AjaxResult.success(evaluationService.removeByIds(Arrays.asList(evalIds)));
    }
    /**

     获取评价详情。
     @param evalId 评价ID。
     @return 包含评价详情的 AjaxResult 对象。
     */
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
