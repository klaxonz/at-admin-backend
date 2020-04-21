package com.mobby.attendance.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mobby.attendance.core.common.Result;
import com.mobby.attendance.core.enums.ResultCode;
import com.mobby.attendance.entity.College;
import com.mobby.attendance.entity.Major;
import com.mobby.attendance.mapper.CollegeMapper;
import com.mobby.attendance.mapper.MajorMapper;
import com.mobby.attendance.service.ICollegeService;
import com.mobby.attendance.service.IMajorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
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
public class MajorServiceImpl extends ServiceImpl<MajorMapper, Major> implements IMajorService {

    @Autowired
    private MajorMapper majorMapper;

    @Autowired
    private CollegeMapper collegeMapper;

    @Autowired
    @Qualifier("collegeServiceImpl")
    private ICollegeService collegeService;

    @Override
    public Result saveMajor(Major major) {
        Integer collegeId = major.getCollegeId();
        College college = collegeService.getById(collegeId);
        if (college == null) {
            Result.failure(ResultCode.COLLEGE_EMPTY);
        }
        major.setCreateTime(LocalDateTime.now());
        major.setUpdateTime(LocalDateTime.now());
        major.setUpdater("admin");

        int result = majorMapper.insert(major);
        if (result == 0) {
            Result.failure(ResultCode.RECORD_INSERT);
        }

        return Result.success(major);
    }

    @Override
    public List<Major> queryMajorByCollege(Integer collegeId) {
        QueryWrapper<Major> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("college_id", collegeId);
        return majorMapper.selectList(queryWrapper);
    }

    @Override
    public Map<Integer, List<Major>> queryAll() {
        List<College> collegeList = collegeMapper.selectList(new QueryWrapper<>());
        List<Major> majorList = majorMapper.selectList(new QueryWrapper<>());
        Map<Integer, List<Major>> majorMap = new HashMap<>();
        collegeList.forEach((v) -> {
            majorMap.put(v.getCollegeId(), new ArrayList<>());
        });

        majorList.forEach((v) -> {
            List<Major> majors = majorMap.get(v.getCollegeId());
            majors.add(v);
            majorMap.put(v.getCollegeId(), majors);
        });

        return majorMap;
    }

}
