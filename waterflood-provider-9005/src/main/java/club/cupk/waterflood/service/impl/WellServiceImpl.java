package club.cupk.waterflood.service.impl;
import club.cupk.waterflood.domain.Well;
import club.cupk.waterflood.mapper.WellMapper;
import club.cupk.waterflood.service.IWellService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

@DubboService
@Component
public class WellServiceImpl extends ServiceImpl<WellMapper,Well> implements IWellService{
}
