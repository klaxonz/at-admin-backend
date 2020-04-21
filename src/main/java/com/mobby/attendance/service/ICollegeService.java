package com.mobby.attendance.service;

import com.mobby.attendance.core.common.Result;
import com.mobby.attendance.entity.College;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Collection;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hulu
 * @since 2020-04-14
 */
public interface ICollegeService extends IService<College> {

    Result saveCollege(College college);

}
