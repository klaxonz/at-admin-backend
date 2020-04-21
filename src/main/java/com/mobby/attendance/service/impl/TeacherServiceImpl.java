package com.mobby.attendance.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mobby.attendance.entity.Teacher;
import com.mobby.attendance.mapper.TeacherMapper;
import com.mobby.attendance.service.ITeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mobby.attendance.util.PageResultUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService {

    private TeacherMapper teacherMapper;

    @Override
    public Map<String, Object> list(Page<Teacher> page, QueryWrapper<Teacher> queryWrapper) {
        Page<Teacher> teacherPage = teacherMapper.selectPage(page, queryWrapper);
        return PageResultUtil.result(teacherPage);
    }

    @Override
    public List<Map<String, Object>> listAll() {
        List<Map<String, Object>> maps = teacherMapper.selectMaps(new QueryWrapper<>());
        return maps;
    }
}
