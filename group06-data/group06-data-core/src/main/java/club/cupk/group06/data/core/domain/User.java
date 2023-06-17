package club.cupk.group06.data.core.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName(value = "user")
public class User implements Serializable{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户邮箱", position = 3)
    private String userEmail;

    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "用户id", position = 1)
    private Long userId;

    @ApiModelProperty(value = "用户名", position = 2)
    private String userName;

    @ApiModelProperty(value = "账号密码", position = 5)
    private String userPassword;

    @ApiModelProperty(value = "用户手机号码", position = 4)
    private String userPhone;
    
    public User(User user) {
        if (Objects.nonNull(user)) {
            this.userEmail=user.userEmail;
            this.userId=user.userId;
            this.userName=user.userName;
            this.userPassword=user.userPassword;
            this.userPhone=user.userPhone;
        }
    }
}
