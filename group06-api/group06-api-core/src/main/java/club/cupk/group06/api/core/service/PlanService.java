package club.cupk.group06.api.core.service;

import club.cupk.group06.data.core.domain.Plan;
import club.cupk.group06.data.core.vo.PlanVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface PlanService extends IService<Plan> {
    PlanVo getOneVo(String floodingPlan);

    List<PlanVo> listVo(Plan plan);

    IPage<PlanVo> pageVo(IPage<Plan> page, Plan plan);

    Page<Plan> getPage(Page page, Plan plan);

    List<Plan> getList(Plan plan);
}
