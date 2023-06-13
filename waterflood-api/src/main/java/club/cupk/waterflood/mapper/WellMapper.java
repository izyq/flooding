package club.cupk.waterflood.mapper;
import club.cupk.waterflood.domain.Well;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;
@Mapper
@Transactional(rollbackFor = Exception.class)
public interface WellMapper extends BaseMapper<Well>{
}
