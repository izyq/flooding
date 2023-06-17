package club.cupk.group06.data.core.entity.vo.WaterFloodingRecord;

import club.cupk.group06.data.core.domain.Indicator;
import club.cupk.group06.data.core.entity.bo.WaterFloodingRecord.WellBo;
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
