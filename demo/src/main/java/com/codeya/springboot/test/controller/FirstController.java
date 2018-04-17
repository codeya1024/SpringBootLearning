package com.codeya.springboot.test.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by codeya on 2017/12/5.
 */
@RestController
@PropertySource("classpath:conf/test.yml")
public class FirstController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/hello")
    String hello(){
       return "hello,i'm spring boot,server.port="+port;
    }

    @Value("${test.properties1}")
    private String properties1;

    @Value("${test.properties2}")
    private Integer properties2;

    @RequestMapping("/getProperties")
    String get_value_from_config_file(){
        return "properties1=["+properties1+"],properties2=[{"+properties2+"}]";
    }

    @Value("${haha}")
    private String haha;
    String haha(){
        return "haha=["+haha+"]";
    }
}
