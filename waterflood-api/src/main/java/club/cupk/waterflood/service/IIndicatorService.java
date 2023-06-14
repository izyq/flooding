package club.cupk.waterflood.service;
import club.cupk.waterflood.domain.CustEvaluation;
import club.cupk.waterflood.domain.Indicator;
import club.cupk.waterflood.entity.vo.IndicatorVo;
import club.cupk.waterflood.util.DubboBean;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import xin.altitude.cms.common.util.EntityUtils;
import xin.altitude.cms.common.util.SpringUtils;

public interface IIndicatorService extends IService<Indicator>{
    /** 通过方法调用来解决循环依赖问题 */
    default ICustEvaluationService getCustEvaluationService() {
        return DubboBean.getDubboBean(ICustEvaluationService.class);
    }
    /**查询用户实体类Vo*/
    default IndicatorVo getOneVo(Long indicatorId) {
        IndicatorVo indicatorVo = EntityUtils.toObj(getById(indicatorId), IndicatorVo::new);
        List<CustEvaluation> custEvaluationList = getCustEvaluationService().list(Wrappers.lambdaQuery(CustEvaluation.class).eq(CustEvaluation::getIndicatorId, indicatorVo.getIndicatorId()));
        indicatorVo.setCustEvaluationList(custEvaluationList);
        return indicatorVo;
    }
    /**查询实体类Vo列表*/
    default List<IndicatorVo> listVo(Indicator indicator) {
        List<IndicatorVo> indicatorVoList = EntityUtils.toList(list(Wrappers.lambdaQuery(indicator)), IndicatorVo::new);
        Set<Long> indicatorIds = EntityUtils.toSet(indicatorVoList, IndicatorVo::getIndicatorId);
        List<CustEvaluation> custEvaluationList = getCustEvaluationService().list(Wrappers.lambdaQuery(CustEvaluation.class).in(CustEvaluation::getIndicatorId, indicatorIds));
        Map<Long, List<CustEvaluation>> map = custEvaluationList.stream().collect(Collectors.groupingBy(CustEvaluation::getIndicatorId));
        indicatorVoList.forEach(e -> e.setCustEvaluationList(map.get(e.getIndicatorId())));
        return indicatorVoList;
    }
    /**分页查询实体类Vo*/
    default IPage<IndicatorVo> pageVo(IPage<Indicator> page, Indicator indicator) {
        IPage<IndicatorVo> indicatorVoPage = EntityUtils.toPage(page(page, Wrappers.lambdaQuery(indicator)), IndicatorVo::new);
        Set<Long> indicatorIds = EntityUtils.toSet(indicatorVoPage.getRecords(), IndicatorVo::getIndicatorId);
        List<CustEvaluation> custEvaluationList = getCustEvaluationService().list(Wrappers.lambdaQuery(CustEvaluation.class).in(CustEvaluation::getIndicatorId, indicatorIds));
        Map<Long, List<CustEvaluation>> map = custEvaluationList.stream().collect(Collectors.groupingBy(CustEvaluation::getIndicatorId));
        indicatorVoPage.getRecords().forEach(e -> e.setCustEvaluationList(map.get(e.getIndicatorId())));
        return indicatorVoPage;
    }
}
