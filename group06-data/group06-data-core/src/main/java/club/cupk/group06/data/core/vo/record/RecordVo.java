package club.cupk.group06.data.core.vo.record;

import club.cupk.group06.data.core.common.GeoPoint;
import club.cupk.group06.data.core.domain.Record;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RecordVo extends Record{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "注水井名", position = 2)
    private String wellName;
    @ApiModelProperty(value = "注水井位置", position = 3)
    private String wellAddress;
    @ApiModelProperty(value = "注水井经纬度", position = 4)
    private String wellCoordinate;
    @ApiModelProperty(value = "注水井深度", position = 5)
    private Float wellDepth;
    @ApiModelProperty(value = "注水井直径", position = 6)
    private Float wellDia;
    @ApiModelProperty(value = "注水井开采时间", position = 7)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;
    @ApiModelProperty(value = "注水井开采结束时间", position = 8)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;
    @ApiModelProperty(value = "注水井的开发阶段", position = 9)
    private String wellPeriod;
    @ApiModelProperty(value = "注水井的负责单位", position = 10)
    private String wellFactory;
    @ApiModelProperty(value = "注水井所属油田id", position = 11)
    private Long fieldId;

    public RecordVo() {
    }

    public RecordVo(Record record) {
        super(record);
    }
}
