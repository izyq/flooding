package club.cupk.group06.api.core;

import club.cupk.group06.api.core.service.FieldService;
import club.cupk.group06.data.core.domain.Field;
import club.cupk.group06.data.core.mapper.FieldMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xin.altitude.cms.common.entity.PageEntity;

import javax.annotation.Resource;

/**
 * @author wangdaff
 * @date 2023-06-18 00:28
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FieldServiceTest {
    @Resource
    private FieldMapper fieldMapper;
    @Resource
    private FieldService fieldService;

    @Test
    /*添加油田测试*/
    public void addFieldTest(){
        fieldMapper.insert(Field.builder()
                .fieldName("北下关管")
                .fieldAddress("北下关管")
                .fieldArea(1235f)
                .fieldDesc("北下关管").build());
    }

    @Test
    /*分页查询油田*/
    public void fieldPage(){
        PageEntity pageEntity = new PageEntity(1L, 10L);
        System.out.println(fieldService.getPage(pageEntity.toPage(), Field.builder().fieldName("北下关呀").build()));
    }
}
