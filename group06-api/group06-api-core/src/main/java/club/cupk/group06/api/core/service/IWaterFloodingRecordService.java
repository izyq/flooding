package club.cupk.group06.api.core.service;

import club.cupk.waterflood.domain.Indicator;
import club.cupk.waterflood.domain.WaterFloodingRecord;
import club.cupk.waterflood.domain.Well;
import club.cupk.waterflood.entity.vo.WaterFloodingRecord.IndicatorVo;
import club.cupk.waterflood.entity.vo.WaterFloodingRecord.WellVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IWaterFloodingRecordService extends IService<WaterFloodingRecord>    {
    WellVo getWellVo(Long wellId);
    List<WellVo> listVo(Well well);
    List<WellVo> fillterWell(List<WellVo> wellVoList);

    WellVo fillterWell(WellVo wellVo);

    IPage<WellVo> pageVo(IPage<Well> page, Well wellVoList);
    IndicatorVo getIndicatorVo(Long indicatorId);
    List<IndicatorVo> listVo(Indicator indicator);
    IPage<IndicatorVo> pageVo(IPage<Indicator> page, Indicator indicator);
    Page getPage(Page page, WaterFloodingRecord waterFloodingRecord);
    List<WaterFloodingRecord> getList(WaterFloodingRecord waterFloodingRecord);
}
