package com.mobby.attendance.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mobby.attendance.core.common.Result;
import com.mobby.attendance.entity.College;
import com.mobby.attendance.entity.Major;
import com.mobby.attendance.service.IMajorService;
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
@Api(tags = "专业管理")
@RestController
@RequestMapping("/major")
public class MajorController {

    @Autowired
    @Qualifier("majorServiceImpl")
    private IMajorService majorService;

    @ApiOperation(value = "添加专业")
    @PostMapping("/")
    public Result add(@RequestBody Major major) {
        return majorService.saveMajor(major);
    }

    @ApiOperation(value = "获取某学院下的专业")
    @GetMapping("college/{collegeId}")
    public List<Major> list(@PathVariable(name = "collegeId") Integer collegeId) {
        return majorService.queryMajorByCollege(collegeId);
    }

    @ApiOperation(value = "获取所有专业")
    @GetMapping("/")
    public Map<Integer, List<Major>> listAll() {
        return majorService.queryAll();
    }
}

