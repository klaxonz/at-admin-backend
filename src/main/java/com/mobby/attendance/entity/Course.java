package com.mobby.attendance.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author hulu
 * @since 2020-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("at_course")
public class Course implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 课程id
     */
    @TableId(value = "course_id", type = IdType.AUTO)
    private Integer courseId;

    /**
     * 课程编号
     */
    private String courseSn;

    /**
     * 课程名
     */
    private String courseName;

    /**
     * 课程分类id
     */
    private Integer courseCategoryId;

    /**
     * 任课教师
     */
    private Integer teacherId;

    /**
     * 课程类型
     */
    private Integer type;

    /**
     * 课程所属学院id
     */
    private Integer majorId;

    /**
     * 课程状态
     */
    private Integer courseStatus;

    /**
     * 课程添加时间
     */
    private LocalDateTime addTime;

    /**
     * 更新者
     */
    private String updater;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
