package com.mobby.attendance.controller;


import com.mobby.attendance.entity.Location;
import com.mobby.attendance.service.IWeekCourseService;
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
 * @since 2020-04-17
 */
@Api(tags = "课程表管理")
@RestController
@RequestMapping("/weekCourse")
public class WeekCourseController {

    @Autowired
    @Qualifier("weekCourseServiceImpl")
    private IWeekCourseService weekCourseService;

    @ApiOperation(value = "换取可排课地点")
    @GetMapping("/listAvailableLocation")
    public List<Location> listAvailableLocation(@RequestParam Integer week,
                                                @RequestParam Integer day,
                                                @RequestParam Integer section) {
        return weekCourseService.listAvailableLocation(week, day, section);
    }

    @ApiOperation("添加课程表")
    @PostMapping("/add")
    public void addWeekCourse(@RequestBody Map<String, Object> map) {
        weekCourseService.add(map);
    }

    @ApiOperation("获取开课课程的课程表")
    @GetMapping("/listCourse")
    public List<Map<String, Object>> listWeekCourse(@RequestParam Integer openCourseId,
                                                    @RequestParam Integer teacherId,
                                                    @RequestParam(required = false) Integer classId) {
        return weekCourseService.listWeekCourse(openCourseId, teacherId, classId);
    }


}

