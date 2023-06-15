package club.cupk.waterflood.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@TableName(value = "field")
public class Field implements Serializable{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "创建时间", position = 7, hidden = true)
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建人员", position = 6, hidden = true)
    private Long createUser;

    @ApiModelProperty(value = "油田地址", position = 3)
    private String fieldAddress;

    @ApiModelProperty(value = "油田面积", position = 4)
    private Float fieldArea;

    @ApiModelProperty(value = "油田其他描述", position = 5)
    private String fieldDesc;

    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "油田id", position = 1)
    private Long fieldId;

    @ApiModelProperty(value = "油田名", position = 2)
    private String fieldName;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新时间", position = 9, hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新人员", position = 8, hidden = true)
    private Long updateUser;
    
    public Field(Field field) {
        if (Objects.nonNull(field)) {
            this.createTime=field.createTime;
            this.createUser=field.createUser;
            this.fieldAddress=field.fieldAddress;
            this.fieldArea=field.fieldArea;
            this.fieldDesc=field.fieldDesc;
            this.fieldId=field.fieldId;
            this.fieldName=field.fieldName;
            this.updateTime=field.updateTime;
            this.updateUser=field.updateUser;
        }
    }
}
