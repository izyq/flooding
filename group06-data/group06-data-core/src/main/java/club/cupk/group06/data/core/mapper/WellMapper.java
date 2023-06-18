package club.cupk.group06.data.core.mapper;

import club.cupk.group06.data.core.domain.Well;
import club.cupk.group06.data.core.dto.well.WellDTO;
import club.cupk.group06.data.core.entity.vo.WellVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
@Transactional(rollbackFor = Exception.class)
public interface WellMapper extends BaseMapper<Well> {
    void deletePlanByWellIds(@Param("wellIds") Long[] wellIds);

    void deleteRecordByWellIds(@Param("wellIds") Long[] wellIds);

    void deleteWellByWellIds(@Param("wellIds") Long[] wellIds);

    List<WellVo> getWellByName(WellDTO wellDTO);

    Long getWellCountByName(WellDTO wellDTO);
}
