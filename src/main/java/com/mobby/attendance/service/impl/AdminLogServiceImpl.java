package com.mobby.attendance.service.impl;

import com.mobby.attendance.entity.AdminLog;
import com.mobby.attendance.mapper.AdminLogMapper;
import com.mobby.attendance.service.IAdminLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hulu
 * @since 2020-04-14
 */
@Service
public class AdminLogServiceImpl extends ServiceImpl<AdminLogMapper, AdminLog> implements IAdminLogService {

}
