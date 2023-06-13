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
@TableName(value = "water_flooding_plan")
public class WaterFloodingPlan{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "注水计划", position = 2)
    private String floodingPlan;
    @ApiModelProperty(value = "注水井id", position = 1)
    private Long wellId;
    
    public WaterFloodingPlan(WaterFloodingPlan waterFloodingPlan) {
        if (Objects.nonNull(waterFloodingPlan)) {
            this.floodingPlan=waterFloodingPlan.floodingPlan;
            this.wellId=waterFloodingPlan.wellId;
        }
    }
}
