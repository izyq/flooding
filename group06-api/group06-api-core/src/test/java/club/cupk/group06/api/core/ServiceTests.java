package club.cupk.group06.api.core;

import club.cupk.group06.api.core.service.WellService;
import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.core.domain.Well;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Date;

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
                .wellMiningStartTime(LocalDateTime.now())
                .wellMiningEndTime(LocalDateTime.now())
                .wellPeriod("")
                .fieldId(1L)
                .factory("wellDTO.getFactory()")
                .build()
        );
    }
}
