package club.cupk.group06.data.system.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author wangdaff
 * @date 2023-06-19 14:56
 * @description
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserItemVo {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "用户邮箱")
    private String userEmail;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "手机号码")
    private String userPhone;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "身份")
    private String roleName;

    @ApiModelProperty(value = "注水井")
    private String userWell;

    @ApiModelProperty(value = "身份为管理员时的油田")
    private String managerField;

    @ApiModelProperty(value = "身份为注水井管理员或员工时的油田")
    private String wellField;
}
