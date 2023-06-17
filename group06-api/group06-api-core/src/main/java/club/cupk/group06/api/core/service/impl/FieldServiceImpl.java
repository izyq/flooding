package club.cupk.group06.api.core.service.impl;

import club.cupk.group06.api.core.service.FieldService;
import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.core.domain.Field;
import club.cupk.group06.data.core.mapper.FieldMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FieldServiceImpl extends ServiceImpl<FieldMapper, Field> implements FieldService {

    FieldMapper fieldMapper;

    @Override
    public List<Field> getList(Field field) {
        return fieldMapper.selectList(Wrappers.lambdaQuery(field));
    }

    @Override
    public Page<Field> getPage(Page page, Field field) {
        if (field.getFieldName() == null) {
            return page(page);
        }
        return page(page, Wrappers.lambdaQuery(Field.class).like(Field::getFieldName, field.getFieldName()));
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Object deleteField(Long id) {
        fieldMapper.deleteRecordByFieldId(id);
        fieldMapper.deletePlanByFieldId(id);
        fieldMapper.deleteWellByFieldId(id);
        fieldMapper.deleteFieldByFieldId(id);
        return null;
    }

    @Override
    public AjaxResult getFieldByName(Page page, Field field) {
        try {
            return AjaxResult.success(
                    page(page, Wrappers.lambdaQuery(Field.class).like(Field::getFieldName, field.getFieldName()))
            );
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }
}
