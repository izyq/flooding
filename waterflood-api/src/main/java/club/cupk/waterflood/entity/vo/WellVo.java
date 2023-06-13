package club.cupk.waterflood.entity.vo;
import club.cupk.waterflood.domain.WaterFloodingPlan;
import club.cupk.waterflood.domain.Well;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
@Data
public class WellVo extends Well{
    private static final long serialVersionUID = 1L;
    private List<WaterFloodingPlan> waterFloodingPlanList;
    
    public WellVo() {
    }
    
    public WellVo(Well well) {
        super(well);
    }
}
