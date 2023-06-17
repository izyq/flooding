package club.cupk.group06.api.core.service;

import club.cupk.group06.common.web.vo.AjaxResult;
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
