package club.cupk.waterflood.dto.filed;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotEmpty;

/**
 * @Auther: izyq
 * @Date: 2023/6/13
 * @Vertion 1.0
 */
@Data
@With
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FieldDTO {
    @ApiModelProperty(value = "油田地址", position = 3)
    private String address;
    @ApiModelProperty(value = "油田面积", position = 4)
    private Float area;
    @ApiModelProperty(value = "油田其他描述", position = 5)
    private String desc;
    @ApiModelProperty(value = "油田名", position = 2)
    @NotEmpty(message = "油田名不能为空")
    private String name;
}
