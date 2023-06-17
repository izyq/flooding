package club.cupk.group06.data.core.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "plan")
public class WaterFloodingPlan implements Serializable{
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
