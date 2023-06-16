package club.cupk.waterflood.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "water_flooding_record")
public class WaterFloodingRecord implements Serializable{
    private static final long serialVersionUID = 1L;
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间", position = 7, hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建人员", position = 6, hidden = true)
    private Long createUser;

    @ApiModelProperty(value = "指标值", position = 5)
    private Float recordValue;

    @ApiModelProperty(value = "该条指标的id", position = 4)
    private Long indicatorId;

    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "单条指标记录的id", position = 1)
    private Long recordId;

    @ApiModelProperty(value = "该条指标的产生时间（旧数据）", position = 2)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime recordTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新时间", position = 9, hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新人员", position = 8, hidden = true)
    private Long updateUser;

    @ApiModelProperty(value = "注水井id", position = 3)
    private Long wellId;
    
    public WaterFloodingRecord(WaterFloodingRecord waterFloodingRecord) {
        if (Objects.nonNull(waterFloodingRecord)) {
            this.createTime=waterFloodingRecord.createTime;
            this.createUser=waterFloodingRecord.createUser;
            this.recordValue=waterFloodingRecord.recordValue;
            this.indicatorId=waterFloodingRecord.indicatorId;
            this.recordId=waterFloodingRecord.recordId;
            this.recordTime=waterFloodingRecord.recordTime;
            this.updateTime=waterFloodingRecord.updateTime;
            this.updateUser=waterFloodingRecord.updateUser;
            this.wellId=waterFloodingRecord.wellId;
        }
    }
}
