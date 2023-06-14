package club.cupk.waterflood.dto.well;

import club.cupk.waterflood.common.GeoPoint;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

/**
 * @author wangdaff
 * @date 2023-06-14 18:10
 * @description
 */
@Data
@With
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WellDTO {
    @ApiModelProperty(value = "注水井名", position = 2)
    private String name;
    @ApiModelProperty(value = "注水井位置", position = 3)
    private String address;
    @ApiModelProperty(value = "注水井经纬度", position = 4)
    private GeoPoint coordinate;
    @ApiModelProperty(value = "注水井深度", position = 5)
    @NotEmpty(message = "注水井深度不能为空")
    private Float depth;
    @ApiModelProperty(value = "注水井直径", position = 6)
    @NotEmpty(message = "注水井深度不能为空")
    private Float dia;
    @ApiModelProperty(value = "注水井开采时间", position = 7)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;
    @ApiModelProperty(value = "注水井开采结束时间", position = 8)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;
    @ApiModelProperty(value = "注水井的开发阶段", position = 9)
    private String period;
    @ApiModelProperty(value = "注水井所属油田id", position = 11)
    private Long field;
    @ApiModelProperty(value = "注水井的负责单位", position = 10)
    private String factory;
}
