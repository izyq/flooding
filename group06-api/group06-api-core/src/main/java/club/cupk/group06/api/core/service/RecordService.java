package club.cupk.group06.api.core.service;

import club.cupk.group06.data.core.domain.Indicator;
import club.cupk.group06.data.core.domain.Record;
import club.cupk.group06.data.core.domain.Well;
import club.cupk.group06.data.core.vo.record.IndicatorVo;
import club.cupk.group06.data.core.vo.record.WellRecordVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface RecordService extends IService<Record> {
    WellRecordVo getRecordVo(Long wellId);

    List<WellRecordVo> listVo(Well well);

    List<WellRecordVo> filterWell(List<WellRecordVo> wellVoList);

    WellRecordVo filterWell(WellRecordVo wellVo);

    IPage<WellRecordVo> pageVo(IPage<Well> page, Well wellVoList);

    IndicatorVo getIndicatorVo(Long indicatorId);

    List<IndicatorVo> listVo(Indicator indicator);

    IPage<IndicatorVo> pageVo(IPage<Indicator> page, Indicator indicator);

    Page getPage(Page page, Record record);

    List<Record> getList(Record record);
}
