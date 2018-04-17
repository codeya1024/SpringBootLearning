package com.codeya.springboot.main;

import com.codeya.springboot.testjdbc.entity.Staff;
import com.codeya.springboot.testjdbc.service.StaffService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {

    /*@Test
    public void contextLoads() {
    }*/
    @Autowired
    StaffService service;

    @Test
    public void findOne_by_jdbctemplate() throws Exception {
        Staff staff = service.findOne_by_jdbctemplate("11");
        System.out.println("---------------findOne_by_jdbctemplate" + staff.toString());
    }

    @Test
    @Ignore
    public void findOne_by_mybatis() throws Exception {
        Staff staff = service.findOne_by_mybatis("11");
        System.out.println("---------------findOne_by_mybatis" + staff.toString());
    }

}
