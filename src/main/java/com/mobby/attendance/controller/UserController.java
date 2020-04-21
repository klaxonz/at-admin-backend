package com.mobby.attendance.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mobby.attendance.core.common.Result;
import com.mobby.attendance.entity.User;
import com.mobby.attendance.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hulu
 * @since 2020-04-14
 */
@Api(tags = "用户操作")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("userServiceImpl")
    private IUserService userService;

    @ApiOperation(value = "添加用户")
    @PostMapping("/")
    public Result add(@RequestBody @Validated User user) {
        return userService.saveUser(user);
    }

    @ApiOperation(value = "获取用户列表")
    @GetMapping("/")
    public Map<String, Object> list(HttpServletRequest request) {


        int page = Integer.parseInt(request.getParameter("page"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        String username = request.getParameter("username");

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        if (StringUtils.isNoneBlank(username)) {
            queryWrapper.like("username", StringUtils.trim(username));
        }
        Page<User> userPage = new Page<>(page, pageSize);
        return userService.selectUserPage(userPage, queryWrapper);
    }

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public Result login(@RequestParam String username, @RequestParam String password) {
        return userService.login(username, password);
    }


}

