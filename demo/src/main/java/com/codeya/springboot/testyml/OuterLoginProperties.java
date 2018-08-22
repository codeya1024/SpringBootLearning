package com.codeya.springboot.testyml;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by codeya on 2018/7/31.
 */
@Component
@ConfigurationProperties(prefix="outer.login")
@Data
public class OuterLoginProperties {
    private Map<String,String> ask_resouces;
    private String description;

}
