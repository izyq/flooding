package club.cupk.group06.api.core;

import club.cupk.group06.api.core.service.GraphService;
import lombok.AllArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestParam;
import xin.altitude.cms.common.entity.PageEntity;

@RunWith(SpringRunner.class)
@SpringBootTest

public class GraphServiceTests {

    @Autowired
    private GraphService graphService;

    @Test
    /*获取图表信息*/
    public void getTest(){
        PageEntity pageEntity = new PageEntity(1L, 10L);
        Long indicatorId = 1L;
        Long year = 2023L;
        String factory = "keyouyihao";
        graphService.getGraph(pageEntity.toPage(),indicatorId, year, factory);
    }

    @Test
    /*获取可选指标名*/
    public void getVisualIndicatorTest(){
        graphService.getVisualIndicator();
    }

    @Test
    /*添加指标为可视化指标*/
    public void addVisualIndicatorTest() {
            Integer indicatorId = 1;
            graphService.addVisualIndicator(indicatorId);
        }
    }

