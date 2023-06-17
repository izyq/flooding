package club.cupk.group06.api.system.service;

import club.cupk.group06.data.system.domain.UserPo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface UserService extends IService<UserPo> {
    Page getPage(Page page, UserPo userPo);

    List<UserPo> getList(UserPo userPo);
}
