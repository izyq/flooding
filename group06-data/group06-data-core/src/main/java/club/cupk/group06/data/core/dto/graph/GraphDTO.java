package club.cupk.group06.data.core.dto.graph;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author wangdaff
 * @date 2023-06-17 16:02
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GraphDTO {
    private long current = 1L;
    private long size = 10L;
    private Long year;
    private Long indicatorId;
    private String factory;
}
