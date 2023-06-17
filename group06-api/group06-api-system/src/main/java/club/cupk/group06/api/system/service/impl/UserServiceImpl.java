package club.cupk.group06.api.system.service.impl;

import club.cupk.group06.api.system.service.UserService;
import club.cupk.group06.data.system.domain.User;
import club.cupk.group06.data.system.mapper.UserMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public Page getPage(Page page, User user) {
        return page(page, Wrappers.lambdaQuery(user));
    }

    @Override
    public List<User> getList(User user) {
        return list(Wrappers.lambdaQuery(user));
    }
}
