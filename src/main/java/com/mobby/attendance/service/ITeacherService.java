package com.mobby.attendance.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mobby.attendance.entity.Teacher;
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
public interface ITeacherService extends IService<Teacher> {

    Map<String, Object> list(Page<Teacher> page, QueryWrapper<Teacher> queryWrapper);

    List<Map<String, Object>> listAll();

}
