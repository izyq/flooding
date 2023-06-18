package club.cupk.group06.data.core.entity.vo;

import club.cupk.group06.data.core.domain.Evaluation;
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
public class EvaluationVo extends Evaluation {
    private static final long serialVersionUID = 1L;

    private Indicator indicator;

    public EvaluationVo() {
    }

    public EvaluationVo(Evaluation evaluation) {
        super(evaluation);
        this.indicator = new Indicator();
    }
}
