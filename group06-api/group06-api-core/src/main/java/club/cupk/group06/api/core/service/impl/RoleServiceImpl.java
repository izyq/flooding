package club.cupk.group06.api.core.service.impl;

import club.cupk.group06.api.core.service.IRoleService;
import club.cupk.group06.data.core.domain.Role;
import club.cupk.group06.data.core.mapper.RoleMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
    @Override
    public Page getPage(Page page, Role role) {
        return page(page, Wrappers.lambdaQuery(role));
    }

    @Override
    public List<Role> getList(Role role) {
        return list(Wrappers.lambdaQuery(role));
    }
}
