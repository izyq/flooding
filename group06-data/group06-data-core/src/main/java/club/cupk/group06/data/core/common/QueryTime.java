package club.cupk.group06.data.core.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryTime {

    @ApiModelProperty(value = "通用查询参数-开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date startTimeQuery;

    @ApiModelProperty(value = "通用查询参数-结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date endTimeQuery;
}
