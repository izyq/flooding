package club.cupk.group06.data.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Data
@With
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "user")
public class UserPo implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "用户id", position = 1)
    private Long userId;

    @ApiModelProperty(value = "用户邮箱", position = 3)
    private String userEmail;

    @ApiModelProperty(value = "用户名", position = 2)
    private String userName;

    @ApiModelProperty(value = "账号密码", position = 5)
    private String userPassword;

    @ApiModelProperty(value = "手机号码", position = 4)
    private String userPhone;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    public UserPo(UserPo userPo) {
        if (Objects.nonNull(userPo)) {
            this.userEmail = userPo.userEmail;
            this.userId = userPo.userId;
            this.userName = userPo.userName;
            this.userPassword = userPo.userPassword;
            this.userPhone = userPo.userPhone;
            this.createTime = userPo.createTime;
            this.updateTime = userPo.updateTime;
        }
    }
}
