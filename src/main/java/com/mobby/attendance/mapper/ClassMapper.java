package com.mobby.attendance.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mobby.attendance.VO.ClassVO;
import com.mobby.attendance.entity.Class;
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
 * @since 2020-04-14
 */
public interface ClassMapper extends BaseMapper<Class> {

    @Select("select cl.class_id, cl.class_name, cl.grade, co.college_name, ma.major_name " +
            "from at_class cl " +
            "left join at_major ma on cl.major_id = ma.major_id " +
            "left join at_college co on ma.college_id = co.college_id")
    IPage<ClassVO> queryAll(Page<ClassVO> param);

    @Select("select cl.class_id, cl.class_name, cl.grade, co.college_name, ma.major_name " +
            "from at_class cl " +
            "left join at_major ma on cl.major_id = ma.major_id " +
            "left join at_college co on ma.college_id = co.college_id " +
            "${ew.customSqlSegment}")
    IPage<ClassVO> queryByMajorId(Page<ClassVO> param, @Param(Constants.WRAPPER) Wrapper wrapper);

}
