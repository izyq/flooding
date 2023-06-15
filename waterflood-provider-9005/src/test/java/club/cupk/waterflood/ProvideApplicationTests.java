package club.cupk.waterflood;

import club.cupk.waterflood.domain.Field;
import club.cupk.waterflood.mapper.FieldMapper;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = ServiceProviderApplication.class)
@AutoConfigureMockMvc
public class ProvideApplicationTests {
    @Autowired
    FieldMapper fieldMapper;
    @Test
    public void testFieldMapper(){
        fieldMapper.findAllFields().forEach(System.out::println);
    }
}
