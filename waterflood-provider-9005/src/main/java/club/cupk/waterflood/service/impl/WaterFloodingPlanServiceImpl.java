package club.cupk.waterflood.service.impl;
import club.cupk.waterflood.domain.WaterFloodingPlan;
import club.cupk.waterflood.mapper.WaterFloodingPlanMapper;
import club.cupk.waterflood.service.IWaterFloodingPlanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

@DubboService
@Component
public class WaterFloodingPlanServiceImpl extends ServiceImpl<WaterFloodingPlanMapper,WaterFloodingPlan> implements IWaterFloodingPlanService{
}
