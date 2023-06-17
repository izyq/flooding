package club.cupk.group06.data.core.entity.bo.WaterFloodingRecord;

import club.cupk.group06.data.core.domain.Indicator;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * indicator 和 record
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndicatorBo extends Indicator {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "指标值", position = 5)
    private Float recordValue;

    @ApiModelProperty(value = "单条指标记录的id", position = 1)
    private Long recordId;

    @ApiModelProperty(value = "该条指标的产生时间（旧数据）", position = 2)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime recordTime;

    @ApiModelProperty(value = "注水井id", position = 3)
    private Long wellId;

    public IndicatorBo(Indicator indicator) {
        super(indicator);
    }
}
