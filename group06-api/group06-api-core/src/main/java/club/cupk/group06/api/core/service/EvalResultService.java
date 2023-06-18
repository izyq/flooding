package club.cupk.group06.api.core.service;

import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.core.dto.indicator.EvalResDTO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author wangdaff
 * @date 2023-06-18 10:11
 * @description
 */
public interface EvalResultService {
    AjaxResult getEvaluationResult(Page page, EvalResDTO evalResDTO);
}
