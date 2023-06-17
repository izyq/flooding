package club.cupk.group06.api.core.service.impl;

import club.cupk.group06.api.core.service.CustEvaluationService;
import club.cupk.group06.api.core.service.IndicatorService;
import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.core.domain.CustEvaluation;
import club.cupk.group06.data.core.domain.Indicator;
import club.cupk.group06.data.core.entity.vo.CustEvaluationVo;
import club.cupk.group06.data.core.mapper.CustEvaluationMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import xin.altitude.cms.common.util.BeanCopyUtils;
import xin.altitude.cms.common.util.EntityUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;


@Service
@AllArgsConstructor
public class CustEvaluationServiceImpl extends ServiceImpl<CustEvaluationMapper, CustEvaluation> implements CustEvaluationService {

    private IndicatorService indicatorService;

    private CustEvaluationMapper custEvaluationMapper;

    /**
     * 查询用户实体类Vo
     */
    @Override
    public CustEvaluationVo getOneVo(Long evalId) {
        CustEvaluationVo custEvaluationVo = EntityUtils.toObj(getById(evalId), CustEvaluationVo::new);
        Indicator indicator = indicatorService.getById(custEvaluationVo.getIndicatorId());
        BeanCopyUtils.copyProperties(indicator, custEvaluationVo);
        return custEvaluationVo;
    }

    /**
     * 查询实体类Vo列表
     */
    @Override
    public List<CustEvaluationVo> listVo(CustEvaluation custEvaluation) {
        List<CustEvaluationVo> custEvaluationVoList = EntityUtils.toList(list(Wrappers.lambdaQuery(custEvaluation)), CustEvaluationVo::new);
        Set<Long> indicatorIds = EntityUtils.toSet(custEvaluationVoList, CustEvaluationVo::getIndicatorId);
        Map<Long, Indicator> map = EntityUtils.toMap(indicatorService.listByIds(indicatorIds), Indicator::getIndicatorId, e -> e);
//        custEvaluationVoList.forEach(e -> BeanCopyUtils.copyProperties(map.get(e.getIndicatorId()), e));
        custEvaluationVoList.forEach(e -> e.setIndicator(map.get(e.getIndicatorId())));
        return custEvaluationVoList;
    }

    /**
     * 分页查询实体类Vo
     */
    @Override
    public IPage<CustEvaluationVo> pageVo(IPage<CustEvaluation> page, CustEvaluation custEvaluation) {
        IPage<CustEvaluationVo> custEvaluationVoPage = EntityUtils.toPage(page(page, Wrappers.lambdaQuery(custEvaluation)), CustEvaluationVo::new);
        Set<Long> indicatorIds = EntityUtils.toSet(custEvaluationVoPage.getRecords(), CustEvaluationVo::getIndicatorId);
        Map<Long, Indicator> map = EntityUtils.toMap(indicatorService.listByIds(indicatorIds), Indicator::getIndicatorId, e -> e);
        custEvaluationVoPage.getRecords().forEach(e -> BeanCopyUtils.copyProperties(map.get(e.getIndicatorId()), e));
        return custEvaluationVoPage;
    }

    @Override
    public Page getPage(Page page, CustEvaluation custEvaluation) {
        return page(page, Wrappers.lambdaQuery(custEvaluation));
    }

    @Override
    public List<CustEvaluation> getList(CustEvaluation custEvaluation) {
        return list(Wrappers.lambdaQuery(custEvaluation));
    }

    @Override
    public AjaxResult addCustEvaluationList(List<CustEvaluation> custEvaluationList) {
        //如果前端传的scheme_id已经有了,return
        QueryWrapper<CustEvaluation> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("scheme_id").eq("scheme_id", custEvaluationList.get(0).getSchemeId());
        if (!Objects.isNull(custEvaluationMapper.selectList(queryWrapper))) {
            return new AjaxResult(HttpStatus.NOT_MODIFIED.value(), "该schemeId已存在");
        }
        try {
            custEvaluationList.forEach(this::save);
            return AjaxResult.success();
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

}
