package com.mobby.attendance.service;

import com.mobby.attendance.core.common.Result;
import com.mobby.attendance.entity.Location;
import com.mobby.attendance.entity.WeekCourse;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hulu
 * @since 2020-04-17
 */
public interface IWeekCourseService extends IService<WeekCourse> {

    List<Location> listAvailableLocation(Integer week, Integer day, Integer section);

    Result add(Map<String, Object> map);

    List<Map<String, Object>> listWeekCourse(Integer openCourseId, Integer teacherId, Integer classId);
}
