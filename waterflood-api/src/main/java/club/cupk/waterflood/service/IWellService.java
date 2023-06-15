package club.cupk.waterflood.service;


import club.cupk.waterflood.domain.WaterFloodingPlan;
import club.cupk.waterflood.domain.Well;
import club.cupk.waterflood.entity.vo.WellVo;
import club.cupk.waterflood.util.DubboBean;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import xin.altitude.cms.common.util.EntityUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public interface IWellService extends IService<Well>{
    /** 通过方法调用来解决循环依赖问题 */
    default IWaterFloodingPlanService getWaterFloodingPlanService() {
        return DubboBean.getDubboBean(IWaterFloodingPlanService.class);
    }
    /**查询用户实体类Vo*/    default WellVo getOneVo(Long wellId) {
        WellVo wellVo = EntityUtils.toObj(getById(wellId), WellVo::new);
        List<WaterFloodingPlan> waterFloodingPlanList = getWaterFloodingPlanService().list(Wrappers.lambdaQuery(WaterFloodingPlan.class).eq(WaterFloodingPlan::getWellId, wellVo.getWellId()));
        wellVo.setWaterFloodingPlanList(waterFloodingPlanList);
        return wellVo;
    }
    /**查询实体类Vo列表*/    default List<WellVo> listVo(Well well) {
        List<WellVo> wellVoList = EntityUtils.toList(list(Wrappers.lambdaQuery(well)), WellVo::new);
        Set<Long> wellIds = EntityUtils.toSet(wellVoList, WellVo::getWellId);
        List<WaterFloodingPlan> waterFloodingPlanList = getWaterFloodingPlanService().list(Wrappers.lambdaQuery(WaterFloodingPlan.class).in(WaterFloodingPlan::getWellId, wellIds));
        Map<Long, List<WaterFloodingPlan>> map = waterFloodingPlanList.stream().collect(Collectors.groupingBy(WaterFloodingPlan::getWellId));
        wellVoList.forEach(e -> e.setWaterFloodingPlanList(map.get(e.getWellId())));
        return wellVoList;
    }
    /**分页查询实体类Vo*/    default IPage<WellVo> pageVo(IPage<Well> page, Well well) {
        IPage<WellVo> wellVoPage = EntityUtils.toPage(page(page, Wrappers.lambdaQuery(well)), WellVo::new);
        Set<Long> wellIds = EntityUtils.toSet(wellVoPage.getRecords(), WellVo::getWellId);
        List<WaterFloodingPlan> waterFloodingPlanList = getWaterFloodingPlanService().list(Wrappers.lambdaQuery(WaterFloodingPlan.class).in(WaterFloodingPlan::getWellId, wellIds));
        Map<Long, List<WaterFloodingPlan>> map = waterFloodingPlanList.stream().collect(Collectors.groupingBy(WaterFloodingPlan::getWellId));
        wellVoPage.getRecords().forEach(e -> e.setWaterFloodingPlanList(map.get(e.getWellId())));
        return wellVoPage;
    }

    Object deleteWell(Long[] wellIds);

    Page<Well> getPage(Page page, Well well);
    List<Well> getList(Well well);
}
