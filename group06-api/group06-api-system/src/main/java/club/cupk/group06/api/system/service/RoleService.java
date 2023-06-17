package club.cupk.group06.api.system.service;

import club.cupk.group06.data.system.domain.Role;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface RoleService extends IService<Role> {
    Page getPage(Page page, Role role);

    List<Role> getList(Role role);
}
