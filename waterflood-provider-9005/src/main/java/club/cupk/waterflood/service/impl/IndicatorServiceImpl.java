package club.cupk.waterflood.service.impl;

import club.cupk.waterflood.domain.Indicator;
import club.cupk.waterflood.mapper.IndicatorMapper;
import club.cupk.waterflood.service.IIndicatorService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

import java.util.List;

@DubboService
@Component
public class IndicatorServiceImpl extends ServiceImpl<IndicatorMapper,Indicator> implements IIndicatorService{
    @Override
    public Page getPage(Page page, Indicator indicator) {
        return page(page,Wrappers.lambdaQuery(indicator));
    }

    @Override
    public List<Indicator> getList(Indicator indicator) {
        return list(Wrappers.lambdaQuery(indicator));
    }
}
