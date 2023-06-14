package club.cupk.waterflood.domain;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "water_flooding_record")
public class WaterFloodingRecord implements Serializable{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "创建时间", position = 7)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @ApiModelProperty(value = "创建人员", position = 6)
    private Long createUser;
    @ApiModelProperty(value = "指标值", position = 5)
    private Float data;
    @ApiModelProperty(value = "该条指标的id", position = 4)
    private Long indicatorId;
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "单条指标记录的id", position = 1)
    private Long recordId;
    @ApiModelProperty(value = "该条指标的产生时间（旧数据）", position = 2)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime recordTime;
    @ApiModelProperty(value = "更新时间", position = 9)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    @ApiModelProperty(value = "更新人员", position = 8)
    private Long updateUser;
    @ApiModelProperty(value = "注水井id", position = 3)
    private Long wellId;
    
    public WaterFloodingRecord(WaterFloodingRecord waterFloodingRecord) {
        if (Objects.nonNull(waterFloodingRecord)) {
            this.createTime=waterFloodingRecord.createTime;
            this.createUser=waterFloodingRecord.createUser;
            this.data=waterFloodingRecord.data;
            this.indicatorId=waterFloodingRecord.indicatorId;
            this.recordId=waterFloodingRecord.recordId;
            this.recordTime=waterFloodingRecord.recordTime;
            this.updateTime=waterFloodingRecord.updateTime;
            this.updateUser=waterFloodingRecord.updateUser;
            this.wellId=waterFloodingRecord.wellId;
        }
    }
}
