package club.cupk.group06.data.core.vo;

import club.cupk.group06.data.core.domain.Evaluation;
import club.cupk.group06.data.core.domain.Indicator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndicatorVo extends Indicator {

    private static final long serialVersionUID = 1L;

    private List<Evaluation> evaluationList;

    public IndicatorVo(Indicator indicator) {
        super(indicator);
    }
}
