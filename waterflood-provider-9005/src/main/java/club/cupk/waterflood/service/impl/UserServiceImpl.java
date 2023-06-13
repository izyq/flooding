package club.cupk.waterflood.service.impl;
import club.cupk.waterflood.domain.User;
import club.cupk.waterflood.mapper.UserMapper;
import club.cupk.waterflood.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService{
}
