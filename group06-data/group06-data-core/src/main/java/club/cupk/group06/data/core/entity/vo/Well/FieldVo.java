package club.cupk.waterflood.entity.vo.Well;
import club.cupk.waterflood.domain.Field;
import club.cupk.waterflood.entity.bo.Well.WaterFloodingRecordBo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class FieldVo extends Field {
    private List<WaterFloodingRecordBo> waterFloodingRecordBoList;
    
    public FieldVo(Field field) {
        super(field);
    }
}
