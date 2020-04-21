package com.mobby.attendance.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mobby.attendance.core.common.Result;
import com.mobby.attendance.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hulu
 * @since 2020-04-14
 */
public interface IUserService extends IService<User> {

    Result saveUser(User user);

    Result login(String username, String password);

    Map<String, Object> selectUserPage(Page<User> page, QueryWrapper<User> queryWrapper);

}
