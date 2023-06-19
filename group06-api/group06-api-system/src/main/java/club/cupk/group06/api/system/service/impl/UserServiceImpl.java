package club.cupk.group06.api.system.service.impl;

import club.cupk.group06.api.system.service.UserService;
import club.cupk.group06.data.system.domain.UserPo;
import club.cupk.group06.data.system.mapper.UserMapper;
import club.cupk.group06.data.system.vo.UserItemVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPo> implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public Page getPage(Page page, UserPo userPo) {
        return page(page, Wrappers.lambdaQuery(userPo));
    }

    @Override
    public List<UserPo> getList(UserPo userPo) {
        return list(Wrappers.lambdaQuery(userPo));
    }


    @Override
    public IPage<UserItemVo> getUserByQuery(IPage<UserItemVo> page,
                                     String userPhone,
                                     String userName,
                                     String userEmail,
                                     String userWell,
                                     String userField) {
        try{
            return userMapper.getUser(page,
                    userPhone,
                    userName,
                    userEmail,
                    userWell,
                    userField);
        }catch (Exception e){
            return null;
        }

    }
}
