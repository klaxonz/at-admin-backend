package com.mobby.attendance.VO;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author hulu
 * @ClassName CourseVO.java
 * @Description
 * @createTime 2020年04月18日 02:03:00
 */
@Data
public class CourseVO {

    private String courseSn;
    private String courseName;
    private int type;
    private int majorId;
    private String majorName;
    private LocalDateTime addTime;

}
