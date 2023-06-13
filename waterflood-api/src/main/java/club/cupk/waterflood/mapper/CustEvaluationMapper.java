package club.cupk.waterflood.mapper;
import club.cupk.waterflood.domain.CustEvaluation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;
@Mapper
@Transactional(rollbackFor = Exception.class)
public interface CustEvaluationMapper extends BaseMapper<CustEvaluation>{
}
