package club.cupk.group06.api.core.service;
import club.cupk.waterflood.domain.Role;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IRoleService extends IService<Role>{
    Page getPage(Page page,Role role);
    List<Role> getList(Role role);
}
