package club.cupk.waterflood.entity.bo.WaterFloodingRecord;
import club.cupk.waterflood.domain.Indicator;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModelProperty;
/** xin.altitude.cms.code.domain.MetaTable@33b12df9 */
@Data
@AllArgsConstructor
public class IndicatorBo extends Indicator{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "指标值", position = 5)
    private String data;
    @ApiModelProperty(value = "单条指标记录的id", position = 1)
    private Long recordId;
    @ApiModelProperty(value = "该条指标的产生时间（旧数据）", position = 2)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime recordTime;
    @ApiModelProperty(value = "注水井id", position = 3)
    private Long wellId;
    
    public IndicatorBo() {
    }
    
    public IndicatorBo(Indicator indicator) {
        super(indicator);
    }
}
