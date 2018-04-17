package com.codeya.springboot.testjdbc.service;

import com.codeya.springboot.main.DemoApplication;
import com.codeya.springboot.main.DemoApplicationTests;
import com.codeya.springboot.testjdbc.entity.Staff;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by codeya on 2017/12/6.
 */
/*@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)*/
public class StaffServiceTest extends DemoApplicationTests{
    @Autowired
    StaffService service;

    @Test
    public void findOne_by_jdbctemplate() throws Exception {
        Staff staff = service.findOne_by_jdbctemplate("11");
        System.out.println("---------------findOne_by_jdbctemplate"+staff.toString());
    }

    @Test
    public void findOne_by_mybatis() throws Exception {
        Staff staff = service.findOne_by_mybatis("11");
        System.out.println("---------------findOne_by_mybatis"+staff.toString());
    }

}