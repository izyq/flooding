package club.cupk.group06.data.core.entity.vo.well;

import club.cupk.group06.data.core.domain.Record;
import club.cupk.group06.data.core.entity.bo.well.FieldBo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecordVo extends Record {
    private List<FieldBo> fieldBoList;

    public RecordVo(Record record) {
        super(record);
    }
}
