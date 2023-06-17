package club.cupk.group06.data.core.entity.vo.Well;

import club.cupk.group06.data.core.domain.WaterFloodingRecord;
import club.cupk.group06.data.core.entity.bo.Well.FieldBo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WaterFloodingRecordVo extends WaterFloodingRecord {
    private List<FieldBo> fieldBoList;

    public WaterFloodingRecordVo(WaterFloodingRecord waterFloodingRecord) {
        super(waterFloodingRecord);
    }
}
