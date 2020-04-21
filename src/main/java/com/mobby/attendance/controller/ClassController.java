package com.mobby.attendance.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mobby.attendance.VO.ClassVO;
import com.mobby.attendance.entity.Class;
import com.mobby.attendance.service.IClassService;
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
@Api(tags = "班级管理")
@RestController
@RequestMapping("/class")
public class ClassController {

    @Autowired
    @Qualifier("classServiceImpl")
    private IClassService classService;

    @ApiOperation(value = "分页获取所有班级")
    @GetMapping("/")
    public Map<String, Object> list(@RequestParam Integer page, @RequestParam Integer pageSize) {

        Page<ClassVO> classPage = new Page<>(page, pageSize);
        return classService.queryAll(classPage);
    }

    @ApiOperation(value = "获取所有班级")
    @GetMapping("/all")
    public List<Class> listAll() {
        return classService.queryAll();
    }


    @ApiOperation(value = "获取某个专业的班级")
    @GetMapping("/major/")
    public Map<String, Object> listMajorClass(@RequestParam Integer page,
                                              @RequestParam Integer pageSize,
                                              @RequestParam Integer majorId) {

        QueryWrapper<ClassVO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("cl.major_id", majorId);
        Page<ClassVO> classPage = new Page<>(page, pageSize);
        return classService.listByMajorId(classPage, queryWrapper);
    }

    @ApiOperation(value = "获取二级树状导航栏")
    @GetMapping("/tree")
    public List<Map<String, Object>> treeNavigation() {
        return classService.queryTreeNavigation();
    }





}

