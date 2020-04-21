package com.mobby.attendance.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mobby.attendance.VO.CourseVO;
import com.mobby.attendance.core.common.Result;
import com.mobby.attendance.entity.Course;
import com.mobby.attendance.service.ICourseService;
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
@Api(tags = "课程管理")
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    @Qualifier("courseServiceImpl")
    private ICourseService courseService;

    @ApiOperation("添加课程")
    @PostMapping("/")
    public Result add(@RequestBody Map<String, String> params){
        return courseService.save(params);
    }

    @ApiOperation("课程分类列表")
    @GetMapping("/")
    public Map<String, Object> list(@RequestParam Integer page, @RequestParam Integer pageSize){
        Page<CourseVO> coursePage = new Page<>(page, pageSize);
        QueryWrapper<CourseVO> courseQueryWrapper = new QueryWrapper<>();
        return courseService.selectCoursePage(coursePage, courseQueryWrapper);
    }

    @ApiOperation("所有课程")
    @GetMapping("/all")
    public List<Course> list(){
        return courseService.listAll();
    }



}

