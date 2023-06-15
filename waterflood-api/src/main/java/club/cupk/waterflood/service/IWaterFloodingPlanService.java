package club.cupk.waterflood.service;

import club.cupk.waterflood.domain.WaterFloodingPlan;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IWaterFloodingPlanService extends IService<WaterFloodingPlan>{
//    IWellService wellService = DubboBean.getDubboBean(IWellService.class);
//    /**查询用户实体类Vo*/    default WaterFloodingPlanVo getOneVo(String floodingPlan) {
//        WaterFloodingPlanVo waterFloodingPlanVo = EntityUtils.toObj(getById(floodingPlan), WaterFloodingPlanVo::new);
//        Well well = wellService.getById(waterFloodingPlanVo.getWellId());
//        BeanCopyUtils.copyProperties(well, waterFloodingPlanVo);
//        return waterFloodingPlanVo;
//    }
//    /**查询实体类Vo列表*/    default List<WaterFloodingPlanVo> listVo(WaterFloodingPlan waterFloodingPlan) {
//        List<WaterFloodingPlanVo> waterFloodingPlanVoList = EntityUtils.toList(list(Wrappers.lambdaQuery(waterFloodingPlan)), WaterFloodingPlanVo::new);
//        Set<Long> wellIds = EntityUtils.toSet(waterFloodingPlanVoList, WaterFloodingPlanVo::getWellId);
//        Map<Long, Well> map = EntityUtils.toMap(wellService.listByIds(wellIds), Well::getWellId, e -> e);
//        waterFloodingPlanVoList.forEach(e -> BeanCopyUtils.copyProperties(map.get(e.getWellId()), e));
//        return waterFloodingPlanVoList;
//    }
//    /**分页查询实体类Vo*/    default IPage<WaterFloodingPlanVo> pageVo(IPage<WaterFloodingPlan> page, WaterFloodingPlan waterFloodingPlan) {
//        IPage<WaterFloodingPlanVo> waterFloodingPlanVoPage = EntityUtils.toPage(page(page, Wrappers.lambdaQuery(waterFloodingPlan)), WaterFloodingPlanVo::new);
//        Set<Long> wellIds = EntityUtils.toSet(waterFloodingPlanVoPage.getRecords(), WaterFloodingPlanVo::getWellId);
//        Map<Long, Well> map = EntityUtils.toMap(wellService.listByIds(wellIds), Well::getWellId, e -> e);
//        waterFloodingPlanVoPage.getRecords().forEach(e -> BeanCopyUtils.copyProperties(map.get(e.getWellId()), e));
//        return waterFloodingPlanVoPage;
//    }
    Page<WaterFloodingPlan> getPage(Page page, WaterFloodingPlan waterFloodingPlan);
    List<WaterFloodingPlan> getList(WaterFloodingPlan waterFloodingPlan);
}
