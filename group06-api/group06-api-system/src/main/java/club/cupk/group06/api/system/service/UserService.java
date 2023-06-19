package club.cupk.group06.api.system.service;

import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.system.domain.UserPo;
import club.cupk.group06.data.system.dto.UserDto;
import club.cupk.group06.data.system.vo.UserItemVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface UserService extends IService<UserPo> {
    Page getPage(Page page, UserPo userPo);

    List<UserPo> getList(UserPo userPo);

    AjaxResult getUserByQuery(IPage<UserItemVo> page,UserDto userDto);
}
