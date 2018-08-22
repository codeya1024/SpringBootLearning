package com.codeya.springboot.Encode;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by codeya on 2018/8/1.
 */
public class UrlEncode {

    public static void main(String args[]){
        String url="http://47.98.63.5:8018/#&provider_container";
        try {
            System.out.println(URLEncoder.encode(url,"utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace( );
        }


    }
}
