package com.mobby.attendance.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mobby.attendance.VO.StudentVO;
import com.mobby.attendance.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hulu
 * @since 2020-04-14
 */
public interface StudentMapper extends BaseMapper<Student> {

    @Select("select st.student_no, st.student_name, st.gender, cl.class_name from at_student st " +
            "left join at_class cl on st.class_id = cl.class_id")
    IPage<StudentVO> selectStudent(Page<StudentVO> param);

}
