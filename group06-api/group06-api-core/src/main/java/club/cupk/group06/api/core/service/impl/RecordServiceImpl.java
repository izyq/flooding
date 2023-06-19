package club.cupk.group06.api.core.service.impl;

import club.cupk.group06.api.core.service.IndicatorService;
import club.cupk.group06.api.core.service.RecordService;
import club.cupk.group06.api.core.service.WellService;
import club.cupk.group06.data.core.common.QueryTime;
import club.cupk.group06.data.core.domain.Indicator;
import club.cupk.group06.data.core.domain.Record;
import club.cupk.group06.data.core.domain.Well;
import club.cupk.group06.data.core.bo.record.IndicatorBo;
import club.cupk.group06.data.core.bo.record.WellBo;
import club.cupk.group06.data.core.vo.record.IndicatorVo;
import club.cupk.group06.data.core.vo.record.WellRecordVo;
import club.cupk.group06.data.core.mapper.RecordMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
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
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements RecordService {

    private WellService wellService;

    private IndicatorService indicatorService;

    @Override
    public Page getPage(Page page, Record record) {
        return page(page, Wrappers.lambdaQuery(record));
    }

    @Override
    public List<Record> getList(Record record) {
        return list(Wrappers.lambdaQuery(record));
    }

    @Override
    public WellRecordVo getRecordVo(Long wellId) {
        WellRecordVo wellVo = EntityUtils.toObj(wellService.getById(wellId), WellRecordVo::new);
        List<Record> records = list(Wrappers.lambdaQuery(Record.class).eq(Record::getWellId, wellId));
        Set<Long> indicatorIds = EntityUtils.toSet(records, Record::getIndicatorId);
        if (wellVo != null && indicatorIds.size() > 0) {
            LambdaQueryWrapper<Indicator> queryWrapper = Wrappers.lambdaQuery(Indicator.class).in(Indicator::getIndicatorId, indicatorIds);
            List<IndicatorBo> subBoList = EntityUtils.toList(indicatorService.list(queryWrapper), IndicatorBo::new);
            Table<Long, Long, Record> table = TableUtils.createHashTable(records, Record::getWellId, Record::getIndicatorId);
            subBoList.forEach(e -> BeanCopyUtils.copyProperties(table.get(wellId, e.getIndicatorId()), e));
            wellVo.setIndicatorBoList(subBoList);
        }
        return filterWell(wellVo);
    }

    @Override
    public List<WellRecordVo> listVo(Well well, QueryTime queryTime) {
        if (queryTime == null) {
            queryTime = new QueryTime();
        }
        List<WellRecordVo> wellVoList = EntityUtils.toList(wellService.list(
                Wrappers.lambdaQuery(Well.class)
                        .eq(well.getWellId() != null, Well::getWellId, well.getWellId())
                        .like(well.getWellName() != null, Well::getWellName, well.getWellName())
                ), WellRecordVo::new);
        Set<Long> wellIds = EntityUtils.toSet(wellVoList, Well::getWellId);
        if (wellIds.size() == 0) {
            return wellVoList;
        }
        List<Record> records = list(Wrappers.lambdaQuery(Record.class)
                .in(Record::getWellId, wellIds)
                .ge(queryTime.getStartTimeQuery() != null, Record::getRecordTime, queryTime.getStartTimeQuery())
                .le(queryTime.getEndTimeQuery() != null, Record::getRecordTime, queryTime.getEndTimeQuery())
        );
        Set<Long> indicatorIds = EntityUtils.toSet(records, Record::getIndicatorId);
        Map<Long, List<Long>> map = records.stream().collect(Collectors.groupingBy(Record::getWellId, Collectors.mapping(Record::getIndicatorId, Collectors.toList())));
        if (indicatorIds.size() == 0) {
            return wellVoList;
        }
        Table<Long, Long, Record> table = TableUtils.createHashTable(records, Record::getWellId, Record::getIndicatorId);
        LambdaQueryWrapper<Indicator> queryWrapper = Wrappers.lambdaQuery(Indicator.class).in(Indicator::getIndicatorId, indicatorIds);
        List<IndicatorBo> indicatorBoList = EntityUtils.toList(indicatorService.list(queryWrapper), IndicatorBo::new);
        for (WellRecordVo wellVo : wellVoList) {
            List<IndicatorBo> list = indicatorBoList.stream().filter(e -> map.get(wellVo.getWellId()) != null && map.get(wellVo.getWellId()).contains(e.getIndicatorId())).collect(Collectors.toList());
            list.forEach(e -> BeanCopyUtils.copyProperties(table.get(wellVo.getWellId(), e.getIndicatorId()), e));
            wellVo.setIndicatorBoList(list);
        }
        return filterWell(wellVoList);
    }

    @Override
    public List<WellRecordVo> filterWell(List<WellRecordVo> list) {
        list.forEach(wellVo -> {
            wellVo.setIndicatorBoList(wellVo.getIndicatorBoList().stream().filter(indicatorBo -> indicatorBo.getFloodingPlan() != null && !indicatorBo.getFloodingPlan().isEmpty()
                            && indicatorBo.getIndicatorType() != null && !indicatorBo.getIndicatorType().isEmpty())
                    .collect(Collectors.toList()));
        });
        return list;
    }

    @Override
    public WellRecordVo filterWell(WellRecordVo wellVo) {
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
        List<Record> records = list(Wrappers.lambdaQuery(Record.class).in(Record::getWellId, wellIds));
        Set<Long> indicatorIds = EntityUtils.toSet(records, Record::getIndicatorId);
        if (indicatorIds.size() == 0) {
            return wellVoPage;
        }
        Table<Long, Long, Record> table = TableUtils.createHashTable(records, Record::getWellId, Record::getIndicatorId);
        Map<Long, List<Long>> map = records.stream().collect(Collectors.groupingBy(Record::getWellId, Collectors.mapping(Record::getIndicatorId, Collectors.toList())));
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
        List<Record> records = list(Wrappers.lambdaQuery(Record.class).eq(Record::getIndicatorId, indicatorId));
        Set<Long> wellIds = EntityUtils.toSet(records, Record::getWellId);
        if (indicatorVo != null && wellIds.size() > 0) {
            LambdaQueryWrapper<Well> queryWrapper = Wrappers.lambdaQuery(Well.class).in(Well::getWellId, wellIds);
            List<WellBo> subBoList = EntityUtils.toList(wellService.list(queryWrapper), WellBo::new);
            Table<Long, Long, Record> table = TableUtils.createHashTable(records, Record::getIndicatorId, Record::getWellId);
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
        List<Record> records = list(Wrappers.lambdaQuery(Record.class).in(Record::getIndicatorId, indicatorIds));
        Set<Long> wellIds = EntityUtils.toSet(records, Record::getWellId);
        Map<Long, List<Long>> map = records.stream().collect(Collectors.groupingBy(Record::getIndicatorId, Collectors.mapping(Record::getWellId, Collectors.toList())));
        if (wellIds.size() == 0) {
            return indicatorVoList;
        }
        Table<Long, Long, Record> table = TableUtils.createHashTable(records, Record::getIndicatorId, Record::getWellId);
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
        List<Record> records = list(Wrappers.lambdaQuery(Record.class).in(Record::getIndicatorId, indicatorIds));
        Set<Long> wellIds = EntityUtils.toSet(records, Record::getWellId);
        if (wellIds.size() == 0) {
            return indicatorVoPage;
        }
        Table<Long, Long, Record> table = TableUtils.createHashTable(records, Record::getIndicatorId, Record::getWellId);
        Map<Long, List<Long>> map = records.stream().collect(Collectors.groupingBy(Record::getIndicatorId, Collectors.mapping(Record::getWellId, Collectors.toList())));
        List<WellBo> wellBoList = EntityUtils.toList(wellService.list(Wrappers.lambdaQuery(Well.class).in(Well::getWellId, wellIds)), WellBo::new);
        for (IndicatorVo indicatorVo : indicatorVoPage.getRecords()) {
            List<WellBo> list = wellBoList.stream().filter(e -> map.get(indicatorVo.getIndicatorId()) != null && map.get(indicatorVo.getIndicatorId()).contains(e.getWellId())).collect(Collectors.toList());
            list.forEach(e -> BeanCopyUtils.copyProperties(table.get(indicatorVo.getIndicatorId(), e.getWellId()), e));
            indicatorVo.setWellBoList(list);
        }
        return indicatorVoPage;
    }
}
