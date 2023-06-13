package club.cupk.waterflood.entity.vo;
import club.cupk.waterflood.domain.CustEvaluation;
import club.cupk.waterflood.domain.Indicator;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
@Data
public class IndicatorVo extends Indicator{
    private static final long serialVersionUID = 1L;
    private List<CustEvaluation> custEvaluationList;
    
    public IndicatorVo() {
    }
    
    public IndicatorVo(Indicator indicator) {
        super(indicator);
    }
}
