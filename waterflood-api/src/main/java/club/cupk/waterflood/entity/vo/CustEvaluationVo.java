package club.cupk.waterflood.entity.vo;

import club.cupk.waterflood.domain.CustEvaluation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * cust_evaluation和indicator
 * @author izyq
 **/
@Data
public class CustEvaluationVo extends CustEvaluation{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "默认权重", position = 7)
    private Float defaultWeight;
    @ApiModelProperty(value = "其他描述，例如该条指标的推荐范围", position = 9)
    private String desc;
    @ApiModelProperty(value = "指标所属注水计划", position = 3)
    private String floodingPlan;
    @ApiModelProperty(value = "是否为重要指标", position = 6)
    private Integer important;
    @ApiModelProperty(value = "指标名", position = 2)
    private String indicatorName;
    @ApiModelProperty(value = "指标所属类型", position = 4)
    private String indicatorType;
    @ApiModelProperty(value = "指标单位", position = 5)
    private String indicatorUnit;
    @ApiModelProperty(value = "指标推荐值", position = 8)
    private Float rmdValue;
    
    public CustEvaluationVo() {
    }
    
    public CustEvaluationVo(CustEvaluation custEvaluation) {
        super(custEvaluation);
    }
}
