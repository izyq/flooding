package club.cupk.group06.data.core.entity.vo.Well;

import club.cupk.group06.data.core.entity.vo.EvalResultVo;
import lombok.Data;

import java.util.List;

/**
 * @author wangdaff
 * @date 2023-06-18 10:48
 * @description
 */
@Data
public class EvalResultPageVo {
    private Long size;
    private Long total;
    private List<EvalResultVo> evalResultVoList;
}
