package club.cupk.group06.data.core.vo;

import lombok.Data;

import java.util.List;

/**
 * @author wangdaff
 * @date 2023-06-18 16:27
 * @description
 */
@Data
public class GraphPageVo {
    private Long size;
    private Long total;
    private List<GraphVo> graphVoList;
}
