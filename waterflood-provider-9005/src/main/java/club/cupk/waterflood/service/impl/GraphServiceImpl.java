package club.cupk.waterflood.service.impl;

import club.cupk.waterflood.common.vo.AjaxResult;
import club.cupk.waterflood.domain.Indicator;
import club.cupk.waterflood.mapper.IndicatorMapper;
import club.cupk.waterflood.service.IGraphService;
import club.cupk.waterflood.util.RedisCache;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import xin.altitude.cms.common.entity.PageEntity;

import javax.annotation.Resource;
import java.time.Year;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wangdaff
 * @date 2023-06-16 16:54
 * @description
 */
@DubboService
public class GraphServiceImpl implements IGraphService {
    @Resource
    private RedisCache redisCache;


    @Autowired
    private IndicatorMapper indicatorMapper;

    @Override
    public AjaxResult addVisualIndicator(Integer indicatorId) {
        try{
            redisCache.setCacheObject("indicator"+indicatorId,indicatorMapper.selectById(indicatorId));
            return AjaxResult.success();
        }catch (Exception e){
            return AjaxResult.error("失败");
        }
    }

    @Override
    public AjaxResult getVisualIndicator() {
        try{
            Set<String> ids = redisCache.getFuzzy("indicator");
            Set<Object> indicator=new HashSet<>();
            for (String id:ids){
                indicator.add(redisCache.getCacheObject(id));
            }
            return AjaxResult.success(indicator);
        }catch (Exception e){
            return AjaxResult.error();
        }
    }

    @Override
    public AjaxResult getGraph(Page page, Year year, String factory) {

        return null;
    }


}
