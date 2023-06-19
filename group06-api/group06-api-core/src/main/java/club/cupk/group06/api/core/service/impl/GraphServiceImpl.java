package club.cupk.group06.api.core.service.impl;

import club.cupk.group06.api.core.service.GraphService;
import club.cupk.group06.common.core.util.RedisUtil;
import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.core.dto.graph.GraphDTO;
import club.cupk.group06.data.core.vo.GraphVo;
import club.cupk.group06.data.core.mapper.IndicatorMapper;
import club.cupk.group06.data.core.mapper.RecordMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wangdaff
 * @date 2023-06-16 16:54
 * @description
 */
@Service
@AllArgsConstructor
public class GraphServiceImpl implements GraphService {
    @Resource
    private RedisUtil redisUtil;

    @Resource
    private IndicatorMapper indicatorMapper;

    @Resource
    private RecordMapper recordMapper;

    @Override
    public AjaxResult addVisualIndicator(Integer indicatorId) {
        try {
            redisUtil.setCacheObject("indicator" + indicatorId, indicatorMapper.selectById(indicatorId));
            return AjaxResult.success();
        } catch (Exception e) {
            return AjaxResult.error("失败");
        }
    }

    @Override
    public AjaxResult getVisualIndicator() {
        try {
            Set<String> ids = redisUtil.getFuzzy("indicator");
            Set<Object> indicator = new HashSet<>();
            for (String id : ids) {
                indicator.add(redisUtil.getCacheObject(id));
            }
            return AjaxResult.success(indicator);
        } catch (Exception e) {
            return AjaxResult.error();
        }
    }

    @Override
    public AjaxResult getGraph(Page page, Long indicatorId, Long year, String factory) {

        try{
            List<GraphVo> thisYear = recordMapper.getRecordByYearAndFactory(GraphDTO.builder()
                    .current(page.getCurrent())
                    .size(page.getSize())
                    .indicatorId(indicatorId)
                    .year(year)
                    .factory(factory)
                    .build());
            List<GraphVo> beforeYear = recordMapper.getRecordByYearAndFactory(GraphDTO.builder()
                    .current(page.getCurrent())
                    .size(page.getSize())
                    .indicatorId(indicatorId)
                    .year(year-1L)
                    .factory(factory)
                    .build());
            List<List<GraphVo>> res=new ArrayList<>();
            res.add(thisYear);
            res.add(beforeYear);
            return AjaxResult.success(res);
        }catch (Exception e){
            return AjaxResult.error(e.getMessage());
        }
    }


}
