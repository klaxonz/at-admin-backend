package com.mobby.attendance.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDate;
import java.io.Serializable;
import java.time.LocalDateTime;

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
@TableName("at_open_course")
public class OpenCourse implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "open_course_id", type = IdType.AUTO)
    private Integer openCourseId;

    private String openCourseSn;

    private String openCourseName;

    private Integer courseId;

    private Integer courseTimes;

    private Integer teacherId;

    private LocalDate courseStartTime;

    private LocalDate courseEndTime;

    private LocalDateTime addTime;

}
