package club.cupk.group06.api.core.service;

import club.cupk.group06.data.core.domain.Indicator;
import club.cupk.group06.data.core.domain.WaterFloodingRecord;
import club.cupk.group06.data.core.domain.Well;
import club.cupk.group06.data.core.entity.vo.WaterFloodingRecord.IndicatorVo;
import club.cupk.group06.data.core.entity.vo.WaterFloodingRecord.WellRecordVo;
import club.cupk.group06.data.core.entity.vo.WellVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface WaterFloodingRecordService extends IService<WaterFloodingRecord> {
    WellRecordVo getWellVo(Long wellId);

    List<WellRecordVo> listVo(Well well);

    List<WellRecordVo> fillterWell(List<WellRecordVo> wellVoList);

    WellRecordVo fillterWell(WellRecordVo wellVo);

    IPage<WellRecordVo> pageVo(IPage<Well> page, Well wellVoList);

    IndicatorVo getIndicatorVo(Long indicatorId);

    List<IndicatorVo> listVo(Indicator indicator);

    IPage<IndicatorVo> pageVo(IPage<Indicator> page, Indicator indicator);

    Page getPage(Page page, WaterFloodingRecord waterFloodingRecord);

    List<WaterFloodingRecord> getList(WaterFloodingRecord waterFloodingRecord);
}
