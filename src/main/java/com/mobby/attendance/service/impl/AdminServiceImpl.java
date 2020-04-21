package com.mobby.attendance.service.impl;

import com.mobby.attendance.entity.Admin;
import com.mobby.attendance.mapper.AdminMapper;
import com.mobby.attendance.service.IAdminService;
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
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

}
