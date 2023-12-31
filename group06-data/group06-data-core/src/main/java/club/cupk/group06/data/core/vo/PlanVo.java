package club.cupk.group06.data.core.vo;

import club.cupk.group06.data.core.domain.Plan;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

import lombok.Data;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class PlanVo extends Plan {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "创建时间", position = 13)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "创建人员", position = 12)
    private Long createUser;

    @ApiModelProperty(value = "注水井的负责单位", position = 10)
    private String factory;

    @ApiModelProperty(value = "注水井所属油田id", position = 11)
    private Long fieldId;

    @ApiModelProperty(value = "更新时间", position = 15)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "更新人员", position = 14)
    private Long updateUser;

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

    public PlanVo(Plan plan) {
        super(plan);
    }
}
