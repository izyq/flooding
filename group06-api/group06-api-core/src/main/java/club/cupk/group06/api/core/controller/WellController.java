package club.cupk.group06.api.core.controller;

import club.cupk.group06.api.core.service.WellService;
import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.core.domain.Well;
import club.cupk.group06.data.core.dto.well.WellDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.PageEntity;

import javax.annotation.Resource;

@RestController
@RequestMapping("/asset/well")
@AllArgsConstructor
@Slf4j
public class WellController {

    @Resource
    private WellService wellService;

    /**

     分页查询井页面。
     @param pageEntity 分页参数实体。
     @param wellName 井名称。
     @param wellAddress 井地址。
     @param wellField 井所属油田。
     @param wellFactory 井所属工厂。
     @return 包含井页面分页结果的 AjaxResult 对象。
     */
    @GetMapping("/page")
    public AjaxResult page(@NotNull PageEntity pageEntity, String wellName, String wellAddress, String wellField,
                           String wellFactory) {
        return AjaxResult.success(wellService.pageWell(pageEntity.toPage(),
                wellName, wellAddress, wellField, wellFactory));
    }
    /**

     获取井列表。
     @param well 井对象。
     @return 包含井列表的 AjaxResult 对象。
     */
    @GetMapping("/list")
    public AjaxResult list(Well well) {
        return AjaxResult.success(wellService.getList(well));
    }
    /**

     添加井。
     @param wellDTO 井的数据传输对象。
     @return 包含添加结果的 AjaxResult 对象。
     */
    @PostMapping("/add")
    public AjaxResult add(@RequestBody WellDTO wellDTO) {
        log.info("添加注水井-------------------------------");
        return AjaxResult.success(wellService.save(Well.builder()
                .wellName(wellDTO.getName())
                .wellAddress(wellDTO.getAddress())
                .wellCoordinate(wellDTO.getCoordinate())
                .wellDepth(wellDTO.getDepth())
                .wellDia(wellDTO.getDia())
                .startTime(wellDTO.getStartTime())
                .endTime(wellDTO.getEndTime())
                .wellPeriod(wellDTO.getPeriod())
                .fieldId(wellDTO.getField())
                .wellFactory(wellDTO.getFactory())
                .build()));
    }
    /**

     编辑井。
     @param wellDTO 井的数据传输对象。
     @return 包含编辑结果的 AjaxResult 对象。
     */
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody WellDTO wellDTO) {
        log.info("修改注水井-------------------------------");
        return AjaxResult.success(wellService.updateById(Well.builder()
                .wellId(wellDTO.getId())
                .wellName(wellDTO.getName())
                .wellAddress(wellDTO.getAddress())
                .wellCoordinate(wellDTO.getCoordinate())
                .wellDepth(wellDTO.getDepth())
                .wellDia(wellDTO.getDia())
                .startTime(wellDTO.getStartTime())
                .endTime(wellDTO.getEndTime())
                .wellPeriod(wellDTO.getPeriod())
                .fieldId(wellDTO.getField())
                .wellFactory(wellDTO.getFactory())
                .build()));
    }
    /**

     删除井。
     @param id 井ID。
     @return 包含删除结果的 AjaxResult 对象。
     */
    @DeleteMapping("/delete/{id}")
    public AjaxResult delete(@PathVariable Long id) {
        log.warn("删除注水井-------------------------------");
        Long[] ids = new Long[1];
        ids[0] = id;
        return AjaxResult.success(wellService.deleteWell(ids));
    }
    /**

     获取井详情。
     @param wellId 井ID。
     @return 包含井详情的 AjaxResult 对象。
     */
    @GetMapping(value = "/detail/{wellId}")
    public AjaxResult detail(@PathVariable("wellId") Long wellId) {
        return AjaxResult.success(wellService.getById(wellId));
    }
    /**

     分页查询井视图。
     @param pageEntity 分页参数实体。
     @param well 井对象。
     @return 包含井视图分页结果的 AjaxResult 对象。
     */
    @GetMapping("/vo/page")
    public AjaxResult pageVo(PageEntity pageEntity, Well well) {
        return AjaxResult.success(wellService.pageVo(pageEntity.toPage(), well));
    }

    /**
     * 井的所有注水计划
     *
     * @param well
     * @return club.cupk.group06.common.web.vo.AjaxResult
     * @author izyq
     **/
    @GetMapping("/vo/list")
    public AjaxResult listVo(Well well) {
        return AjaxResult.success(wellService.listVo(well));
    }

    @GetMapping(value = "/vo/detail/{wellId}")
    public AjaxResult detailVo(@PathVariable("wellId") Long wellId) {
        return AjaxResult.success(wellService.getOneVo(wellId));
    }
}
