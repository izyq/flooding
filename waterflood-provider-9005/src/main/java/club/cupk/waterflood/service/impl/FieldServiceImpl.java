package club.cupk.waterflood.service.impl;
import club.cupk.waterflood.domain.Field;
import club.cupk.waterflood.mapper.FieldMapper;
import club.cupk.waterflood.service.IFieldService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
@Service
public class FieldServiceImpl extends ServiceImpl<FieldMapper,Field> implements IFieldService{
}
