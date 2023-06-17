package club.cupk.group06.api.system.service.impl;

import club.cupk.group06.api.system.service.UserService;
import club.cupk.group06.data.system.domain.UserPo;
import club.cupk.group06.data.system.mapper.UserMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPo> implements UserService {

    @Override
    public Page getPage(Page page, UserPo userPo) {
        return page(page, Wrappers.lambdaQuery(userPo));
    }

    @Override
    public List<UserPo> getList(UserPo userPo) {
        return list(Wrappers.lambdaQuery(userPo));
    }
}
