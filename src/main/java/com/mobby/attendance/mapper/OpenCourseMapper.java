package com.mobby.attendance.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mobby.attendance.VO.OpenCourseVO;
import com.mobby.attendance.VO.StudentVO;
import com.mobby.attendance.entity.OpenCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hulu
 * @since 2020-04-17
 */
public interface OpenCourseMapper extends BaseMapper<OpenCourse> {

    @Select("select oc.open_course_id, oc.open_course_name, oc.open_course_sn, oc.course_times, oc.course_start_time, " +
            "oc.course_end_time, oc.teacher_id, te.teacher_name, oc.add_time from at_open_course oc left join at_teacher te on oc.teacher_id = te.teacher_id " +
            "${ew.customSqlSegment}")
    IPage<OpenCourseVO> queryAll(Page<OpenCourseVO> page, @Param(Constants.WRAPPER) Wrapper wrapper);
}
