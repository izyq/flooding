package club.cupk.group06.api.core.service.impl;

import club.cupk.group06.api.core.service.PlanService;
import club.cupk.group06.api.core.service.WellService;
import club.cupk.group06.data.core.domain.Plan;
import club.cupk.group06.data.core.domain.Well;
import club.cupk.group06.data.core.entity.vo.WellVo;
import club.cupk.group06.data.core.mapper.WellMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xin.altitude.cms.common.util.EntityUtils;
import xin.altitude.cms.common.util.SpringUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WellServiceImpl extends ServiceImpl<WellMapper, Well> implements WellService {

    private WellMapper wellMapper;

    @Override
    public Page<Well> getPage(Page page, Well well) {
        if (well.getWellName() == null) {
            return page(page);
        }
        return page(page, Wrappers.lambdaQuery(Well.class).like(Well::getWellName, well.getWellName()));
    }

    @Override
    public List<Well> getList(Well well) {
        return list(Wrappers.lambdaQuery(well));
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Object deleteWell(Long[] wellIds) {
        wellMapper.deleteRecordByWellIds(wellIds);
        wellMapper.deletePlanByWellIds(wellIds);
        wellMapper.deleteWellByWellIds(wellIds);
        return null;
    }

    public PlanService getPlanService() {
        return SpringUtils.getBean(PlanService.class);
    }

    /**
     * 查询用户实体类Vo
     */
    @Override
    public WellVo getOneVo(Long wellId) {
        WellVo wellVo = EntityUtils.toObj(getById(wellId), WellVo::new);
        List<Plan> planList = getPlanService().list(Wrappers.lambdaQuery(Plan.class).eq(Plan::getWellId, wellVo.getWellId()));
        wellVo.setPlanList(planList);
        return wellVo;
    }

    /**
     * 查询实体类Vo列表
     */
    @Override
    public List<WellVo> listVo(Well well) {
        List<WellVo> wellVoList = EntityUtils.toList(list(Wrappers.lambdaQuery(well)), WellVo::new);
        Set<Long> wellIds = EntityUtils.toSet(wellVoList, WellVo::getWellId);
        List<Plan> planList = getPlanService().list(Wrappers.lambdaQuery(Plan.class).in(Plan::getWellId, wellIds));
        Map<Long, List<Plan>> map = planList.stream().collect(Collectors.groupingBy(Plan::getWellId));
        wellVoList.forEach(e -> e.setPlanList(map.get(e.getWellId())));
        return wellVoList;
    }

    /**
     * 分页查询实体类Vo
     */
    @Override
    public IPage<WellVo> pageVo(IPage<Well> page, Well well) {
        IPage<WellVo> wellVoPage = EntityUtils.toPage(page(page, Wrappers.lambdaQuery(well)), WellVo::new);
        Set<Long> wellIds = EntityUtils.toSet(wellVoPage.getRecords(), WellVo::getWellId);
        List<Plan> planList = getPlanService().list(Wrappers.lambdaQuery(Plan.class).in(Plan::getWellId, wellIds));
        Map<Long, List<Plan>> map = planList.stream().collect(Collectors.groupingBy(Plan::getWellId));
        wellVoPage.getRecords().forEach(e -> e.setPlanList(map.get(e.getWellId())));
        return wellVoPage;
    }
}
