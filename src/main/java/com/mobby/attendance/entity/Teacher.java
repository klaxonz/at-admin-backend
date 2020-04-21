package com.mobby.attendance.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("at_teacher")
public class Teacher implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 教师id
     */
    private Integer teacherId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 教师名称
     */
    private String teacherName;

    /**
     * 教师性别
     */
    private Integer gender;

    /**
     * 出生年月日
     */
    private LocalDateTime birthday;

    /**
     * 加入时间
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
