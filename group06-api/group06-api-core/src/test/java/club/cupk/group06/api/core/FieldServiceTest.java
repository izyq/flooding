package club.cupk.group06.api.core;

import club.cupk.group06.data.core.domain.Field;
import club.cupk.group06.data.core.mapper.FieldMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

    @Test
    public void addFieldTest(){
        fieldMapper.insert(Field.builder()
                .fieldName("d12423433")
                .fieldAddress("qqqqqq")
                .fieldArea(123f)
                .fieldDesc("safdgdh").build());
    }
}
