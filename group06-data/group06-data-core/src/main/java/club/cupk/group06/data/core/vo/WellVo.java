package club.cupk.group06.data.core.vo;

import club.cupk.group06.data.core.domain.Plan;
import club.cupk.group06.data.core.domain.Well;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class WellVo extends Well {
    private static final long serialVersionUID = 1L;

    private List<Plan> planList;

    @TableField("field.field_name")
    private String wellField;

    public WellVo(Well well) {
        super(well);
    }
}
