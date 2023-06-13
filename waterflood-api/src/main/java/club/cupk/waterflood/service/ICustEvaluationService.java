package club.cupk.waterflood.service;
import club.cupk.waterflood.domain.CustEvaluation;
import club.cupk.waterflood.domain.Indicator;
import club.cupk.waterflood.entity.vo.CustEvaluationVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import java.util.Map;
import java.util.Set;
import xin.altitude.cms.common.util.BeanCopyUtils;
import xin.altitude.cms.common.util.EntityUtils;
import xin.altitude.cms.common.util.SpringUtils;

public interface ICustEvaluationService extends IService<CustEvaluation>{
    IIndicatorService indicatorService = SpringUtils.getBean(IIndicatorService.class);
    /**查询用户实体类Vo*/    default CustEvaluationVo getOneVo(Long evalId) {
        CustEvaluationVo custEvaluationVo = EntityUtils.toObj(getById(evalId), CustEvaluationVo::new);
        Indicator indicator = indicatorService.getById(custEvaluationVo.getIndicatorId());
        BeanCopyUtils.copyProperties(indicator, custEvaluationVo);
        return custEvaluationVo;
    }
    /**查询实体类Vo列表*/    default List<CustEvaluationVo> listVo(CustEvaluation custEvaluation) {
        List<CustEvaluationVo> custEvaluationVoList = EntityUtils.toList(list(Wrappers.lambdaQuery(custEvaluation)), CustEvaluationVo::new);
        Set<Long> indicatorIds = EntityUtils.toSet(custEvaluationVoList, CustEvaluationVo::getIndicatorId);
        Map<Long, Indicator> map = EntityUtils.toMap(indicatorService.listByIds(indicatorIds), Indicator::getIndicatorId, e -> e);
        custEvaluationVoList.forEach(e -> BeanCopyUtils.copyProperties(map.get(e.getIndicatorId()), e));
        return custEvaluationVoList;
    }
    /**分页查询实体类Vo*/    default IPage<CustEvaluationVo> pageVo(IPage<CustEvaluation> page, CustEvaluation custEvaluation) {
        IPage<CustEvaluationVo> custEvaluationVoPage = EntityUtils.toPage(page(page, Wrappers.lambdaQuery(custEvaluation)), CustEvaluationVo::new);
        Set<Long> indicatorIds = EntityUtils.toSet(custEvaluationVoPage.getRecords(), CustEvaluationVo::getIndicatorId);
        Map<Long, Indicator> map = EntityUtils.toMap(indicatorService.listByIds(indicatorIds), Indicator::getIndicatorId, e -> e);
        custEvaluationVoPage.getRecords().forEach(e -> BeanCopyUtils.copyProperties(map.get(e.getIndicatorId()), e));
        return custEvaluationVoPage;
    }
}
