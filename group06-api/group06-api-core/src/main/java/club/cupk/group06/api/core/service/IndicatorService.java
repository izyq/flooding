package club.cupk.group06.api.core.service;

import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.core.domain.Indicator;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IndicatorService extends IService<Indicator> {

    IPage<Indicator> pageIndicator(IPage<Indicator> page, String indicatorName, String floodingPlan, String indicatorType);

    List<Indicator> getList(Indicator indicator);

    AjaxResult removeCascade(Long[] indicatorIds);

    AjaxResult getDetailById(Long indicatorId);
}
