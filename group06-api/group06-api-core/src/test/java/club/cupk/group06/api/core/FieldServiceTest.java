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
        System.out.println(fieldService.pageField(pageEntity.toPage(), "下北关呀", null));
    }

    @Test
    /*修改油田的信息*/
    public void updataField(){
        fieldService.updateById(Field
                .builder()
                .fieldId(32l)
                .fieldName("北京交通大学")
                .fieldDesc("北京交通大学")
                .fieldArea(7200F)
                .fieldAddress("北京交通大学")
                .build());
    }

    @Test
    /*删除油田*/
    public void deleteField(){
        fieldService.deleteField(30L);
    }

    @Test
    /*获取油田的详情*/
    public void detail(){
        fieldService.getById(29);
    }

    @Test
    /*批量获得油田列表*/
    public void list(){
        System.out.println(fieldService.getList(Field.builder().fieldAddress("").fieldName("").build()));
    }
}
