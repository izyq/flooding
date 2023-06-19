package club.cupk.group06.data.core.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author wangdaff
 * @date 2023-06-18 23:57
 * @description
 */
@Data
@Accessors(chain = true)
public class WellPageVo {
    private List<WellVo> wellVoList;
    private Long size;
    private Long total;
}
