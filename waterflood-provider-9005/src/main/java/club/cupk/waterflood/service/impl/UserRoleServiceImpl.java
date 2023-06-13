package club.cupk.waterflood.service.impl;
import club.cupk.waterflood.domain.UserRole;
import club.cupk.waterflood.mapper.UserRoleMapper;
import club.cupk.waterflood.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

@DubboService
@Component
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper,UserRole> implements IUserRoleService{
}
