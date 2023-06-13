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
@TableName(value = "indicator")
public class Indicator{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "创建时间", position = 11)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @ApiModelProperty(value = "创建人员", position = 10)
    private Long createUser;
    @ApiModelProperty(value = "默认权重", position = 7)
    private Float defaultWeight;
    @ApiModelProperty(value = "其他描述，例如该条指标的推荐范围", position = 9)
    private String desc;
    @ApiModelProperty(value = "指标所属注水计划", position = 3)
    private String floodingPlan;
    @ApiModelProperty(value = "是否为重要指标", position = 6)
    private Integer important;
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "指标id", position = 1)
    private Long indicatorId;
    @ApiModelProperty(value = "指标名", position = 2)
    private String indicatorName;
    @ApiModelProperty(value = "指标所属类型", position = 4)
    private String indicatorType;
    @ApiModelProperty(value = "指标单位", position = 5)
    private String indicatorUnit;
    @ApiModelProperty(value = "指标推荐值", position = 8)
    private Float rmdValue;
    @ApiModelProperty(value = "更新时间", position = 13)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    @ApiModelProperty(value = "更新人员", position = 12)
    private Long updateUser;
    
    public Indicator(Indicator indicator) {
        if (Objects.nonNull(indicator)) {
            this.createTime=indicator.createTime;
            this.createUser=indicator.createUser;
            this.defaultWeight=indicator.defaultWeight;
            this.desc=indicator.desc;
            this.floodingPlan=indicator.floodingPlan;
            this.important=indicator.important;
            this.indicatorId=indicator.indicatorId;
            this.indicatorName=indicator.indicatorName;
            this.indicatorType=indicator.indicatorType;
            this.indicatorUnit=indicator.indicatorUnit;
            this.rmdValue=indicator.rmdValue;
            this.updateTime=indicator.updateTime;
            this.updateUser=indicator.updateUser;
        }
    }
}
