package club.cupk.waterflood;

import club.cupk.waterflood.domain.Well;
import club.cupk.waterflood.mapper.FieldMapper;
import club.cupk.waterflood.mapper.WellMapper;
import club.cupk.waterflood.service.IWellService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = ServiceProviderApplication.class)
@AutoConfigureMockMvc
public class ProvideApplicationTests {
    @Autowired
    FieldMapper fieldMapper;

    @Autowired
    WellMapper wellMapper;


    @Test
    public void testFieldMapper(){
        fieldMapper.findAllFields().forEach(System.out::println);
    }

    @Test
    public void deleteField(){
        fieldMapper.deleteRecordByFieldId(15L);
        fieldMapper.deletePlanByFieldId(15L);
        fieldMapper.deleteWellByFieldId(15L);
        fieldMapper.deleteFieldByFieldId(15L);
    }

    @Test
    public void deleteWell(){
        Long[] tar = {5L, 6L};
        wellMapper.deleteRecordByWellIds(tar);
        wellMapper.deletePlanByWellIds(tar);
        wellMapper.deleteWellByWellIds(tar);
    }
}
