package club.cupk.group06.api.core.service.impl;
import club.cupk.waterflood.domain.User;
import club.cupk.group06.data.core.mapper.UserMapper;
import club.cupk.waterflood.service.IUserService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

import java.util.List;

@DubboService
@Component
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService{
    @Override
    public Page getPage(Page page, User user) {
        return page(page, Wrappers.lambdaQuery(user));
    }

    @Override
    public List<User> getList(User user) {
        return list(Wrappers.lambdaQuery(user));
    }
}
