package club.cupk.group06.api.core.service;

import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.core.domain.Evaluation;
import club.cupk.group06.data.core.vo.EvaluationVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface EvaluationService extends IService<Evaluation>{
        /**

         根据评估ID获取 EvaluationVo 对象。
         @param evalId 评估ID。
         @return EvaluationVo 对象。
         */
        EvaluationVo getOneVo(Long evalId);
        /**

         根据 Evaluation 对象获取 EvaluationVo 列表。
         @param evaluation Evaluation 对象。
         @return EvaluationVo 列表。
         */
        List<EvaluationVo> listVo(Evaluation evaluation);
        /**

         分页查询 EvaluationVo。
         @param page 分页对象。
         @param evaluation Evaluation 对象。
         @return 分页结果的 EvaluationVo 对象。
         */
        IPage<EvaluationVo> pageVo(IPage<Evaluation> page, Evaluation evaluation);
        /**

         批量添加 Evaluation 对象。
         @param evaluationList Evaluation 对象列表。
         @return 操作结果的 AjaxResult 对象。
         */
        AjaxResult addEvaluationList(List<Evaluation> evaluationList);
        /**

         根据 Evaluation 对象进行分页查询。
         @param page 分页对象。
         @param evaluation Evaluation 对象。
         @return 分页结果的 Page 对象。
         */
        Page getPage(Page page, Evaluation evaluation);
        /**

         根据 Evaluation 对象获取 Evaluation 列表。
         @param evaluation Evaluation 对象。
         @return Evaluation 列表。
         */
        List<Evaluation> getList(Evaluation evaluation);

}
