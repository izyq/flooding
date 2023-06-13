package club.cupk.waterflood.controller;

import club.cupk.waterflood.domain.Well;
import club.cupk.waterflood.service.IWellService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.AjaxResult;
import xin.altitude.cms.common.entity.PageEntity;

import java.util.Arrays;
@RestController
@RequestMapping("/waterflood/well")
public class WellController{
    @DubboReference(check = false)
    private IWellService wellService;
    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity,Well well){
        return AjaxResult.success(wellService.page(pageEntity.toPage(), Wrappers.lambdaQuery(well)));
    }
    @GetMapping("/list")
    public AjaxResult list(Well well){
        return AjaxResult.success(wellService.list(Wrappers.lambdaQuery(well)));
    }
    @PostMapping("/push")
    public AjaxResult add(@RequestBody Well well) {
        return AjaxResult.success(wellService.save(well));
    }
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody Well well) {
        return AjaxResult.success(wellService.updateById(well));
    }
    @DeleteMapping("/delete/{wellIds}")
    public AjaxResult delete(@PathVariable Long[] wellIds) {
        return AjaxResult.success(wellService.removeByIds(Arrays.asList(wellIds)));
    }
    @GetMapping(value = "/detail/{wellId}")
    public AjaxResult detail(@PathVariable("wellId") Long wellId) {
        return AjaxResult.success(wellService.getById(wellId));
    }
    @GetMapping("/vo/page")
    public AjaxResult pageVo(PageEntity pageEntity,Well well){
        return AjaxResult.success(wellService.pageVo(pageEntity.toPage(), well));
    }
    @GetMapping("/vo/list")
    public AjaxResult listVo(Well well){
        return AjaxResult.success(wellService.listVo(well));
    }
    @GetMapping(value = "/vo/detail/{wellId}")
    public AjaxResult detailVo(@PathVariable("wellId") Long wellId) {
        return AjaxResult.success(wellService.getOneVo(wellId));
    }
}
