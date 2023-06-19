package club.cupk.group06.api.core.service.impl;

import club.cupk.group06.api.core.service.EvalResultService;
import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.core.dto.indicator.EvalResDTO;
import club.cupk.group06.data.core.vo.well.EvalResultPageVo;
import club.cupk.group06.data.core.mapper.IndicatorMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wangdaff
 * @date 2023-06-18 10:13
 * @description
 */
@Service
public class EvalResultServiceImpl implements EvalResultService {
    @Resource
    private IndicatorMapper indicatorMapper;

    @Override
    public AjaxResult getEvaluationResult(Page page, EvalResDTO evalResDTO) {
        EvalResultPageVo evalResultPageVo = new EvalResultPageVo();
        try{
            evalResultPageVo.setEvalResultVoList(indicatorMapper.getEvaluationResult(EvalResDTO.builder()
                    .current(page.getCurrent())
                    .size(page.getSize())
                    .schemeId(evalResDTO.getSchemeId())
                    .wellName(evalResDTO.getWellName())
                    .year(evalResDTO.getYear()).build()));
            evalResultPageVo.setSize(page.getSize());
            evalResultPageVo.setTotal(indicatorMapper.getEvalResCount(evalResDTO));
            return AjaxResult.success(evalResultPageVo);
        }catch (Exception e){
            return AjaxResult.error(e.getMessage());
        }

    }
}
