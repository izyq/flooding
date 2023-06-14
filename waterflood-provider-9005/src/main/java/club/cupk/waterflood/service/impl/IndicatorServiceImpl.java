package club.cupk.waterflood.service.impl;
import club.cupk.waterflood.domain.Indicator;
import club.cupk.waterflood.mapper.IndicatorMapper;
import club.cupk.waterflood.service.IIndicatorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

@DubboService
@Component
public class IndicatorServiceImpl extends ServiceImpl<IndicatorMapper,Indicator> implements IIndicatorService{

}
