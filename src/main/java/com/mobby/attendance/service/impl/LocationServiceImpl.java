package com.mobby.attendance.service.impl;

import com.mobby.attendance.entity.Location;
import com.mobby.attendance.mapper.LocationMapper;
import com.mobby.attendance.service.ILocationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hulu
 * @since 2020-04-17
 */
@Service
public class LocationServiceImpl extends ServiceImpl<LocationMapper, Location> implements ILocationService {

}
