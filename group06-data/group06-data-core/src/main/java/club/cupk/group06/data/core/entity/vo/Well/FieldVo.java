package club.cupk.group06.data.core.entity.vo.Well;

import club.cupk.group06.data.core.domain.Field;
import club.cupk.group06.data.core.entity.bo.Well.WaterFloodingRecordBo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FieldVo extends Field {
    private List<WaterFloodingRecordBo> waterFloodingRecordBoList;

    public FieldVo(Field field) {
        super(field);
    }
}
