package club.cupk.group06.data.core.entity.vo;

import club.cupk.group06.data.core.domain.CustEvaluation;
import club.cupk.group06.data.core.domain.Indicator;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * evaluation和indicator
 *
 * @author izyq
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class CustEvaluationVo extends CustEvaluation {
    private static final long serialVersionUID = 1L;

    private Indicator indicator;

    public CustEvaluationVo() {
    }

    public CustEvaluationVo(CustEvaluation custEvaluation) {
        super(custEvaluation);
        this.indicator = new Indicator();
    }
}
