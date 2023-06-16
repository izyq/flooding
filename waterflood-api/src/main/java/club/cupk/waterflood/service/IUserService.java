package club.cupk.waterflood.service;
import club.cupk.waterflood.domain.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IUserService extends IService<User>{
    Page getPage(Page page, User user);
    List<User> getList(User user);
}
