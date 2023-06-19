package club.cupk.group06.api.core.service;

import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.core.domain.Field;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface FieldService extends IService<Field> {
    List<Field> getList(Field field);

    IPage<Field> pageField(IPage<Field> page, String fieldName, String fieldAddress);

    Object deleteField(Long id);

    AjaxResult getFieldByName(Page page, Field field);
}
