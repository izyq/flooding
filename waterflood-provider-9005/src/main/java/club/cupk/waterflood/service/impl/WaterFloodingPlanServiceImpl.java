package club.cupk.waterflood.service.impl;
import club.cupk.waterflood.domain.WaterFloodingPlan;
import club.cupk.waterflood.domain.Well;
import club.cupk.waterflood.entity.vo.WaterFloodingPlanVo;
import club.cupk.waterflood.mapper.WaterFloodingPlanMapper;
import club.cupk.waterflood.service.IWaterFloodingPlanService;
import club.cupk.waterflood.service.IWellService;
import club.cupk.waterflood.util.DubboBean;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xin.altitude.cms.common.util.BeanCopyUtils;
import xin.altitude.cms.common.util.EntityUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;

@DubboService
@Component
public class WaterFloodingPlanServiceImpl extends ServiceImpl<WaterFloodingPlanMapper,WaterFloodingPlan> implements IWaterFloodingPlanService{
    @Autowired
    IWellService wellService;
    @Override
    public Page<WaterFloodingPlan> getPage(Page page, WaterFloodingPlan waterFloodingPlan) {
        return page(page, Wrappers.lambdaQuery(waterFloodingPlan));
    }

    @Override
    public List<WaterFloodingPlan> getList(WaterFloodingPlan waterFloodingPlan) {
        return list(Wrappers.lambdaQuery(waterFloodingPlan));
    }
    /**查询用户实体类Vo*/
    @Override
    public WaterFloodingPlanVo getOneVo(String floodingPlan) {
        WaterFloodingPlanVo waterFloodingPlanVo = EntityUtils.toObj(getById(floodingPlan), WaterFloodingPlanVo::new);
        Well well = wellService.getById(waterFloodingPlanVo.getWellId());
        BeanCopyUtils.copyProperties(well, waterFloodingPlanVo);
        return waterFloodingPlanVo;
    }
    /**查询实体类Vo列表*/
    @Override
    public List<WaterFloodingPlanVo> listVo(WaterFloodingPlan waterFloodingPlan) {
        List<WaterFloodingPlanVo> waterFloodingPlanVoList = EntityUtils.toList(list(Wrappers.lambdaQuery(waterFloodingPlan)), WaterFloodingPlanVo::new);
        Set<Long> wellIds = EntityUtils.toSet(waterFloodingPlanVoList, WaterFloodingPlanVo::getWellId);
        Map<Long, Well> map = EntityUtils.toMap(wellService.listByIds(wellIds), Well::getWellId, e -> e);
        waterFloodingPlanVoList.forEach(e -> BeanCopyUtils.copyProperties(map.get(e.getWellId()), e));
        return waterFloodingPlanVoList;
    }
    /**分页查询实体类Vo*/
    @Override
    public IPage<WaterFloodingPlanVo> pageVo(IPage<WaterFloodingPlan> page, WaterFloodingPlan waterFloodingPlan) {
        IPage<WaterFloodingPlanVo> waterFloodingPlanVoPage = EntityUtils.toPage(page(page, Wrappers.lambdaQuery(waterFloodingPlan)), WaterFloodingPlanVo::new);
        Set<Long> wellIds = EntityUtils.toSet(waterFloodingPlanVoPage.getRecords(), WaterFloodingPlanVo::getWellId);
        Map<Long, Well> map = EntityUtils.toMap(wellService.listByIds(wellIds), Well::getWellId, e -> e);
        waterFloodingPlanVoPage.getRecords().forEach(e -> BeanCopyUtils.copyProperties(map.get(e.getWellId()), e));
        return waterFloodingPlanVoPage;
    }
}
