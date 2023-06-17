package club.cupk.group06.data.core.mapper;

import club.cupk.group06.data.core.domain.WaterFloodingPlan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

@Mapper
@Transactional(rollbackFor = Exception.class)
public interface WaterFloodingPlanMapper extends BaseMapper<WaterFloodingPlan> {
}
