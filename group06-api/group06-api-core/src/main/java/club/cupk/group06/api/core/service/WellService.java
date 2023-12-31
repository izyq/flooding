package club.cupk.group06.api.core.service;


import club.cupk.group06.data.core.domain.Well;
import club.cupk.group06.data.core.vo.WellVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface WellService extends IService<Well> {
    /**
     * 通过方法调用来解决循环依赖问题
     */
    Object deleteWell(Long[] wellIds);

    Page<Well> getPage(Page page, Well well);

    List<Well> getList(Well well);

    /**
     * 查询用户实体类Vo
     */
    WellVo getOneVo(Long wellId);

    /**
     * 查询实体类Vo列表
     */
    List<WellVo> listVo(Well well);

    /**
     * 分页查询实体类Vo
     */
    IPage<WellVo> pageVo(IPage<Well> page, Well well);

    /**
     * 根据油田名，井名，单位模糊查询
     * @return
     */
    IPage<WellVo> pageWell(IPage<WellVo> page, String wellName, String wellAddress, String wellField, String wellFactory);

}
