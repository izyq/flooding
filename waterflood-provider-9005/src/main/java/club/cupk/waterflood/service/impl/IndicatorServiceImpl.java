package club.cupk.waterflood.service.impl;
import club.cupk.waterflood.domain.CustEvaluation;
import club.cupk.waterflood.domain.Indicator;
import club.cupk.waterflood.entity.vo.IndicatorVo;
import club.cupk.waterflood.mapper.IndicatorMapper;
import club.cupk.waterflood.service.ICustEvaluationService;
import club.cupk.waterflood.service.IIndicatorService;
import club.cupk.waterflood.util.DubboBean;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xin.altitude.cms.common.util.EntityUtils;
import xin.altitude.cms.common.util.SpringUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@DubboService
@Component
public class IndicatorServiceImpl extends ServiceImpl<IndicatorMapper,Indicator> implements IIndicatorService{
    /** 通过方法调用来解决循环依赖问题 */
    @Override
    public ICustEvaluationService getCustEvaluationService() {
        return SpringUtils.getBean(ICustEvaluationService.class);
    }

    /**查询用户实体类Vo*/
    @Override
    public IndicatorVo getOneVo(Long indicatorId) {
        IndicatorVo indicatorVo = EntityUtils.toObj(getById(indicatorId), IndicatorVo::new);
        List<CustEvaluation> custEvaluationList = getCustEvaluationService().list(Wrappers.lambdaQuery(CustEvaluation.class).eq(CustEvaluation::getIndicatorId, indicatorVo.getIndicatorId()));
        indicatorVo.setCustEvaluationList(custEvaluationList);
        return indicatorVo;
    }
    /**查询实体类Vo列表*/
    @Override
    public List<IndicatorVo> listVo(Indicator indicator) {
        List<IndicatorVo> indicatorVoList = EntityUtils.toList(list(Wrappers.lambdaQuery(indicator)), IndicatorVo::new);
        Set<Long> indicatorIds = EntityUtils.toSet(indicatorVoList, IndicatorVo::getIndicatorId);
        List<CustEvaluation> custEvaluationList = getCustEvaluationService().list(Wrappers.lambdaQuery(CustEvaluation.class).in(CustEvaluation::getIndicatorId, indicatorIds));
        Map<Long, List<CustEvaluation>> map = custEvaluationList.stream().collect(Collectors.groupingBy(CustEvaluation::getIndicatorId));
        indicatorVoList.forEach(e -> e.setCustEvaluationList(map.get(e.getIndicatorId())));
        return indicatorVoList;
    }
    /**分页查询实体类Vo*/
    @Override
    public IPage<IndicatorVo> pageVo(IPage<Indicator> page, Indicator indicator) {
        IPage<IndicatorVo> indicatorVoPage = EntityUtils.toPage(page(page, Wrappers.lambdaQuery(indicator)), IndicatorVo::new);
        Set<Long> indicatorIds = EntityUtils.toSet(indicatorVoPage.getRecords(), IndicatorVo::getIndicatorId);
        List<CustEvaluation> custEvaluationList = getCustEvaluationService().list(Wrappers.lambdaQuery(CustEvaluation.class).in(CustEvaluation::getIndicatorId, indicatorIds));
        Map<Long, List<CustEvaluation>> map = custEvaluationList.stream().collect(Collectors.groupingBy(CustEvaluation::getIndicatorId));
        indicatorVoPage.getRecords().forEach(e -> e.setCustEvaluationList(map.get(e.getIndicatorId())));
        return indicatorVoPage;
    }

    @Override
    public Page getPage(Page page, Indicator indicator) {
        return page(page,Wrappers.lambdaQuery(indicator));
    }

    @Override
    public List<Indicator> getList(Indicator indicator) {
        return list(Wrappers.lambdaQuery(indicator));
    }
}
