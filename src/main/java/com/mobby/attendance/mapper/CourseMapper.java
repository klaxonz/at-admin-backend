package com.mobby.attendance.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mobby.attendance.VO.CourseVO;
import com.mobby.attendance.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hulu
 * @since 2020-04-14
 */
public interface CourseMapper extends BaseMapper<Course> {

    @Select("select cl.course_id, cl.course_sn, cl.course_name, cl.type, cl.add_time, ma.major_id, ma.major_name" +
            " from at_course cl left join at_major ma on cl.major_id = ma.major_id ${ew.customSqlSegment}")
    IPage<CourseVO> selectCourseList(Page<CourseVO> page, @Param(Constants.WRAPPER) Wrapper wrapper);

}
