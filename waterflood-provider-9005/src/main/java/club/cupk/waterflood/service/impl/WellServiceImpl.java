package club.cupk.waterflood.service.impl;
import club.cupk.waterflood.domain.Well;
import club.cupk.waterflood.mapper.WellMapper;
import club.cupk.waterflood.service.IWellService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@DubboService
@Component
public class WellServiceImpl extends ServiceImpl<WellMapper,Well> implements IWellService{

    @Override
    public Page<Well> getPage(Page page, Well well) {
        return page(page,Wrappers.lambdaQuery(well));
    }

    @Override
    public List<Well> getList(Well well) {
        return list(Wrappers.lambdaQuery(well));
    }
    @Autowired
    WellMapper wellMapper;
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Object deleteWell(Long[] wellIds){
        wellMapper.deleteRecordByWellIds(wellIds);
        wellMapper.deletePlanByWellIds(wellIds);
        wellMapper.deleteWellByWellIds(wellIds);
        return null;
    }
}
