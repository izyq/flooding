package club.cupk.waterflood.service.impl;

import club.cupk.waterflood.common.vo.AjaxResult;
import club.cupk.waterflood.domain.Indicator;
import club.cupk.waterflood.domain.WaterFloodingRecord;
import club.cupk.waterflood.mapper.IndicatorMapper;
import club.cupk.waterflood.mapper.WaterFloodingRecordMapper;
import club.cupk.waterflood.service.IIndicatorService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@DubboService
@Component
public class IndicatorServiceImpl extends ServiceImpl<IndicatorMapper,Indicator> implements IIndicatorService{
    @Autowired
    private WaterFloodingRecordMapper waterFloodingRecordMapper;
    @Override
    public Page getPage(Page page, Indicator indicator) {
        return page(page,Wrappers.lambdaQuery(indicator));

    }

    @Override
    public List<Indicator> getList(Indicator indicator) {
        return list(Wrappers.lambdaQuery(indicator));
    }

    @Override
    public AjaxResult getIndicatorByName(Page page, Indicator indicator) {
        if (indicator.getIndicatorName() == null){
            return AjaxResult.success(page(page));
        }
        try{
            return AjaxResult.success(
                    page(page,Wrappers.lambdaQuery(Indicator.class).like(Indicator::getIndicatorName,indicator.getIndicatorName()))
            );

        }catch (Exception e){
            return AjaxResult.error(e.getMessage());
        }
    }

    @Override
    @Transactional
    public AjaxResult removeCascade(Long[] indicatorIds) {
        try{
            Arrays.asList(indicatorIds).forEach((e)->{
                waterFloodingRecordMapper.delete(Wrappers.lambdaQuery(WaterFloodingRecord.class).eq(WaterFloodingRecord::getIndicatorId,e));
            });
            removeByIds(Arrays.asList(indicatorIds));
            return AjaxResult.success();
        }catch (Exception e){
            return AjaxResult.error(e.getMessage());
        }

    }

    @Override
    public AjaxResult getDetailById(Long indicatorId) {
        try{
            return AjaxResult.success(
                    getOne(Wrappers.lambdaQuery(Indicator.class)
                                .isNotNull(Indicator::getFloodingPlan)
                                .isNotNull(Indicator::getIndicatorType))
            );
        }catch (Exception e){
            return AjaxResult.error(e.getMessage());
        }
    }

}
