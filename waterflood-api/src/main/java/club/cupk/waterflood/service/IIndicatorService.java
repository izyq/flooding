package club.cupk.waterflood.service;

import club.cupk.waterflood.domain.Indicator;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IIndicatorService extends IService<Indicator>{

    Page getPage(Page page,Indicator indicator);

    List<Indicator> getList(Indicator indicator);
}
