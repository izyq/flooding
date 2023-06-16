package club.cupk.waterflood.mapper;
import club.cupk.waterflood.domain.Well;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
@Transactional(rollbackFor = Exception.class)
public interface WellMapper extends BaseMapper<Well>{
    void deletePlanByWellIds(@Param("wellIds") Long[] wellIds);

    void deleteRecordByWellIds(@Param("wellIds") Long[] wellIds);

    void deleteWellByWellIds(@Param("wellIds") Long[] wellIds);
}
