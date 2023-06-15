package club.cupk.waterflood.controller;

import club.cupk.waterflood.common.vo.AjaxResult;
import club.cupk.waterflood.domain.Well;
import club.cupk.waterflood.dto.well.WellDTO;
import club.cupk.waterflood.service.IWellService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.PageEntity;
@RestController
@RequestMapping("/api/asset/well")
public class WellController{
    @DubboReference
    private IWellService wellService;


    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity,Well well){
        return AjaxResult.success(wellService.getPage(pageEntity.toPage(), well));
    }
    @GetMapping("/list")
    public AjaxResult list(Well well){
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
    @DeleteMapping("/delete/{wellIds}")
    public AjaxResult delete(@PathVariable Long[] wellIds) {
        try {
            return AjaxResult.success(wellService.deleteWell(wellIds));
        }catch (Exception e){
            return AjaxResult.error(e.getMessage());
        }
    }
    @GetMapping(value = "/detail/{wellId}")
    public AjaxResult detail(@PathVariable("wellId") Long wellId) {
        return AjaxResult.success(wellService.getById(wellId));
    }
    @GetMapping("/vo/page")
    public AjaxResult pageVo(PageEntity pageEntity,Well well){
        return AjaxResult.success(wellService.pageVo(pageEntity.toPage(), well));
    }
    /**
     * 井的所有注水计划
     * @author izyq
     * @param well
     * @return club.cupk.waterflood.common.vo.AjaxResult
     **/
    @GetMapping("/vo/list")
    public AjaxResult listVo(Well well){
        return AjaxResult.success(wellService.listVo(well));
    }
    @GetMapping(value = "/vo/detail/{wellId}")
    public AjaxResult detailVo(@PathVariable("wellId") Long wellId) {
        return AjaxResult.success(wellService.getOneVo(wellId));
    }
}
