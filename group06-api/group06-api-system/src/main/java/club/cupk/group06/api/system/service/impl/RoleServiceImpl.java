package club.cupk.group06.api.system.service.impl;

import club.cupk.group06.api.system.service.RoleService;
import club.cupk.group06.data.system.domain.Role;
import club.cupk.group06.data.system.mapper.RoleMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Override
    public Page getPage(Page page, Role role) {
        return page(page, Wrappers.lambdaQuery(role));
    }

    @Override
    public List<Role> getList(Role role) {
        return list(Wrappers.lambdaQuery(role));
    }
}
