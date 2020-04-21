package com.mobby.attendance.mapper;

import com.mobby.attendance.entity.Location;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hulu
 * @since 2020-04-17
 */
public interface LocationMapper extends BaseMapper<Location> {

    @Select("select lo.location_id, lo.location_name from at_location lo where lo.location_id not in ( " +
            "select wc.location_id from at_week_course wc where wc.week = #{week} and wc.week_day = #{day} and wc.section = #{section} " +
            ")")
    List<Location> selectAvailableLocation(@Param(value = "week") Integer week,
                                           @Param(value = "day") Integer day,
                                           @Param(value = "section") Integer section);

}
