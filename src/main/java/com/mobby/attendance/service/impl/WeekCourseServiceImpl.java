package com.mobby.attendance.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mobby.attendance.core.common.Result;
import com.mobby.attendance.core.enums.ResultCode;
import com.mobby.attendance.entity.Location;
import com.mobby.attendance.entity.WeekCourse;
import com.mobby.attendance.mapper.LocationMapper;
import com.mobby.attendance.mapper.WeekCourseMapper;
import com.mobby.attendance.service.IWeekCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hulu
 * @since 2020-04-17
 */
@Service
@AllArgsConstructor
public class WeekCourseServiceImpl extends ServiceImpl<WeekCourseMapper, WeekCourse> implements IWeekCourseService {

    private LocationMapper locationMapper;
    private WeekCourseMapper weekCourseMapper;

    @Override
    public List<Location> listAvailableLocation(Integer week, Integer day, Integer section) {
        return locationMapper.selectAvailableLocation(week, day, section);
    }

    @Override
    public Result add(Map<String, Object> map) {
        Integer teacherId = (Integer)map.get("teacherId");
        Integer openCourseId = (Integer) map.get("openCourseId");
        Integer classId = (Integer) map.get("classId");
        List<Map<String, Integer>> weekSelect = (List<Map<String, Integer>>) map.get("weekSelect");

        // 删除原有的weekCourse记录
        QueryWrapper<WeekCourse> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("teacher_id", teacherId)
                .eq("open_course_id", openCourseId)
                .eq("class_id", classId);

        weekCourseMapper.delete(queryWrapper);

        for (Map<String, Integer> sectionMap : weekSelect) {
            Integer week = sectionMap.get("week");
            Integer day = sectionMap.get("day");
            Integer section = sectionMap.get("section");
            Integer locationId = sectionMap.get("locationId");

            WeekCourse weekCourse = new WeekCourse();
            weekCourse.setOpenCourseId(openCourseId);
            weekCourse.setLocationId(locationId);
            weekCourse.setClassId(classId);
            weekCourse.setTeacherId(teacherId);
            weekCourse.setWeek(week);
            weekCourse.setWeekDay(day);
            weekCourse.setSection(section);

            int result = weekCourseMapper.insert(weekCourse);
            if (result <= 0) {
                return Result.failure(ResultCode.RECORD_INSERT);
            }
        }

        return Result.success();
    }

    @Override
    public List<Map<String, Object>> listWeekCourse(Integer openCourseId, Integer teacherId, Integer classId) {

        QueryWrapper<WeekCourse> otherQueryWrapper = new QueryWrapper<>();

        otherQueryWrapper
                .ne("wc.open_course_id", openCourseId)
                .and(wrapper -> {
                    wrapper.eq("wc.teacher_id", teacherId);
                    if (classId != null) {
                        wrapper.or(orWrapper -> orWrapper.eq("wc.class_id", classId));
                    }
                });
        List<Map<String, Object>> otherList = weekCourseMapper.selectListByOpenCourseIdAndTeacherId(otherQueryWrapper);

        QueryWrapper<WeekCourse> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("wc.open_course_id", openCourseId)
                .eq("wc.teacher_id", teacherId)
                .orderByAsc("wc.week")
                .orderByAsc("wc.week_day")
                .orderByAsc("wc.section");

        List<Map<String, Object>> courseList = weekCourseMapper.selectListByOpenCourseIdAndTeacherId(queryWrapper);
        courseList.addAll(otherList);

        for (Map<String, Object> map :
                courseList) {
            Integer courseId = (Integer)map.get("open_course_id");
            if (courseId.equals(openCourseId)) {
                map.put("type", 1);
            } else {
                map.put("type", 2);
            }
        }

        return courseList;
    }
}
