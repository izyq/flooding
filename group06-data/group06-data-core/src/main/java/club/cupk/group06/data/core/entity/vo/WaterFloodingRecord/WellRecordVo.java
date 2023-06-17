package club.cupk.group06.data.core.entity.vo.WaterFloodingRecord;

import club.cupk.group06.data.core.domain.Well;
import club.cupk.group06.data.core.entity.bo.WaterFloodingRecord.IndicatorBo;

import java.util.List;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WellRecordVo extends Well {

    private List<IndicatorBo> indicatorBoList;

    public WellRecordVo(Well well) {
        super(well);
    }
}
