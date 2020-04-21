package com.mobby.attendance.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.mobby.attendance.entity.WeekCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hulu
 * @since 2020-04-17
 */
public interface WeekCourseMapper extends BaseMapper<WeekCourse> {

    @Select("select wc.week_course_id, wc.open_course_id, oc.open_course_name, wc.teacher_id, te.teacher_name, " +
            "wc.class_id, cl.class_name, wc.location_id, lo.location_name, wc.week, " +
            "wc.week_day, wc.section from at_week_course wc " +
            "left join at_open_course oc on wc.open_course_id = oc.open_course_id " +
            "left join at_teacher te on wc.teacher_id = te.teacher_id " +
            "left join at_class cl on wc.class_id = cl.class_id " +
            "left join at_location lo on wc.location_id = lo.location_id " +
            "${ew.customSqlSegment}")
    List<Map<String, Object>> selectListByOpenCourseIdAndTeacherId(@Param(Constants.WRAPPER) Wrapper wrapper);

}
