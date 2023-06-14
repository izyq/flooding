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
@TableName(value = "well")
public class Well implements Serializable{
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
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "注水井id", position = 1)
    private Long wellId;
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
    
    public Well(Well well) {
        if (Objects.nonNull(well)) {
            this.createTime=well.createTime;
            this.createUser=well.createUser;
            this.factory=well.factory;
            this.fieldId=well.fieldId;
            this.updateTime=well.updateTime;
            this.updateUser=well.updateUser;
            this.wellAddress=well.wellAddress;
            this.wellCoordinate=well.wellCoordinate;
            this.wellDepth=well.wellDepth;
            this.wellDia=well.wellDia;
            this.wellId=well.wellId;
            this.wellMiningEndTime=well.wellMiningEndTime;
            this.wellMiningStartTime=well.wellMiningStartTime;
            this.wellName=well.wellName;
            this.wellPeriod=well.wellPeriod;
        }
    }
}
