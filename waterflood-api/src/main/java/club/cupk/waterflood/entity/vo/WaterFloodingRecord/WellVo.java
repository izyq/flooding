package club.cupk.waterflood.entity.vo.WaterFloodingRecord;
import club.cupk.waterflood.domain.Well;
import club.cupk.waterflood.entity.bo.WaterFloodingRecord.IndicatorBo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class WellVo extends Well {
    private List<IndicatorBo> indicatorBoList;
    
    public WellVo(Well well) {
        super(well);
    }
}
