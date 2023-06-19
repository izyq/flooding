package club.cupk.group06.api.core;

import club.cupk.group06.api.core.service.FieldService;
import club.cupk.group06.api.core.service.IndicatorService;
import club.cupk.group06.data.core.domain.Indicator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xin.altitude.cms.common.entity.PageEntity;

import javax.annotation.Resource;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IndicatorServiceTests {

    @Resource
    private IndicatorService indicatorService;

    @Test
    /*新增指标*/
    public void add(){
        indicatorService.save(Indicator.builder()
                .indicatorName("北京")
                .floodingPlan("北京")
                .indicatorType("北京")
                .indicatorUnit("北京")
                .important(1)
                .defaultWeight(1F)
                .rmdValue(1F)
                .description("北京").build()
        );
    }

    @Test
    /*编辑指标*/
    public void edit(){
        indicatorService.updateById(Indicator.builder()
                        .indicatorId(21L)
                        .indicatorName("北京")
                        .floodingPlan("北京")
                        .indicatorType("北京")
                        .indicatorUnit("北京")
                        .important(1)
                        .defaultWeight(1F)
                        .rmdValue(1F)
                        .description("北京").build()
                );
    }

    @Test
    /*删除指标*/
    public void delete(){
        Long[] ids = {20L, 21L};
        indicatorService.removeByIds(Arrays.asList(ids));
    }

    @Test
    /*分页查询*/
    public void page() {
        PageEntity pageEntity = new PageEntity(1L, 10L);
        indicatorService.getIndicatorByName(pageEntity.toPage(), Indicator.builder()
                .indicatorName("新疆油田")
                .floodingPlan("注水井")
                .build());
    }
}
