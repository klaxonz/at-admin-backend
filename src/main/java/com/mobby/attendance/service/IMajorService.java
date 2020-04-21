package com.mobby.attendance.service;

import com.mobby.attendance.core.common.Result;
import com.mobby.attendance.entity.Major;
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
public interface IMajorService extends IService<Major> {
    Result saveMajor(Major major);

    List<Major> queryMajorByCollege(Integer collegeId);

    Map<Integer, List<Major>> queryAll();
}
