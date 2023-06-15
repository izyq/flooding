package club.cupk.waterflood.service;

import club.cupk.waterflood.domain.Indicator;
import club.cupk.waterflood.domain.WaterFloodingRecord;
import club.cupk.waterflood.domain.Well;
import club.cupk.waterflood.entity.bo.WaterFloodingRecord.IndicatorBo;
import club.cupk.waterflood.entity.bo.WaterFloodingRecord.WellBo;
import club.cupk.waterflood.entity.vo.WaterFloodingRecord.IndicatorVo;
import club.cupk.waterflood.entity.vo.WaterFloodingRecord.WellVo;
import club.cupk.waterflood.util.DubboBean;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.google.common.collect.Table;
import xin.altitude.cms.common.util.BeanCopyUtils;
import xin.altitude.cms.common.util.EntityUtils;
import xin.altitude.cms.common.util.TableUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public interface IWaterFloodingRecordService extends IService<WaterFloodingRecord>    {
    WellVo getWellVo(Long wellId);
    List<WellVo> listVo(Well well);
    IPage<WellVo> pageVo(IPage<Well> page, Well well);
    IndicatorVo getIndicatorVo(Long indicatorId);
    List<IndicatorVo> listVo(Indicator indicator);
    IPage<IndicatorVo> pageVo(IPage<Indicator> page, Indicator indicator);
    Page getPage(Page page, WaterFloodingRecord waterFloodingRecord);
    List<WaterFloodingRecord> getList(WaterFloodingRecord waterFloodingRecord);
}
