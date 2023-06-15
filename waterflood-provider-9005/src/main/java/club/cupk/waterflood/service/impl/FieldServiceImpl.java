package club.cupk.waterflood.service.impl;
import club.cupk.waterflood.domain.Field;
import club.cupk.waterflood.mapper.FieldMapper;
import club.cupk.waterflood.service.IFieldService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.Exceptions;

import java.util.List;

@DubboService
@Component
public class FieldServiceImpl extends ServiceImpl<FieldMapper,Field> implements IFieldService{

    @Autowired
    FieldMapper fieldMapper;
    @Override
    public List<Field> getList(Field field) {
        return fieldMapper.selectList(Wrappers.lambdaQuery(field));
    }

    @Override
    public Page<Field> getPage(Page page, Field field) {
        return page(page,Wrappers.lambdaQuery(field));
    }
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Object deleteField(Long id){
        fieldMapper.deleteRecordByFieldId(id);
        fieldMapper.deletePlanByFieldId(id);
        fieldMapper.deleteWellByFieldId(id);
        fieldMapper.deleteFieldByFieldId(id);
        return null;
    }
}
