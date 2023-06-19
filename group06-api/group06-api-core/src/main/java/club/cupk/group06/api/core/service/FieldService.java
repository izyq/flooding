package club.cupk.group06.api.core.service;

import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.core.domain.Field;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface FieldService extends IService<Field> {
    /**

     根据油田名称获取 Field 列表。
     @param fieldName 油田名称。
     @return Field 列表。
     */
    List<Field> getList(String fieldName);
    /**

     根据油田名称和油田地址进行分页查询 Field。
     @param page 分页对象。
     @param fieldName 油田名称。
     @param fieldAddress 油田地址。
     @return 分页结果的 Field 对象。
     */
    IPage<Field> pageField(IPage<Field> page, String fieldName, String fieldAddress);
    /**

     删除油田。
     @param id 油田ID。
     @return 操作结果的对象。
     */
    Object deleteField(Long id);
    /**

     根据油田名称进行分页查询 Field。
     @param page 分页对象。
     @param field Field 对象。
     @return 操作结果的 AjaxResult 对象。
     */
    AjaxResult getFieldByName(Page page, Field field);
}
