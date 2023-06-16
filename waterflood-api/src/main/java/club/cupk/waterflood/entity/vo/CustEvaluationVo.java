package club.cupk.waterflood.entity.vo;

import club.cupk.waterflood.domain.CustEvaluation;
import club.cupk.waterflood.domain.Indicator;
import lombok.Data;
/**
 * cust_evaluation和indicator
 * @author izyq
 **/
@Data
public class CustEvaluationVo extends CustEvaluation{
    private static final long serialVersionUID = 1L;

    private Indicator indicator;
    public CustEvaluationVo() {
    }
    
    public CustEvaluationVo(CustEvaluation custEvaluation) {
        super(custEvaluation);
        this.indicator = new Indicator();
    }
}
