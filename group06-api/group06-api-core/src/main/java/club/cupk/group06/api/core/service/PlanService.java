package club.cupk.group06.api.core.service;

import club.cupk.group06.data.core.domain.Plan;
import club.cupk.group06.data.core.vo.PlanVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface PlanService extends IService<Plan> {
    /**

     获取指定水浸计划的详细信息。
     @param floodingPlan 水浸计划。
     @return 计划的 PlanVo 对象。
     */
    PlanVo getOneVo(String floodingPlan);
    /**

     根据条件查询计划列表。
     @param plan 查询条件。
     @return 计划的 PlanVo 列表。
     */
    List<PlanVo> listVo(Plan plan);
    /**

     根据分页信息和条件查询计划列表。
     @param page 分页信息。
     @param plan 查询条件。
     @return 分页的计划结果。
     */
    IPage<PlanVo> pageVo(IPage<Plan> page, Plan plan);
    /**

     根据分页信息和条件查询计划列表。
     @param page 分页信息。
     @param plan 查询条件。
     @return 分页的计划结果。
     */
    Page<Plan> getPage(Page page, Plan plan);
    /**

     根据条件查询计划列表。
     @param plan 查询条件。
     @return 计划列表。
     */
    List<Plan> getList(Plan plan);
}
