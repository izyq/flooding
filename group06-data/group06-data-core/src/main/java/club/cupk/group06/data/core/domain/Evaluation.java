package club.cupk.group06.data.core.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "evaluation")
public class Evaluation implements Serializable{
    private static final long serialVersionUID = 1L;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间", position = 6, hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建人员", position = 5, hidden = true)
    private Long createUser;

    @ApiModelProperty(value = "客制化指标权重", position = 4)
    private Float custWeight;

    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "评价id", position = 1)
    private Long evalId;

    @ApiModelProperty(value = "客制化指标id", position = 3)
    private Long indicatorId;

    @ApiModelProperty(value = "评价方案id", position = 2)
    private Long schemeId;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新时间", position = 8, hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新人员", position = 7, hidden = true)
    private Long updateUser;
    
    public Evaluation(Evaluation evaluation) {
        if (Objects.nonNull(evaluation)) {
            this.createTime= evaluation.createTime;
            this.createUser= evaluation.createUser;
            this.custWeight= evaluation.custWeight;
            this.evalId= evaluation.evalId;
            this.indicatorId= evaluation.indicatorId;
            this.schemeId= evaluation.schemeId;
            this.updateTime= evaluation.updateTime;
            this.updateUser= evaluation.updateUser;
        }
    }
}
