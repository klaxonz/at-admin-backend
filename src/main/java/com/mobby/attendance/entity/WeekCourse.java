package com.mobby.attendance.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author hulu
 * @since 2020-04-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("at_week_course")
@ApiModel(value="WeekCourse对象", description="")
public class WeekCourse implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "周课程表id")
    private Integer weekCourseId;

    @ApiModelProperty(value = "开课课程id")
    private Integer openCourseId;

    @ApiModelProperty(value = "教学课陈地点id")
    private Integer locationId;

    @ApiModelProperty(value = "班级id")
    private Integer classId;

    @ApiModelProperty(value = "任课教师id")
    private Integer teacherId;

    @ApiModelProperty(value = "周")
    private Integer week;

    @ApiModelProperty(value = "周几")
    private Integer weekDay;

    @ApiModelProperty(value = "第几节")
    private Integer section;


}
