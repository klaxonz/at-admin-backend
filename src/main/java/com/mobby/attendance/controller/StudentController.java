package com.mobby.attendance.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mobby.attendance.VO.StudentVO;
import com.mobby.attendance.service.IStudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hulu
 * @since 2020-04-14
 */
@Api(tags = "学生管理")
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    @Qualifier("studentServiceImpl")
    private IStudentService studentService;

    @ApiOperation(value = "获取所有学生")
    @GetMapping("/")
    public Map<String, Object> listStudent(@RequestParam Integer page, @RequestParam Integer pageSize) {
        if (page <= 0) {
            page = 1;
        }
        if (pageSize <= 0) {
            pageSize = 6;
        }
        Page<StudentVO> classPage = new Page<>(page, pageSize);
        return studentService.listClassStudent(classPage);
    }

}

