package club.cupk.group06.api.core.service.impl;

import club.cupk.group06.api.core.service.FieldService;
import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.core.domain.Field;
import club.cupk.group06.data.core.mapper.FieldMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FieldServiceImpl extends ServiceImpl<FieldMapper, Field> implements FieldService {

    @Resource
    private FieldMapper fieldMapper;

    @Override
    public List<Field> getList(String fieldName) {
        if (fieldName == null || fieldName.trim().length() == 0) {
            return new ArrayList<>();
        }
        return list(Wrappers.lambdaQuery(Field.class).like(fieldName.trim().length() > 0, Field::getFieldName, fieldName));
    }

    @Override
    public IPage<Field> pageField(IPage<Field> page, String fieldName, String fieldAddress) {
        return fieldMapper.pageField(page, fieldName, fieldAddress);
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
