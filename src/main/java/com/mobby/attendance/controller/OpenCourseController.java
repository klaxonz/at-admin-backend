package com.mobby.attendance.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mobby.attendance.VO.OpenCourseVO;
import com.mobby.attendance.core.common.Result;
import com.mobby.attendance.entity.OpenCourse;
import com.mobby.attendance.service.IOpenCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hulu
 * @since 2020-04-17
 */
@Api(tags = "开课课程管理")
@RestController
@RequestMapping("/openCourse")
public class OpenCourseController {

    @Autowired
    @Qualifier("openCourseServiceImpl")
    private IOpenCourseService openCourseService;

    @ApiOperation("添加开课课程")
    @PostMapping("/")
    public Result add(@RequestBody Map<String, String> params){
        return openCourseService.save(params);
    }

    @ApiOperation("分页获取开课课程")
    @GetMapping("/")
    public Map<String, Object> list(@RequestParam Integer page, @RequestParam Integer pageSize) {
        Page<OpenCourseVO> openCoursePage = new Page<>(page, pageSize);
        QueryWrapper<OpenCourseVO> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("oc.add_time");
        return openCourseService.listAll(openCoursePage, queryWrapper);
    }


}

