package com.mobby.attendance.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mobby.attendance.VO.StudentVO;
import com.mobby.attendance.entity.Student;
import com.mobby.attendance.mapper.StudentMapper;
import com.mobby.attendance.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mobby.attendance.util.PageResultUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    private StudentMapper studentMapper;

    @Override
    public Map<String, Object> listClassStudent(Page<StudentVO> page) {

        IPage<StudentVO> studentVOIPage = studentMapper.selectStudent(page);
        return PageResultUtil.result(studentVOIPage);
    }
}
