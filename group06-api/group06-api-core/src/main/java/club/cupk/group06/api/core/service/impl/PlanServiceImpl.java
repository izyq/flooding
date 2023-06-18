package club.cupk.group06.api.core.service.impl;

import club.cupk.group06.api.core.service.PlanService;
import club.cupk.group06.api.core.service.WellService;
import club.cupk.group06.data.core.domain.Plan;
import club.cupk.group06.data.core.domain.Well;
import club.cupk.group06.data.core.entity.vo.PlanVo;
import club.cupk.group06.data.core.mapper.PlanMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import xin.altitude.cms.common.util.BeanCopyUtils;
import xin.altitude.cms.common.util.EntityUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@AllArgsConstructor
public class PlanServiceImpl extends ServiceImpl<PlanMapper, Plan> implements PlanService {

    private WellService wellService;

    @Override
    public Page<Plan> getPage(Page page, Plan plan) {
        return page(page, Wrappers.lambdaQuery(plan));
    }

    @Override
    public List<Plan> getList(Plan plan) {
        return list(Wrappers.lambdaQuery(plan));
    }

    /**
     * 查询用户实体类Vo
     */
    @Override
    public PlanVo getOneVo(String floodingPlan) {
        PlanVo PlanVo = EntityUtils.toObj(getById(floodingPlan), PlanVo::new);
        Well well = wellService.getById(PlanVo.getWellId());
        BeanCopyUtils.copyProperties(well, PlanVo);
        return PlanVo;
    }

    /**
     * 查询实体类Vo列表
     */
    @Override
    public List<PlanVo> listVo(Plan plan) {
        List<PlanVo> PlanVoList = EntityUtils.toList(list(Wrappers.lambdaQuery(plan)), PlanVo::new);
        Set<Long> wellIds = EntityUtils.toSet(PlanVoList, PlanVo::getWellId);
        Map<Long, Well> map = EntityUtils.toMap(wellService.listByIds(wellIds), Well::getWellId, e -> e);
        PlanVoList.forEach(e -> BeanCopyUtils.copyProperties(map.get(e.getWellId()), e));
        return PlanVoList;
    }

    /**
     * 分页查询实体类Vo
     */
    @Override
    public IPage<PlanVo> pageVo(IPage<Plan> page, Plan plan) {
        IPage<PlanVo> PlanVoPage = EntityUtils.toPage(page(page, Wrappers.lambdaQuery(plan)), PlanVo::new);
        Set<Long> wellIds = EntityUtils.toSet(PlanVoPage.getRecords(), PlanVo::getWellId);
        Map<Long, Well> map = EntityUtils.toMap(wellService.listByIds(wellIds), Well::getWellId, e -> e);
        PlanVoPage.getRecords().forEach(e -> BeanCopyUtils.copyProperties(map.get(e.getWellId()), e));
        return PlanVoPage;
    }
}
