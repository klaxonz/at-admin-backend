package com.mobby.attendance.controller;

import com.mobby.attendance.AttendanceApplicationTests;
import com.mobby.attendance.entity.User;
import com.mobby.attendance.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hulu
 * @ClassName UserControllerTest.java
 * @Description
 * @createTime 2020年04月10日 17:25:00
 */

@AutoConfigureMockMvc
public class UserControllerTest extends AttendanceApplicationTests {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private IUserService iUserService;


    @Before
    public void init(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void add() {

        User user = new User();
        user.setUsername("klaxon");
        user.setPassword("klaxon");
        user.setGender(1);
//        user.setBirthday(new Date());
        user.setUserNature(0);

    }
}