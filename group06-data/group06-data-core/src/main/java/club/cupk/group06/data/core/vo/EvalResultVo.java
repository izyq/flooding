package club.cupk.group06.data.core.vo;

import lombok.Data;

/**
 * @author wangdaff
 * @date 2023-06-18 09:56
 * @description
 */
@Data
public class EvalResultVo {
    private String wellName;
    private Long indicatorId;
    private String indicatorName;
    private Float custWeight;
    private Float weightAvg;
    private Float rmdValue;
}
