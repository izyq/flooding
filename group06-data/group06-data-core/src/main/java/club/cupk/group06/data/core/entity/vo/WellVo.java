package club.cupk.group06.data.core.entity.vo;

import club.cupk.group06.data.core.domain.WaterFloodingPlan;
import club.cupk.group06.data.core.domain.Well;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class WellVo extends Well {
    private static final long serialVersionUID = 1L;

    private List<WaterFloodingPlan> waterFloodingPlanList;

    public WellVo(Well well) {
        super(well);
    }
}
