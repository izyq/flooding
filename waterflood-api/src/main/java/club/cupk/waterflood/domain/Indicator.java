package club.cupk.waterflood.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName(value = "indicator")
public class Indicator implements Serializable{
    private static final long serialVersionUID = 1L;
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间", position = 11, hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建人员", position = 10, hidden = true)
    private Long createUser;

    @ApiModelProperty(value = "默认权重", position = 7)
    private Float defaultWeight;

    @ApiModelProperty(value = "其他描述，例如该条指标的推荐范围", position = 9)
    private String description;

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

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新时间", position = 13, hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新人员", position = 12, hidden = true)
    private Long updateUser;
    
    public Indicator(Indicator indicator) {
        if (Objects.nonNull(indicator)) {
            this.createTime=indicator.createTime;
            this.createUser=indicator.createUser;
            this.defaultWeight=indicator.defaultWeight;
            this.description=indicator.description;
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
