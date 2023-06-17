package club.cupk.group06.api.core.service;
import club.cupk.group06.common.web.vo.AjaxResult;
import club.cupk.waterflood.domain.Field;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IFieldService extends IService<Field>{
    List<Field> getList(Field field);

    Page<Field> getPage(Page page, Field field);

    Object deleteField (Long id);

    AjaxResult getFieldByName(Page page, Field field);
}
