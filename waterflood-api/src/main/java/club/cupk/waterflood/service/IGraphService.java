package club.cupk.waterflood.service;

import club.cupk.waterflood.common.vo.AjaxResult;

/**
 * @author wangdaff
 * @date 2023-06-16 16:54
 * @description
 */
public interface IGraphService {
    AjaxResult addVisualIndicator(Integer indicator);
    AjaxResult getVisualIndicator();
}
