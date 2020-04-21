package com.mobby.attendance.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mobby.attendance.core.common.Result;
import com.mobby.attendance.entity.College;
import com.mobby.attendance.entity.User;
import com.mobby.attendance.service.ICollegeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hulu
 * @since 2020-04-14
 */
@Api(tags = "学院管理")
@RestController
@RequestMapping("/api/college")
public class CollegeController {

    @Autowired
    @Qualifier("collegeServiceImpl")
    private ICollegeService collegeService;

    @ApiOperation(value = "添加学院")
    @PostMapping("/")
    public Result add(@RequestBody College college) {
        return collegeService.saveCollege(college);
    }

    @ApiOperation(value = "获取学院")
    @GetMapping("/")
    public List<College> list(@RequestParam Integer page, @RequestParam Integer pageSize) {
        Page<College> collegePage = new Page<>(page, pageSize);
        Page<College> page1 = collegeService.page(collegePage, new QueryWrapper<>());
        return page1.getRecords();
    }


}

