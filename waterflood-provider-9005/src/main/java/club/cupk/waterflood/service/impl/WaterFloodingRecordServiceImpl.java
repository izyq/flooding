package club.cupk.waterflood.service.impl;
import club.cupk.waterflood.domain.WaterFloodingRecord;
import club.cupk.waterflood.mapper.WaterFloodingRecordMapper;
import club.cupk.waterflood.service.IWaterFloodingRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
@DubboService
public class WaterFloodingRecordServiceImpl extends ServiceImpl<WaterFloodingRecordMapper,WaterFloodingRecord> implements IWaterFloodingRecordService{
}
