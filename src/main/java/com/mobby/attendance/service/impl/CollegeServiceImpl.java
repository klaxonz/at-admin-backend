package com.mobby.attendance.service.impl;

import com.mobby.attendance.core.common.Result;
import com.mobby.attendance.core.enums.ResultCode;
import com.mobby.attendance.entity.College;
import com.mobby.attendance.mapper.CollegeMapper;
import com.mobby.attendance.service.ICollegeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
public class CollegeServiceImpl extends ServiceImpl<CollegeMapper, College> implements ICollegeService {

    private CollegeMapper collegeMapper;

    @Override
    public Result saveCollege(College college) {
        if (StringUtils.isBlank(college.getCollegeName())) {
            Result.failure(ResultCode.COLLEGE_NAME_EMPTY);
        }
        college.setCreateTime(LocalDateTime.now());
        college.setUpdater("admin");
        college.setUpdateTime(LocalDateTime.now());

        int result = collegeMapper.insert(college);
        if (result == 0) {
            Result.failure(ResultCode.RECORD_INSERT);
        }

        return Result.success(college);
    }
}
