package club.cupk.group06.data.core.entity.bo.WaterFloodingRecord;

import club.cupk.group06.data.core.domain.Well;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * xin.altitude.cms.code.domain.MetaTable@113254e9
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WellBo extends Well {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "指标值", position = 5)
    private Float recordValue;

    @ApiModelProperty(value = "该条指标的id", position = 4)
    private Long indicatorId;

    @ApiModelProperty(value = "单条指标记录的id", position = 1)
    private Long recordId;

    @ApiModelProperty(value = "该条指标的产生时间（旧数据）", position = 2)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime recordTime;

    public WellBo(Well well) {
        super(well);
    }
}
