package com.mobby.attendance.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mobby.attendance.VO.ClassVO;
import com.mobby.attendance.entity.Class;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author hulu
 * @since 2020-04-14
 */
public interface IClassService extends IService<Class> {

    Map<String, Object> queryAll(Page<ClassVO> page);

    List<Class> queryAll();

    List<Map<String, Object>> queryTreeNavigation();

    Map<String, Object> listByMajorId(Page<ClassVO> classPage, QueryWrapper<ClassVO> queryWrapper);
}
