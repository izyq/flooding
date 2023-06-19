package club.cupk.group06.data.core.mapper;

import club.cupk.group06.data.core.domain.Record;
import club.cupk.group06.data.core.dto.graph.GraphDTO;
import club.cupk.group06.data.core.vo.GraphVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
@Transactional(rollbackFor = Exception.class)
public interface RecordMapper extends BaseMapper<Record> {
    List<GraphVo> getRecordByYearAndFactory(GraphDTO graphDTO);
}
