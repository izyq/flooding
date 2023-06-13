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
@NoArgsConstructor
@AllArgsConstructor
public class EditFieldDTO extends FieldDTO {
    @ApiModelProperty(value = "油田id", position = 1)
    @NotEmpty(message = "油田id不能为空")
    private Long id;
}
