package club.cupk.waterflood.service;

import club.cupk.waterflood.common.vo.AjaxResult;
import club.cupk.waterflood.domain.CustEvaluation;
import club.cupk.waterflood.entity.vo.CustEvaluationVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface ICustEvaluationService extends IService<CustEvaluation>{

    CustEvaluationVo getOneVo(Long evalId);

    List<CustEvaluationVo> listVo(CustEvaluation custEvaluation);

    IPage<CustEvaluationVo> pageVo(IPage<CustEvaluation> page, CustEvaluation custEvaluation);

    AjaxResult addCustEvaluationList(List<CustEvaluation> custEvaluationList);

    Page getPage(Page page, CustEvaluation custEvaluation);
    List<CustEvaluation> getList(CustEvaluation custEvaluation);


}
