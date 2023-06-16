package club.cupk.waterflood.service;

import club.cupk.waterflood.common.vo.AjaxResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.time.Year;

/**
 * @author wangdaff
 * @date 2023-06-16 16:54
 * @description
 */
public interface IGraphService {
    AjaxResult addVisualIndicator(Integer indicator);
    AjaxResult getVisualIndicator();
    AjaxResult getGraph(Page page, Year year, String factory);
}
