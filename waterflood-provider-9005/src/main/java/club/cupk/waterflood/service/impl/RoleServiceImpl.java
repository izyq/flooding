package club.cupk.waterflood.service.impl;
import club.cupk.waterflood.domain.Role;
import club.cupk.waterflood.mapper.RoleMapper;
import club.cupk.waterflood.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper,Role> implements IRoleService{
}
