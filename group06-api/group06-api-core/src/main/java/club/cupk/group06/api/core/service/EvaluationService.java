package club.cupk.group06.api.core.service;

import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.core.domain.Evaluation;
import club.cupk.group06.data.core.vo.EvaluationVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface EvaluationService extends IService<Evaluation>{

    EvaluationVo getOneVo(Long evalId);

    List<EvaluationVo> listVo(Evaluation evaluation);

    IPage<EvaluationVo> pageVo(IPage<Evaluation> page, Evaluation evaluation);

    AjaxResult addEvaluationList(List<Evaluation> evaluationList);

    Page getPage(Page page, Evaluation evaluation);
    List<Evaluation> getList(Evaluation evaluation);


}
