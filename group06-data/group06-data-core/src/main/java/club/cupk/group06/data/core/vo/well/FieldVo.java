package club.cupk.group06.data.core.vo.well;

import club.cupk.group06.data.core.domain.Field;
import club.cupk.group06.data.core.bo.well.RecordBo;
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
    private List<RecordBo> waterFloodingRecordBoList;

    public FieldVo(Field field) {
        super(field);
    }
}
