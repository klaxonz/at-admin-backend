package com.mobby.attendance.VO;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author hulu
 * @ClassName OpenCourseVO.java
 * @Description
 * @createTime 2020年04月18日 17:58:00
 */
@Data
public class OpenCourseVO {

    private Integer openCourseId;
    private String openCourseSn;
    private String openCourseName;
    private Integer courseTimes;
    private Integer teacherId;
    private String teacherName;
    private LocalDate courseStartTime;
    private LocalDate courseEndTime;
    private LocalDateTime addTime;
}
