package club.cupk.group06.api.core;

import club.cupk.group06.api.core.service.EvalResultService;
import club.cupk.group06.api.core.service.WellService;
import club.cupk.group06.data.core.domain.Well;
import club.cupk.group06.data.core.dto.indicator.EvalResDTO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTests {
    @Autowired
    WellService wellService;

    @Test
    public void addWell(){
        wellService.save(Well.builder()
                .wellName("ceshiya")
                .wellAddress("ceshiya")
                .wellCoordinate(null)
                .wellDepth(1.0F)
                .wellDia(1F)
                .startTime(LocalDateTime.now())
                .endTime(LocalDateTime.now())
                .wellPeriod("")
                .fieldId(1L)
                .wellFactory("wellDTO.getFactory()")
                .build()
        );
    }

    @Autowired
    EvalResultService evalResultService;
    @Test
    public void getEvalResultTest(){
        System.out.println(evalResultService.getEvaluationResult(new Page(1, 2), EvalResDTO.builder()
                .year(2023L)
                .schemeId(6L)
                .wellName("一").build()));
    }
}
