package com.mobby.attendance.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mobby.attendance.VO.CourseVO;
import com.mobby.attendance.core.common.Result;
import com.mobby.attendance.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hulu
 * @since 2020-04-14
 */
public interface ICourseService extends IService<Course> {
    Result save(Map<String, String> params);

    Map<String, Object> selectCoursePage(Page<CourseVO> coursePage, QueryWrapper<CourseVO> wrapper);

    List<Course> listAll();

}
