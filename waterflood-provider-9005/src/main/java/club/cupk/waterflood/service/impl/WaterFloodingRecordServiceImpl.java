package club.cupk.waterflood.service.impl;
import club.cupk.waterflood.domain.WaterFloodingRecord;
import club.cupk.waterflood.mapper.WaterFloodingRecordMapper;
import club.cupk.waterflood.service.IWaterFloodingRecordService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

import java.util.List;

@DubboService
@Component
public class WaterFloodingRecordServiceImpl extends ServiceImpl<WaterFloodingRecordMapper,WaterFloodingRecord> implements IWaterFloodingRecordService{
    @Override
    public Page getPage(Page page, WaterFloodingRecord waterFloodingRecord) {
        return page(page, Wrappers.lambdaQuery(waterFloodingRecord));
    }

    @Override
    public List<WaterFloodingRecord> getList(WaterFloodingRecord waterFloodingRecord) {
        return list(Wrappers.lambdaQuery(waterFloodingRecord));
    }
}
