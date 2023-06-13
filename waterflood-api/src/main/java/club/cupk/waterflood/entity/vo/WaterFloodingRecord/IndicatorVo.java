package club.cupk.waterflood.entity.vo.WaterFloodingRecord;
import club.cupk.waterflood.domain.Indicator;
import club.cupk.waterflood.entity.bo.WaterFloodingRecord.WellBo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class IndicatorVo extends Indicator {
    private List<WellBo> wellBoList;
    
    public IndicatorVo(Indicator indicator) {
        super(indicator);
    }
}
