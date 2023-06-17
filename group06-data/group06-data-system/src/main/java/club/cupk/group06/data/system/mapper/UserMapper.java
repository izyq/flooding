package club.cupk.group06.data.system.mapper;

import club.cupk.group06.data.system.domain.UserPo;
import club.cupk.group06.data.system.domain.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
@Transactional(rollbackFor = Exception.class)
public interface UserMapper extends BaseMapper<UserPo> {

    /**
     * 根据手机号查询用户是否存在
     * @param phone 手机号
     * @return 是否存在
     */
    boolean existsByPhone(String phone);

    /**
     * 根据手机号查询用户PO
     * @param phone 手机号
     * @return 用户PO
     */
    UserPo selectByPhone(String phone);

    /**
     * 读取用户权限
     * @param userId 用户ID
     * @return 权限列表
     */
    List<UserRole> listRoleById(long userId);

    /**
     * 重置密码
     * @param phone 手机号
     * @param password 新密码
     */
    void updatePassword(@Param("phone") String phone, @Param("password") String password);

}
