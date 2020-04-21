package com.mobby.attendance.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mobby.attendance.VO.OpenCourseVO;
import com.mobby.attendance.core.common.Result;
import com.mobby.attendance.core.enums.ResultCode;
import com.mobby.attendance.entity.OpenCourse;
import com.mobby.attendance.mapper.OpenCourseMapper;
import com.mobby.attendance.service.IOpenCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mobby.attendance.util.PageResultUtil;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
public class OpenCourseServiceImpl extends ServiceImpl<OpenCourseMapper, OpenCourse> implements IOpenCourseService {

    private OpenCourseMapper openCourseMapper;

    @Override
    public Result save(Map<String, String> params) {
        String openCourseSn = params.get("openCourseSn");
        String openCourseName = params.get("openCourseName");
        int courseId = Integer.parseInt(params.get("courseId"));
        int teacherId = Integer.parseInt(params.get("teacherId"));
        int courseTimes = Integer.parseInt(params.get("courseTimes"));
        String startTime = params.get("courseStartTime");
        String endTime = params.get("courseEndTime");
        LocalDate courseStartTime = null;
        LocalDate courseEndTIme = null;

        if (StringUtils.isNotBlank(startTime)) {
            startTime = startTime.substring(0, startTime.indexOf("T"));
            courseStartTime = LocalDate.parse(startTime);
        }
        if (StringUtils.isNotBlank(endTime)) {
            endTime = endTime.substring(0, endTime.indexOf("T"));
            courseEndTIme = LocalDate.parse(endTime);
        }

        OpenCourse openCourse = new OpenCourse();
        openCourse.setCourseId(courseId);
        openCourse.setCourseTimes(courseTimes);
        openCourse.setCourseStartTime(courseStartTime);
        openCourse.setCourseEndTime(courseEndTIme);
        openCourse.setTeacherId(teacherId);
        openCourse.setOpenCourseName(openCourseName);
        openCourse.setOpenCourseSn(openCourseSn);

        int result = openCourseMapper.insert(openCourse);
        if (result <= 0) {
            return Result.failure(ResultCode.RECORD_INSERT);
        }

        return Result.success(openCourse);
    }

    @Override
    public Map<String, Object> listAll(Page<OpenCourseVO> page, QueryWrapper<OpenCourseVO> queryWrapper) {
        IPage<OpenCourseVO> openCoursePage = openCourseMapper.queryAll(page, queryWrapper);
        return PageResultUtil.result(openCoursePage);
    }


}
