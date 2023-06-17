package club.cupk.group06.api.core.service;

import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.core.domain.Indicator;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IndicatorService extends IService<Indicator> {

    Page getPage(Page page, Indicator indicator);

    List<Indicator> getList(Indicator indicator);

    AjaxResult getIndicatorByName(Page page, Indicator indicator);

    AjaxResult removeCascade(Long[] indicatorIds);

    AjaxResult getDetailById(Long indicatorId);
}
