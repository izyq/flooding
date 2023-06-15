package club.cupk.waterflood.service.impl;
import club.cupk.waterflood.domain.WaterFloodingPlan;
import club.cupk.waterflood.mapper.WaterFloodingPlanMapper;
import club.cupk.waterflood.service.IWaterFloodingPlanService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

import java.util.List;

@DubboService
@Component
public class WaterFloodingPlanServiceImpl extends ServiceImpl<WaterFloodingPlanMapper,WaterFloodingPlan> implements IWaterFloodingPlanService{
    @Override
    public Page<WaterFloodingPlan> getPage(Page page, WaterFloodingPlan waterFloodingPlan) {
        return page(page, Wrappers.lambdaQuery(waterFloodingPlan));
    }

    @Override
    public List<WaterFloodingPlan> getList(WaterFloodingPlan waterFloodingPlan) {
        return list(Wrappers.lambdaQuery(waterFloodingPlan));
    }
}
