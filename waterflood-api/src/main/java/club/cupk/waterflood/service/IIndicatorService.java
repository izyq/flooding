package club.cupk.waterflood.service;
import club.cupk.waterflood.domain.CustEvaluation;
import club.cupk.waterflood.domain.Indicator;
import club.cupk.waterflood.entity.vo.IndicatorVo;
import club.cupk.waterflood.util.DubboBean;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import xin.altitude.cms.common.util.EntityUtils;
import xin.altitude.cms.common.util.SpringUtils;

public interface IIndicatorService extends IService<Indicator>{
    ICustEvaluationService getCustEvaluationService();

    IndicatorVo getOneVo(Long indicatorId);

    List<IndicatorVo> listVo(Indicator indicator);

    IPage<IndicatorVo> pageVo(IPage<Indicator> page, Indicator indicator);

    Page getPage(Page page,Indicator indicator);

    List<Indicator> getList(Indicator indicator);
}
