package club.cupk.waterflood.entity.vo.Well;
import club.cupk.waterflood.domain.WaterFloodingRecord;
import club.cupk.waterflood.entity.bo.Well.FieldBo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class WaterFloodingRecordVo extends WaterFloodingRecord {
    private List<FieldBo> fieldBoList;
    
    public WaterFloodingRecordVo(WaterFloodingRecord waterFloodingRecord) {
        super(waterFloodingRecord);
    }
}
