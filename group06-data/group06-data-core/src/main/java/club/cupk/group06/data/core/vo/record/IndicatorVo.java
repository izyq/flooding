package club.cupk.group06.data.core.vo.record;

import club.cupk.group06.data.core.domain.Indicator;
import club.cupk.group06.data.core.bo.record.WellBo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class IndicatorVo extends Indicator {
    private List<WellBo> wellBoList;

    public IndicatorVo(Indicator indicator) {
        super(indicator);
    }
}
