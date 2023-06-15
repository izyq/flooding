package club.cupk.waterflood.service.impl;

import club.cupk.waterflood.domain.WaterFloodingPlan;
import club.cupk.waterflood.domain.Well;
import club.cupk.waterflood.entity.vo.WellVo;
import club.cupk.waterflood.mapper.WellMapper;
import club.cupk.waterflood.service.IWaterFloodingPlanService;
import club.cupk.waterflood.service.IWellService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import xin.altitude.cms.common.util.EntityUtils;
import xin.altitude.cms.common.util.SpringUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@DubboService
@Component
public class WellServiceImpl extends ServiceImpl<WellMapper,Well> implements IWellService{

    @Override
    public Page<Well> getPage(Page page, Well well) {
        return page(page,Wrappers.lambdaQuery(well));
    }

    @Override
    public List<Well> getList(Well well) {
        return list(Wrappers.lambdaQuery(well));
    }
    @Autowired
    WellMapper wellMapper;
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Object deleteWell(Long[] wellIds){
        wellMapper.deleteRecordByWellIds(wellIds);
        wellMapper.deletePlanByWellIds(wellIds);
        wellMapper.deleteWellByWellIds(wellIds);
        return null;
    }

    public IWaterFloodingPlanService getWaterFloodingPlanService() {
        return SpringUtils.getBean(IWaterFloodingPlanService.class);
    }
    @Override
    /**查询用户实体类Vo*/    public WellVo getOneVo(Long wellId) {
        WellVo wellVo = EntityUtils.toObj(getById(wellId), WellVo::new);
        List<WaterFloodingPlan> waterFloodingPlanList = getWaterFloodingPlanService().list(Wrappers.lambdaQuery(WaterFloodingPlan.class).eq(WaterFloodingPlan::getWellId, wellVo.getWellId()));
        wellVo.setWaterFloodingPlanList(waterFloodingPlanList);
        return wellVo;
    }
    @Override
    /**查询实体类Vo列表*/    public List<WellVo> listVo(Well well) {
        List<WellVo> wellVoList = EntityUtils.toList(list(Wrappers.lambdaQuery(well)), WellVo::new);
        Set<Long> wellIds = EntityUtils.toSet(wellVoList, WellVo::getWellId);
        List<WaterFloodingPlan> waterFloodingPlanList = getWaterFloodingPlanService().list(Wrappers.lambdaQuery(WaterFloodingPlan.class).in(WaterFloodingPlan::getWellId, wellIds));
        Map<Long, List<WaterFloodingPlan>> map = waterFloodingPlanList.stream().collect(Collectors.groupingBy(WaterFloodingPlan::getWellId));
        wellVoList.forEach(e -> e.setWaterFloodingPlanList(map.get(e.getWellId())));
        return wellVoList;
    }
    @Override
    /**分页查询实体类Vo*/    public IPage<WellVo> pageVo(IPage<Well> page, Well well) {
        IPage<WellVo> wellVoPage = EntityUtils.toPage(page(page, Wrappers.lambdaQuery(well)), WellVo::new);
        Set<Long> wellIds = EntityUtils.toSet(wellVoPage.getRecords(), WellVo::getWellId);
        List<WaterFloodingPlan> waterFloodingPlanList = getWaterFloodingPlanService().list(Wrappers.lambdaQuery(WaterFloodingPlan.class).in(WaterFloodingPlan::getWellId, wellIds));
        Map<Long, List<WaterFloodingPlan>> map = waterFloodingPlanList.stream().collect(Collectors.groupingBy(WaterFloodingPlan::getWellId));
        wellVoPage.getRecords().forEach(e -> e.setWaterFloodingPlanList(map.get(e.getWellId())));
        return wellVoPage;
    }
}
