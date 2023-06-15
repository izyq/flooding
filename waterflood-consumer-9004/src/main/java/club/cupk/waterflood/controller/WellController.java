package club.cupk.waterflood.controller;

import club.cupk.waterflood.domain.Well;
import club.cupk.waterflood.dto.well.WellDTO;
import club.cupk.waterflood.service.IWellService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.AjaxResult;
import xin.altitude.cms.common.entity.PageEntity;
@RestController
@RequestMapping("/api/asset/well")
public class WellController{
    @DubboReference
    private IWellService wellService;


    @GetMapping("/page")
    public Object page(PageEntity pageEntity,Well well){
        return wellService.getPage(pageEntity.toPage(), well);
    }
    @GetMapping("/list")
    public Object list(Well well){
        return wellService.getList(well);
    }
    @PostMapping("/add")
    public Object add(@RequestBody WellDTO wellDTO) {
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
    public Object edit(@RequestBody WellDTO wellDTO) {
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
        Object result = null;
        try {
            result = wellService.deleteWell(wellIds);
        }catch (Exception e){
            result = e.getMessage();
        }
        return AjaxResult.success(result);
    }
    @GetMapping(value = "/detail/{wellId}")
    public AjaxResult detail(@PathVariable("wellId") Long wellId) {
        return AjaxResult.success(wellService.getById(wellId));
    }
//    @GetMapping("/vo/page")
//    public AjaxResult pageVo(PageEntity pageEntity,Well well){
//        return AjaxResult.success(wellService.pageVo(pageEntity.toPage(), well));
//    }
//    @GetMapping("/vo/list")
//    public AjaxResult listVo(Well well){
//        return AjaxResult.success(wellService.listVo(well));
//    }
//    @GetMapping(value = "/vo/detail/{wellId}")
//    public AjaxResult detailVo(@PathVariable("wellId") Long wellId) {
//        return AjaxResult.success(wellService.getOneVo(wellId));
//    }
}
