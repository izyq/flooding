package club.cupk.group06.api.core;


import club.cupk.group06.api.core.service.WellService;
import club.cupk.group06.data.core.domain.Well;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xin.altitude.cms.common.entity.PageEntity;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WellSeriviceTests {

    @Resource
    private WellService wellService;

    @Test
    /*测试添加油井*/
    public void addWellTest(){
        wellService.save(Well.builder()
                .wellName("北下关一号")
                .wellAddress("北下关一号")
                .wellCoordinate(null)
                .wellDepth(1.0F)
                .wellDia(1.0F)
                .startTime(LocalDateTime.now())
                .endTime(LocalDateTime.now())
                .wellPeriod("北下关一号")
                .fieldId(1L)
                .wellFactory("北下关一号")
                .build());
    }

    @Test
    /*分页查询油井*/
    public void pageTest(){
        PageEntity pageEntity = new PageEntity(2L, 10L);
        wellService.getPage(pageEntity.toPage(), Well.builder().wellName("克校区").build());
    }

    @Test
    /*获取油井list*/
    public void getListTest(){
        System.out.println(wellService.getList(Well.builder().wellName("").build()));
    }

    @Test
    /*删除油井*/
    public void deleteWellTest(){
        Long[] target = {24L};
        wellService.deleteWell(target);
    }

    @Test
    /*查看油井详情*/
    public void detailTest(){
        wellService.getById(23L);
    }

    @Test
    /*修改油井的信息*/
    public void editTest(){
        wellService.updateById(Well.builder()
                .wellId(25L)
                .wellName("交大嘉园")
                .wellAddress("交大嘉园")
                .wellCoordinate(null)
                .wellDepth(10F)
                .wellDia(10F)
                .startTime(LocalDateTime.now())
                .endTime(LocalDateTime.now())
                .wellPeriod("交大嘉园")
                .fieldId(1L)
                .wellFactory("交大嘉园")
                .build());
    }
}
