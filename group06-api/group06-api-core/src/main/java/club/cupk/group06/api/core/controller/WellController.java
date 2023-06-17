package club.cupk.group06.api.core.controller;

import club.cupk.group06.api.core.service.IWellService;
import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.core.domain.Well;
import club.cupk.waterflood.dto.well.WellDTO;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.PageEntity;

@RestController
@RequestMapping("/asset/well")
public class WellController {
    private IWellService wellService;


    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity, String name) {
        return AjaxResult.success(wellService.getPage(pageEntity.toPage(), Well.builder().wellName(name).build()));
    }

    @GetMapping("/list")
    public AjaxResult list(Well well) {
        return AjaxResult.success(wellService.getList(well));
    }

    @PostMapping("/add")
    public AjaxResult add(@RequestBody WellDTO wellDTO) {
        return AjaxResult.success(wellService.save(Well.builder()
                .wellName(wellDTO.getName())
                .wellAddress(wellDTO.getAddress())
                .wellCoordinate(wellDTO.getCoordinate())
                .wellDepth(wellDTO.getDepth())
                .wellDia(wellDTO.getDia())
                .wellMiningStartTime(wellDTO.getStartTime())
                .wellMiningEndTime(wellDTO.getEndTime())
                .wellPeriod(wellDTO.getPeriod())
                .fieldId(wellDTO.getField())
                .factory(wellDTO.getFactory())
                .build()
        ));
    }

    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody WellDTO wellDTO) {
        return AjaxResult.success(wellService.updateById(Well.builder()
                .wellId(wellDTO.getId())
                .wellName(wellDTO.getName())
                .wellAddress(wellDTO.getAddress())
                .wellCoordinate(wellDTO.getCoordinate())
                .wellDepth(wellDTO.getDepth())
                .wellDia(wellDTO.getDia())
                .wellMiningStartTime(wellDTO.getStartTime())
                .wellMiningEndTime(wellDTO.getEndTime())
                .wellPeriod(wellDTO.getPeriod())
                .fieldId(wellDTO.getField())
                .factory(wellDTO.getFactory())
                .build()
        ));
    }

    @DeleteMapping("/delete/{id}")
    public AjaxResult delete(@PathVariable Long id) {
        try {
            Long[] ids = new Long[1];
            ids[0] = id;
            return AjaxResult.success(wellService.deleteWell(ids));
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

    @GetMapping(value = "/detail/{wellId}")
    public AjaxResult detail(@PathVariable("wellId") Long wellId) {
        return AjaxResult.success(wellService.getById(wellId));
    }

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
