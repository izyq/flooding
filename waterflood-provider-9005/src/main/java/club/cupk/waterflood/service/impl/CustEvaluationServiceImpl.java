package club.cupk.waterflood.service.impl;
import club.cupk.waterflood.domain.CustEvaluation;
import club.cupk.waterflood.mapper.CustEvaluationMapper;
import club.cupk.waterflood.service.ICustEvaluationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;


@DubboService
@Component
public class CustEvaluationServiceImpl extends ServiceImpl<CustEvaluationMapper,CustEvaluation> implements ICustEvaluationService{

}
