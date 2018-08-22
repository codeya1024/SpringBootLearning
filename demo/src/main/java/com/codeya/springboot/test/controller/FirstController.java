package com.codeya.springboot.test.controller;

import com.codeya.springboot.util.RequestUtil;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;

/**
 * Created by codeya on 2017/12/5.
 */
@RestController
@PropertySource("classpath:conf/test.yml")
@Slf4j
public class FirstController {

    @Value("${server.port}")
    String port;
    @Value("${test.properties1}")
    private String properties1;
    @Value("${test.properties2}")
    private Integer properties2;
    @Value("${haha}")
    private String haha;

    @RequestMapping("/hello")
    //@CrossOrigin 使用jsonp则无需此标示
    Object hello() {
        String result = "hello,i'm spring boot,server.port=" + port + ";sessionId=" + RequestUtil.getSessionId( );
        log.info("hello,result={}", result);

        //打印cookie信息，以确认cookie是否传递过来
        Cookie[] cookies = RequestUtil.getRequest( ).getCookies( );
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie :
                    cookies) {
                log.info("cookie,key={},value={}", cookie.getName( ), cookie.getValue( ));
            }
        }

        //判断是否是jsonp请求（此处的jsonpCallback与ajax中jsonp的值对应），如果是jsonp的，则需要返回jsonp(result)
        String jsonpCallback = RequestUtil.getRequest( ).getParameter("jsonpCallback");

        if (StringUtils.isEmpty(jsonpCallback))
            return result;
        else
            return new JSONPObject(jsonpCallback, result);
    }

    @RequestMapping("/helloCross")
    @CrossOrigin//不是用jsonp技术时，跨域访问需要增加此标示
    Object helloCross() {
        return hello();
    }

    @RequestMapping("/getProperties")
    String get_value_from_config_file() {
        return "properties1=[" + properties1 + "],properties2=[{" + properties2 + "}]";
    }

    String haha() {
        return "haha=[" + haha + "]";
    }

    @PostMapping("/testparam")
    public String refreshRoute(@RequestParam("param") String param) {
        return "param=" + param;
    }
}
