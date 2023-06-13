package club.cupk.waterflood.entity.bo.Well;
import club.cupk.waterflood.domain.WaterFloodingRecord;
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
/** xin.altitude.cms.code.domain.MetaTable@79c63f57 */
@Data
@AllArgsConstructor
public class WaterFloodingRecordBo extends WaterFloodingRecord{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "注水井的负责单位", position = 10)
    private String factory;
    @ApiModelProperty(value = "注水井所属油田id", position = 11)
    private Long fieldId;
    @ApiModelProperty(value = "注水井位置", position = 3)
    private String wellAddress;
    @ApiModelProperty(value = "注水井经纬度", position = 4)
    private String wellCoordinate;
    @ApiModelProperty(value = "注水井深度", position = 5)
    private Float wellDepth;
    @ApiModelProperty(value = "注水井直径", position = 6)
    private Float wellDia;
    @ApiModelProperty(value = "注水井开采结束时间", position = 8)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime wellMiningEndTime;
    @ApiModelProperty(value = "注水井开采时间", position = 7)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime wellMiningStartTime;
    @ApiModelProperty(value = "注水井名", position = 2)
    private String wellName;
    @ApiModelProperty(value = "注水井的开发阶段", position = 9)
    private String wellPeriod;
    
    public WaterFloodingRecordBo() {
    }
    
    public WaterFloodingRecordBo(WaterFloodingRecord waterFloodingRecord) {
        super(waterFloodingRecord);
    }
}
