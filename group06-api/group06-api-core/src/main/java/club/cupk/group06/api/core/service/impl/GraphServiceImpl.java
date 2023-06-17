package club.cupk.group06.api.core.service.impl;

import club.cupk.group06.api.core.service.GraphService;
import club.cupk.group06.common.core.util.RedisCache;
import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.core.mapper.IndicatorMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Year;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wangdaff
 * @date 2023-06-16 16:54
 * @description
 */
@Service
@RequiredArgsConstructor
public class GraphServiceImpl implements GraphService {
    @Resource
    private RedisCache redisCache;

    private IndicatorMapper indicatorMapper;

    @Override
    public AjaxResult addVisualIndicator(Integer indicatorId) {
        try {
            redisCache.setCacheObject("indicator" + indicatorId, indicatorMapper.selectById(indicatorId));
            return AjaxResult.success();
        } catch (Exception e) {
            return AjaxResult.error("失败");
        }
    }

    @Override
    public AjaxResult getVisualIndicator() {
        try {
            Set<String> ids = redisCache.getFuzzy("indicator");
            Set<Object> indicator = new HashSet<>();
            for (String id : ids) {
                indicator.add(redisCache.getCacheObject(id));
            }
            return AjaxResult.success(indicator);
        } catch (Exception e) {
            return AjaxResult.error();
        }
    }

    @Override
    public AjaxResult getGraph(Page page, Year year, String factory) {

        return null;
    }


}
