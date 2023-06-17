package club.cupk.group06.api.core.service;

import club.cupk.group06.data.core.domain.WaterFloodingPlan;
import club.cupk.group06.data.core.entity.vo.WaterFloodingPlanVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface WaterFloodingPlanService extends IService<WaterFloodingPlan> {
    WaterFloodingPlanVo getOneVo(String floodingPlan);

    List<WaterFloodingPlanVo> listVo(WaterFloodingPlan waterFloodingPlan);

    IPage<WaterFloodingPlanVo> pageVo(IPage<WaterFloodingPlan> page, WaterFloodingPlan waterFloodingPlan);

    Page<WaterFloodingPlan> getPage(Page page, WaterFloodingPlan waterFloodingPlan);

    List<WaterFloodingPlan> getList(WaterFloodingPlan waterFloodingPlan);
}
