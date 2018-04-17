package com.codeya.springboot.test.controller;

import com.codeya.springboot.main.DemoApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import static org.junit.Assert.*;

/**
 * Created by codeya on 2017/12/6.
 */
public class FirstControllerTest extends DemoApplicationTests {
    @Autowired
    FirstController controller;

    @Test
    public void get_value_from_config_file() throws Exception {
       System.out.println(controller.get_value_from_config_file());;
    }


    @Test
    public void haha() throws Exception {
        System.out.println(controller.haha());;
    }
}