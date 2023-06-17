package club.cupk.group06.api.core.service.impl;
import club.cupk.waterflood.domain.Role;
import club.cupk.group06.data.core.mapper.RoleMapper;
import club.cupk.waterflood.service.IRoleService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

import java.util.List;

@DubboService
@Component
public class RoleServiceImpl extends ServiceImpl<RoleMapper,Role> implements IRoleService{
    @Override
    public Page getPage(Page page, Role role) {
        return page(page, Wrappers.lambdaQuery(role));
    }

    @Override
    public List<Role> getList(Role role) {
        return list(Wrappers.lambdaQuery(role));
    }
}
