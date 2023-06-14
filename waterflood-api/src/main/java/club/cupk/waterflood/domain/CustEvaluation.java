package club.cupk.waterflood.domain;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "cust_evaluation")
public class CustEvaluation implements Serializable{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "创建时间", position = 6)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @ApiModelProperty(value = "创建人员", position = 5)
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
    @ApiModelProperty(value = "更新时间", position = 8)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    @ApiModelProperty(value = "更新人员", position = 7)
    private Long updateUser;
    
    public CustEvaluation(CustEvaluation custEvaluation) {
        if (Objects.nonNull(custEvaluation)) {
            this.createTime=custEvaluation.createTime;
            this.createUser=custEvaluation.createUser;
            this.custWeight=custEvaluation.custWeight;
            this.evalId=custEvaluation.evalId;
            this.indicatorId=custEvaluation.indicatorId;
            this.schemeId=custEvaluation.schemeId;
            this.updateTime=custEvaluation.updateTime;
            this.updateUser=custEvaluation.updateUser;
        }
    }
}
