package com.mobby.attendance.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mobby.attendance.VO.CourseVO;
import com.mobby.attendance.core.common.Result;
import com.mobby.attendance.core.enums.ResultCode;
import com.mobby.attendance.entity.Course;
import com.mobby.attendance.mapper.CourseMapper;
import com.mobby.attendance.service.ICourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mobby.attendance.util.PageResultUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hulu
 * @since 2020-04-14
 */
@Service
@AllArgsConstructor
public class  CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {

    private CourseMapper courseMapper;

    @Override
    public Result save(Map<String, String> params) {
        String courseSn = params.get("courseSn");
        String courseName = params.get("courseName");
        int type = Integer.parseInt(params.get("type"));
        int majorId = 0;
        if (type == 1) {
            majorId = Integer.parseInt(params.get("majorId"));
        }
        Course course = new Course();
        course.setCourseSn(courseSn);
        course.setCourseName(courseName);
        course.setType(type);
        if (type == 1) {
            course.setMajorId(majorId);
        }
        course.setCourseStatus(1);
        course.setAddTime(LocalDateTime.now());
        course.setUpdater("admin");
        course.setUpdateTime(LocalDateTime.now());

        int res = courseMapper.insert(course);
        if (res <= 0) {
            return Result.failure(ResultCode.RECORD_INSERT);
        }

        return Result.success(course);
    }

    public Map<String, Object> selectCoursePage(Page<CourseVO> page, QueryWrapper<CourseVO> wrapper) {
        wrapper.orderByDesc("add_time");
        IPage<CourseVO> coursePage = courseMapper.selectCourseList(page, wrapper);
        return PageResultUtil.result(coursePage);
    }

    @Override
    public List<Course> listAll() {
        return courseMapper.selectList(new QueryWrapper<>());
    }
}
