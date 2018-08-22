package com.codeya.springboot.testyml;

import com.codeya.springboot.main.DemoApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by codeya on 2018/7/31.
 */
@Slf4j
public class OuterLoginPropertiesTest extends DemoApplicationTests {
    @Autowired
    OuterLoginProperties properties;

    @Test
    public void testMapProperties(){
       log.info("OuterLoginProperties info:{}",properties.getAsk_resouces());
    }

}