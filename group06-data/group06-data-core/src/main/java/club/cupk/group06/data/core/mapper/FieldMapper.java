package club.cupk.group06.data.core.mapper;
import club.cupk.waterflood.domain.Field;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
@Transactional(rollbackFor = Exception.class)
public interface FieldMapper extends BaseMapper<Field>{
    List<Field> findAllFields();

    void deletePlanByFieldId(Long fieldId);

    void deleteRecordByFieldId(Long fieldId);

    void deleteWellByFieldId(Long fieldId);

    void deleteFieldByFieldId(Long fieldId);
}
