package club.cupk.group06.api.core.service.impl;

import club.cupk.group06.api.core.service.IndicatorService;
import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.core.domain.Indicator;
import club.cupk.group06.data.core.domain.Record;
import club.cupk.group06.data.core.mapper.IndicatorMapper;
import club.cupk.group06.data.core.mapper.RecordMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class IndicatorServiceImpl extends ServiceImpl<IndicatorMapper, Indicator> implements IndicatorService {

    @Resource
    private RecordMapper recordMapper;

    @Resource
    private IndicatorMapper indicatorMapper;

    @Override
    public IPage<Indicator> pageIndicator(IPage<Indicator> page, String indicatorName, String floodingPlan, String indicatorType) {
        return indicatorMapper.pageIndicator(page, indicatorName, floodingPlan, indicatorType);
    }

    @Override
    public List<Indicator> getList(Indicator indicator) {
        return list(Wrappers.lambdaQuery(indicator));
    }

    @Override
    @Transactional
    public AjaxResult removeCascade(Long[] indicatorIds) {
        try {
            Arrays.asList(indicatorIds).forEach((e) -> {
                recordMapper.delete(Wrappers.lambdaQuery(Record.class).eq(Record::getIndicatorId, e));
            });
            removeByIds(Arrays.asList(indicatorIds));
            return AjaxResult.success();
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }

    }

    @Override
    public AjaxResult getDetailById(Long indicatorId) {
        try {
            return AjaxResult.success(
                    getOne(Wrappers.lambdaQuery(Indicator.class)
                            .isNotNull(Indicator::getFloodingPlan)
                            .isNotNull(Indicator::getIndicatorType))
            );
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

}
