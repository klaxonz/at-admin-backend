package com.mobby.attendance.service;

import com.mobby.attendance.AttendanceApplicationServiceTests;
import com.mobby.attendance.AttendanceApplicationTests;
import com.mobby.attendance.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hulu
 * @ClassName IUserServiceTest.java
 * @Description
 * @createTime 2020年04月10日 18:12:00
 */
public class IUserServiceTest extends AttendanceApplicationServiceTests {

    @Autowired
    private IUserService iUserService;

    @Test
    public void add(){
        User user = new User();
        user.setUsername("klaxon");
        user.setPassword("klaxon");
        user.setGender(1);
//        user.setBirthday(new Date());
        user.setCreateTime(LocalDateTime.now());
        user.setUserNature(0);
        user.setUpdater("klaxon");
        user.setUpdateTime(LocalDateTime.now());
        iUserService.save(user);
    }

}