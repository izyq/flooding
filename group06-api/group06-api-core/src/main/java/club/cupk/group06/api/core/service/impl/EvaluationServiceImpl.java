package club.cupk.group06.api.core.service.impl;

import club.cupk.group06.api.core.service.EvaluationService;
import club.cupk.group06.api.core.service.IndicatorService;
import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.core.domain.Evaluation;
import club.cupk.group06.data.core.domain.Indicator;
import club.cupk.group06.data.core.vo.EvaluationVo;
import club.cupk.group06.data.core.mapper.EvaluationMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import xin.altitude.cms.common.util.BeanCopyUtils;
import xin.altitude.cms.common.util.EntityUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;


@Service
@AllArgsConstructor
public class EvaluationServiceImpl extends ServiceImpl<EvaluationMapper, Evaluation> implements EvaluationService {

    @Autowired
    private IndicatorService indicatorService;

    @Resource
    private EvaluationMapper evaluationMapper;

    /**
     * 查询用户实体类Vo
     */
    @Override
    public EvaluationVo getOneVo(Long evalId) {
        EvaluationVo EvaluationVo = EntityUtils.toObj(getById(evalId), EvaluationVo::new);
        Indicator indicator = indicatorService.getById(EvaluationVo.getIndicatorId());
        BeanCopyUtils.copyProperties(indicator, EvaluationVo);
        return EvaluationVo;
    }

    /**
     * 查询实体类Vo列表
     */
    @Override
    public List<EvaluationVo> listVo(Evaluation evaluation) {
        List<EvaluationVo> EvaluationVoList = EntityUtils.toList(list(Wrappers.lambdaQuery(evaluation)), EvaluationVo::new);
        Set<Long> indicatorIds = EntityUtils.toSet(EvaluationVoList, EvaluationVo::getIndicatorId);
        Map<Long, Indicator> map = EntityUtils.toMap(indicatorService.listByIds(indicatorIds), Indicator::getIndicatorId, e -> e);
//        EvaluationVoList.forEach(e -> BeanCopyUtils.copyProperties(map.get(e.getIndicatorId()), e));
        EvaluationVoList.forEach(e -> e.setIndicator(map.get(e.getIndicatorId())));
        return EvaluationVoList;
    }

    /**
     * 分页查询实体类Vo
     */
    @Override
    public IPage<EvaluationVo> pageVo(IPage<Evaluation> page, Evaluation evaluation) {
        IPage<EvaluationVo> EvaluationVoPage = EntityUtils.toPage(page(page, Wrappers.lambdaQuery(evaluation)), EvaluationVo::new);
        Set<Long> indicatorIds = EntityUtils.toSet(EvaluationVoPage.getRecords(), EvaluationVo::getIndicatorId);
        Map<Long, Indicator> map = EntityUtils.toMap(indicatorService.listByIds(indicatorIds), Indicator::getIndicatorId, e -> e);
        EvaluationVoPage.getRecords().forEach(e -> BeanCopyUtils.copyProperties(map.get(e.getIndicatorId()), e));
        return EvaluationVoPage;
    }

    @Override
    public Page getPage(Page page, Evaluation evaluation) {
        return page(page, Wrappers.lambdaQuery(evaluation));
    }

    @Override
    public List<Evaluation> getList(Evaluation evaluation) {
        return list(Wrappers.lambdaQuery(evaluation));
    }

    @Override
    public AjaxResult addEvaluationList(List<Evaluation> evaluationList) {
        //如果前端传的scheme_id已经有了,return
        QueryWrapper<Evaluation> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("scheme_id").eq("scheme_id", evaluationList.get(0).getSchemeId());
        if (!Objects.isNull(evaluationMapper.selectList(queryWrapper))) {
            return new AjaxResult(HttpStatus.NOT_MODIFIED.value(), "该schemeId已存在");
        }
        try {
            evaluationList.forEach(this::save);
            return AjaxResult.success();
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

}
