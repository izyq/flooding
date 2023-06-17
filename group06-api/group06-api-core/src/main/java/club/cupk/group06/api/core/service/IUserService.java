package club.cupk.group06.api.core.service;

import club.cupk.group06.data.core.domain.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IUserService extends IService<User> {
    Page getPage(Page page, User user);

    List<User> getList(User user);
}
