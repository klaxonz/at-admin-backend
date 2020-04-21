package com.mobby.attendance.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mobby.attendance.core.common.Result;
import com.mobby.attendance.core.enums.ResultCode;
import com.mobby.attendance.entity.User;
import com.mobby.attendance.mapper.UserMapper;
import com.mobby.attendance.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mobby.attendance.util.PageResultUtil;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hulu
 * @since 2020-04-14
 */
@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private UserMapper userMapper;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Result saveUser(User user) {

        // 用户名
        User userDo = queryUsernameIsExists(user.getUsername());
        if (userDo == null) {
            return Result.failure(ResultCode.USERNAME_EXISTS);
        }
        // 密码
        String password = user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(password));

        user.setCreateTime(LocalDateTime.now());
        user.setUpdater("admin");
        user.setUpdateTime(LocalDateTime.now());

        int result = userMapper.insert(user);
        if (result == 0){
            return Result.failure(ResultCode.RECORD_INSERT);
        }

        return Result.success();
    }

    @Override
    public Result login(String username, String password) {
        if (StringUtils.isBlank(username) ) {
            return Result.failure(ResultCode.USERNAME_EMPTY);
        }
        if (StringUtils.isBlank(password)) {
            return Result.failure(ResultCode.PASSWORD_EMPTY);
        }
        User user = queryUserByUsernameAndPassword(username, password);
        if (user == null) {
            return Result.failure(ResultCode.ACCOUNT_OR_PASSWORD_ERROR);
        }

        user.setPassword("");
        return Result.success(user);
    }

    @Override
    public Map<String, Object> selectUserPage(Page<User> page, QueryWrapper<User> queryWrapper) {
        queryWrapper.select(User.class, i -> !i.getColumn().equals("password"));
        IPage<User> userPage = userMapper.selectPage(page, queryWrapper);
        return PageResultUtil.result(userPage);
    }

    private User queryUsernameIsExists(String username){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return userMapper.selectOne(queryWrapper);
    }

    public User queryUserByUsernameAndPassword(String username, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username)
                .eq("password", bCryptPasswordEncoder.encode(password));
        return userMapper.selectOne(queryWrapper);
    }
}
