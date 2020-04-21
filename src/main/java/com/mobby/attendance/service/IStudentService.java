package com.mobby.attendance.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mobby.attendance.VO.StudentVO;
import com.mobby.attendance.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hulu
 * @since 2020-04-14
 */
public interface IStudentService extends IService<Student> {

    Map<String, Object> listClassStudent(Page<StudentVO> page);

}
