package club.cupk.group06.data.system.mapper;

import club.cupk.group06.data.system.domain.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

@Mapper
@Transactional(rollbackFor = Exception.class)
public interface RoleMapper extends BaseMapper<Role> {
}
