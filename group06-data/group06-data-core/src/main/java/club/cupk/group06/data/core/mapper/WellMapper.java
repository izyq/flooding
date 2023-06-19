package club.cupk.group06.data.core.mapper;

import club.cupk.group06.data.core.domain.Well;
import club.cupk.group06.data.core.vo.WellVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

@Mapper
@Transactional(rollbackFor = Exception.class)
public interface WellMapper extends BaseMapper<Well> {
    void deletePlanByWellIds(@Param("wellIds") Long[] wellIds);

    void deleteRecordByWellIds(@Param("wellIds") Long[] wellIds);

    void deleteWellByWellIds(@Param("wellIds") Long[] wellIds);

    IPage<WellVo> pageWell(IPage<WellVo> page, @Param("wellName") String wellName,
                           @Param("wellAddress") String wellAddress, @Param("wellField") String wellField,
                           @Param("wellFactory") String wellFactory);
}
