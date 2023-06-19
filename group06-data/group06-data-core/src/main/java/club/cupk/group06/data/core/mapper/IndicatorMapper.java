package club.cupk.group06.data.core.mapper;

import club.cupk.group06.data.core.domain.Indicator;
import club.cupk.group06.data.core.dto.indicator.EvalResDTO;
import club.cupk.group06.data.core.vo.EvalResultVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
@Transactional(rollbackFor = Exception.class)
public interface IndicatorMapper extends BaseMapper<Indicator> {
    List<EvalResultVo> getEvaluationResult(EvalResDTO evalResDTO);
    Long getEvalResCount(EvalResDTO evalResDTO);
}
