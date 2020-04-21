package com.mobby.attendance.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mobby.attendance.VO.OpenCourseVO;
import com.mobby.attendance.core.common.Result;
import com.mobby.attendance.entity.OpenCourse;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hulu
 * @since 2020-04-17
 */
public interface IOpenCourseService extends IService<OpenCourse> {


    Result save(Map<String, String> params);

    Map<String, Object> listAll(Page<OpenCourseVO> page, QueryWrapper<OpenCourseVO> queryWrapper);

}
