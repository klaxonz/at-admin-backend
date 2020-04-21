package com.mobby.attendance.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mobby.attendance.entity.Teacher;
import com.mobby.attendance.service.ITeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hulu
 * @since 2020-04-14
 */
@Api(tags = "教师管理")
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    @Qualifier("teacherServiceImpl")
    private ITeacherService teacherService;

    @ApiOperation("分页获取全部教师信息")
    @GetMapping("/")
    public Map<String, Object> list(@RequestParam Integer page, @RequestParam Integer pageSize) {

        Page<Teacher> teacherPage = new Page<>(page, pageSize);
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        return teacherService.list(teacherPage, queryWrapper);
    }

    @ApiOperation("获取全部教师信息")
    @GetMapping("/all")
    public List<Map<String, Object>> list() {

        return teacherService.listAll();
    }


}

