package club.cupk.group06.data.core.dto.indicator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangdaff
 * @date 2023-06-18 10:03
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EvalResDTO {
    private long current = 1L;
    private long size = 10L;
    private String wellName;
    private Long year;
    private Long schemeId;
}
