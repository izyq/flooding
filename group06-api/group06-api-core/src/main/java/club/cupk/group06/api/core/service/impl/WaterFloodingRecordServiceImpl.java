package club.cupk.group06.api.core.service.impl;

import club.cupk.group06.api.core.service.IndicatorService;
import club.cupk.group06.api.core.service.WaterFloodingRecordService;
import club.cupk.group06.api.core.service.WellService;
import club.cupk.group06.data.core.domain.Indicator;
import club.cupk.group06.data.core.domain.WaterFloodingRecord;
import club.cupk.group06.data.core.domain.Well;
import club.cupk.group06.data.core.entity.bo.WaterFloodingRecord.IndicatorBo;
import club.cupk.group06.data.core.entity.bo.WaterFloodingRecord.WellBo;
import club.cupk.group06.data.core.entity.vo.WaterFloodingRecord.IndicatorVo;
import club.cupk.group06.data.core.entity.vo.WaterFloodingRecord.WellRecordVo;
import club.cupk.group06.data.core.mapper.WaterFloodingRecordMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Table;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import xin.altitude.cms.common.util.BeanCopyUtils;
import xin.altitude.cms.common.util.EntityUtils;
import xin.altitude.cms.common.util.TableUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WaterFloodingRecordServiceImpl extends ServiceImpl<WaterFloodingRecordMapper, WaterFloodingRecord> implements WaterFloodingRecordService {

    private WellService wellService;

    private IndicatorService indicatorService;

    @Override
    public Page getPage(Page page, WaterFloodingRecord waterFloodingRecord) {
        return page(page, Wrappers.lambdaQuery(waterFloodingRecord));
    }

    @Override
    public List<WaterFloodingRecord> getList(WaterFloodingRecord waterFloodingRecord) {
        return list(Wrappers.lambdaQuery(waterFloodingRecord));
    }

    @Override
    public WellRecordVo getWellVo(Long wellId) {
        WellRecordVo wellVo = EntityUtils.toObj(wellService.getById(wellId), WellRecordVo::new);
        List<WaterFloodingRecord> waterFloodingRecords = list(Wrappers.lambdaQuery(WaterFloodingRecord.class).eq(WaterFloodingRecord::getWellId, wellId));
        Set<Long> indicatorIds = EntityUtils.toSet(waterFloodingRecords, WaterFloodingRecord::getIndicatorId);
        if (wellVo != null && indicatorIds.size() > 0) {
            LambdaQueryWrapper<Indicator> queryWrapper = Wrappers.lambdaQuery(Indicator.class).in(Indicator::getIndicatorId, indicatorIds);
            List<IndicatorBo> subBoList = EntityUtils.toList(indicatorService.list(queryWrapper), IndicatorBo::new);
            Table<Long, Long, WaterFloodingRecord> table = TableUtils.createHashTable(waterFloodingRecords, WaterFloodingRecord::getWellId, WaterFloodingRecord::getIndicatorId);
            subBoList.forEach(e -> BeanCopyUtils.copyProperties(table.get(wellId, e.getIndicatorId()), e));
            wellVo.setIndicatorBoList(subBoList);
        }
        return fillterWell(wellVo);
    }

    @Override
    public List<WellRecordVo> listVo(Well well) {
        List<WellRecordVo> wellVoList = EntityUtils.toList(wellService.list(Wrappers.lambdaQuery(well)), WellRecordVo::new);
        Set<Long> wellIds = EntityUtils.toSet(wellVoList, Well::getWellId);
        if (wellIds.size() == 0) {
            return wellVoList;
        }
        List<WaterFloodingRecord> waterFloodingRecords = list(Wrappers.lambdaQuery(WaterFloodingRecord.class).in(WaterFloodingRecord::getWellId, wellIds));
        Set<Long> indicatorIds = EntityUtils.toSet(waterFloodingRecords, WaterFloodingRecord::getIndicatorId);
        Map<Long, List<Long>> map = waterFloodingRecords.stream().collect(Collectors.groupingBy(WaterFloodingRecord::getWellId, Collectors.mapping(WaterFloodingRecord::getIndicatorId, Collectors.toList())));
        if (indicatorIds.size() == 0) {
            return wellVoList;
        }
        Table<Long, Long, WaterFloodingRecord> table = TableUtils.createHashTable(waterFloodingRecords, WaterFloodingRecord::getWellId, WaterFloodingRecord::getIndicatorId);
        LambdaQueryWrapper<Indicator> queryWrapper = Wrappers.lambdaQuery(Indicator.class).in(Indicator::getIndicatorId, indicatorIds);
        List<IndicatorBo> indicatorBoList = EntityUtils.toList(indicatorService.list(queryWrapper), IndicatorBo::new);
        for (WellRecordVo wellVo : wellVoList) {
            List<IndicatorBo> list = indicatorBoList.stream().filter(e -> map.get(wellVo.getWellId()) != null && map.get(wellVo.getWellId()).contains(e.getIndicatorId())).collect(Collectors.toList());
            list.forEach(e -> BeanCopyUtils.copyProperties(table.get(wellVo.getWellId(), e.getIndicatorId()), e));
            wellVo.setIndicatorBoList(list);
        }
        return fillterWell(wellVoList);
    }

    @Override
    public List<WellRecordVo> fillterWell(List<WellRecordVo> list) {
        list.forEach(wellVo -> {
            wellVo.setIndicatorBoList(wellVo.getIndicatorBoList().stream().filter(indicatorBo -> indicatorBo.getFloodingPlan() != null && !indicatorBo.getFloodingPlan().isEmpty()
                            && indicatorBo.getIndicatorType() != null && !indicatorBo.getIndicatorType().isEmpty())
                    .collect(Collectors.toList()));
        });
        return list;
    }

    @Override
    public WellRecordVo fillterWell(WellRecordVo wellVo) {
        wellVo.setIndicatorBoList(wellVo.getIndicatorBoList().stream().filter(indicatorBo -> indicatorBo.getFloodingPlan() != null && !indicatorBo.getFloodingPlan().isEmpty()
                        && indicatorBo.getIndicatorType() != null && !indicatorBo.getIndicatorType().isEmpty())
                .collect(Collectors.toList()));
        return wellVo;
    }

    @Override
    public IPage<WellRecordVo> pageVo(IPage<Well> page, Well well) {
        IPage<WellRecordVo> wellVoPage = EntityUtils.toPage(wellService.page(page, Wrappers.lambdaQuery(well)), WellRecordVo::new);
        Set<Long> wellIds = EntityUtils.toSet(wellVoPage.getRecords(), Well::getWellId);
        if (wellIds.size() == 0) {
            return wellVoPage;
        }
        List<WaterFloodingRecord> waterFloodingRecords = list(Wrappers.lambdaQuery(WaterFloodingRecord.class).in(WaterFloodingRecord::getWellId, wellIds));
        Set<Long> indicatorIds = EntityUtils.toSet(waterFloodingRecords, WaterFloodingRecord::getIndicatorId);
        if (indicatorIds.size() == 0) {
            return wellVoPage;
        }
        Table<Long, Long, WaterFloodingRecord> table = TableUtils.createHashTable(waterFloodingRecords, WaterFloodingRecord::getWellId, WaterFloodingRecord::getIndicatorId);
        Map<Long, List<Long>> map = waterFloodingRecords.stream().collect(Collectors.groupingBy(WaterFloodingRecord::getWellId, Collectors.mapping(WaterFloodingRecord::getIndicatorId, Collectors.toList())));
        List<IndicatorBo> indicatorBoList = EntityUtils.toList(indicatorService.list(Wrappers.lambdaQuery(Indicator.class).in(Indicator::getIndicatorId, indicatorIds)), IndicatorBo::new);
        for (WellRecordVo wellVo : wellVoPage.getRecords()) {
            List<IndicatorBo> list = indicatorBoList.stream().filter(e -> map.get(wellVo.getWellId()) != null && map.get(wellVo.getWellId()).contains(e.getIndicatorId())).collect(Collectors.toList());
            list.forEach(e -> BeanCopyUtils.copyProperties(table.get(wellVo.getWellId(), e.getIndicatorId()), e));
            wellVo.setIndicatorBoList(list);
        }
        return wellVoPage;
    }

    @Override
    public IndicatorVo getIndicatorVo(Long indicatorId) {
        IndicatorVo indicatorVo = EntityUtils.toObj(indicatorService.getById(indicatorId), IndicatorVo::new);
        List<WaterFloodingRecord> waterFloodingRecords = list(Wrappers.lambdaQuery(WaterFloodingRecord.class).eq(WaterFloodingRecord::getIndicatorId, indicatorId));
        Set<Long> wellIds = EntityUtils.toSet(waterFloodingRecords, WaterFloodingRecord::getWellId);
        if (indicatorVo != null && wellIds.size() > 0) {
            LambdaQueryWrapper<Well> queryWrapper = Wrappers.lambdaQuery(Well.class).in(Well::getWellId, wellIds);
            List<WellBo> subBoList = EntityUtils.toList(wellService.list(queryWrapper), WellBo::new);
            Table<Long, Long, WaterFloodingRecord> table = TableUtils.createHashTable(waterFloodingRecords, WaterFloodingRecord::getIndicatorId, WaterFloodingRecord::getWellId);
            subBoList.forEach(e -> BeanCopyUtils.copyProperties(table.get(indicatorId, e.getWellId()), e));
            indicatorVo.setWellBoList(subBoList);
        }
        return indicatorVo;
    }

    @Override
    public List<IndicatorVo> listVo(Indicator indicator) {
        List<IndicatorVo> indicatorVoList = EntityUtils.toList(indicatorService.list(Wrappers.lambdaQuery(indicator)), IndicatorVo::new);
        Set<Long> indicatorIds = EntityUtils.toSet(indicatorVoList, Indicator::getIndicatorId);
        if (indicatorIds.size() == 0) {
            return indicatorVoList;
        }
        List<WaterFloodingRecord> waterFloodingRecords = list(Wrappers.lambdaQuery(WaterFloodingRecord.class).in(WaterFloodingRecord::getIndicatorId, indicatorIds));
        Set<Long> wellIds = EntityUtils.toSet(waterFloodingRecords, WaterFloodingRecord::getWellId);
        Map<Long, List<Long>> map = waterFloodingRecords.stream().collect(Collectors.groupingBy(WaterFloodingRecord::getIndicatorId, Collectors.mapping(WaterFloodingRecord::getWellId, Collectors.toList())));
        if (wellIds.size() == 0) {
            return indicatorVoList;
        }
        Table<Long, Long, WaterFloodingRecord> table = TableUtils.createHashTable(waterFloodingRecords, WaterFloodingRecord::getIndicatorId, WaterFloodingRecord::getWellId);
        LambdaQueryWrapper<Well> queryWrapper = Wrappers.lambdaQuery(Well.class).in(Well::getWellId, wellIds);
        List<WellBo> wellBoList = EntityUtils.toList(wellService.list(queryWrapper), WellBo::new);
        for (IndicatorVo indicatorVo : indicatorVoList) {
            List<WellBo> list = wellBoList.stream().filter(e -> map.get(indicatorVo.getIndicatorId()) != null && map.get(indicatorVo.getIndicatorId()).contains(e.getWellId())).collect(Collectors.toList());
            list.forEach(e -> BeanCopyUtils.copyProperties(table.get(indicatorVo.getIndicatorId(), e.getWellId()), e));
            indicatorVo.setWellBoList(list);
        }
        return indicatorVoList;
    }

    @Override
    public IPage<IndicatorVo> pageVo(IPage<Indicator> page, Indicator indicator) {
        IPage<IndicatorVo> indicatorVoPage = EntityUtils.toPage(indicatorService.page(page, Wrappers.lambdaQuery(indicator)), IndicatorVo::new);
        Set<Long> indicatorIds = EntityUtils.toSet(indicatorVoPage.getRecords(), Indicator::getIndicatorId);
        if (indicatorIds.size() == 0) {
            return indicatorVoPage;
        }
        List<WaterFloodingRecord> waterFloodingRecords = list(Wrappers.lambdaQuery(WaterFloodingRecord.class).in(WaterFloodingRecord::getIndicatorId, indicatorIds));
        Set<Long> wellIds = EntityUtils.toSet(waterFloodingRecords, WaterFloodingRecord::getWellId);
        if (wellIds.size() == 0) {
            return indicatorVoPage;
        }
        Table<Long, Long, WaterFloodingRecord> table = TableUtils.createHashTable(waterFloodingRecords, WaterFloodingRecord::getIndicatorId, WaterFloodingRecord::getWellId);
        Map<Long, List<Long>> map = waterFloodingRecords.stream().collect(Collectors.groupingBy(WaterFloodingRecord::getIndicatorId, Collectors.mapping(WaterFloodingRecord::getWellId, Collectors.toList())));
        List<WellBo> wellBoList = EntityUtils.toList(wellService.list(Wrappers.lambdaQuery(Well.class).in(Well::getWellId, wellIds)), WellBo::new);
        for (IndicatorVo indicatorVo : indicatorVoPage.getRecords()) {
            List<WellBo> list = wellBoList.stream().filter(e -> map.get(indicatorVo.getIndicatorId()) != null && map.get(indicatorVo.getIndicatorId()).contains(e.getWellId())).collect(Collectors.toList());
            list.forEach(e -> BeanCopyUtils.copyProperties(table.get(indicatorVo.getIndicatorId(), e.getWellId()), e));
            indicatorVo.setWellBoList(list);
        }
        return indicatorVoPage;
    }
}
