package club.cupk.waterflood.service.impl;
import club.cupk.waterflood.domain.Indicator;
import club.cupk.waterflood.mapper.IndicatorMapper;
import club.cupk.waterflood.service.IIndicatorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
@Service
public class IndicatorServiceImpl extends ServiceImpl<IndicatorMapper,Indicator> implements IIndicatorService{
}
