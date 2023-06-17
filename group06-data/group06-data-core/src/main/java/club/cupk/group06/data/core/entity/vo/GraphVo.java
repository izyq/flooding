package club.cupk.group06.data.core.entity.vo;

import lombok.Data;

/**
 * @author wangdaff
 * @date 2023-06-17 15:56
 * @description
 */
@Data
public class GraphVo {
    private Long wellId;
    private String wellName;
    private String factory;
    private Long indicatorId;
    private String indicatorName;
    private String indicatorUnit;
    private Long theYear;
    private Long mon;
    private Float monAvg;

}
