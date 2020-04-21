package com.mobby.attendance.VO;

import lombok.Data;

/**
 * @author hulu
 * @ClassName ClassVO.java
 * @Description
 * @createTime 2020年04月14日 22:45:00
 */
@Data
public class ClassVO {

    private Integer classId;
    private String className;
    private String majorName;
    private String collegeName;
    private Integer grade;

}
