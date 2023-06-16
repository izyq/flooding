package club.cupk.waterflood.service;
import club.cupk.waterflood.common.vo.AjaxResult;
import club.cupk.waterflood.domain.Field;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import reactor.core.Exceptions;

import java.util.List;

public interface IFieldService extends IService<Field>{
    List<Field> getList(Field field);

    Page<Field> getPage(Page page, Field field);

    Object deleteField (Long id);

    AjaxResult getFieldByName(Page page, Field field);
}
