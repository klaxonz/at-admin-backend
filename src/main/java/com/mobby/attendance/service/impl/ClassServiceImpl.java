package com.mobby.attendance.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobby.attendance.VO.ClassVO;
import com.mobby.attendance.entity.Class;
import com.mobby.attendance.entity.College;
import com.mobby.attendance.entity.Major;
import com.mobby.attendance.mapper.ClassMapper;
import com.mobby.attendance.mapper.CollegeMapper;
import com.mobby.attendance.mapper.MajorMapper;
import com.mobby.attendance.service.IClassService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mobby.attendance.util.PageResultUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class ClassServiceImpl extends ServiceImpl<ClassMapper, Class> implements IClassService {

    private ClassMapper classMapper;

    private CollegeMapper collegeMapper;

    private MajorMapper majorMapper;


    @Override
    public Map<String, Object> queryAll(Page<ClassVO> page) {
        IPage<ClassVO> classVOIPage = classMapper.queryAll(page);
        return PageResultUtil.result(classVOIPage);
    }

    @Override
    public List<Class> queryAll() {
        return classMapper.selectList(new QueryWrapper<>());
    }

    @Override
    public List<Map<String, Object>> queryTreeNavigation() {
        List<College> collegeList = collegeMapper.selectList(null);
        List<Map<String, Object>> result = new ArrayList<>();
        collegeList.forEach(item -> {
            ObjectMapper m = new ObjectMapper();
            Map<String, Object> map = m.convertValue(item, Map.class);

            QueryWrapper<Major> majorQueryWrapper = new QueryWrapper<>();
            majorQueryWrapper.eq("college_id", item.getCollegeId());
            List<Major> majorList = majorMapper.selectList(majorQueryWrapper);
            map.put("list", majorList);

            result.add(map);
        });
        return result;
    }

    @Override
    public Map<String, Object> listByMajorId(Page<ClassVO> classPage, QueryWrapper<ClassVO> queryWrapper) {
        IPage<ClassVO> classVOIPage = classMapper.queryByMajorId(classPage, queryWrapper);
        return PageResultUtil.result(classVOIPage);
    }
}
