package com.codeya.springboot.health;

/**
 * Created by codeya on 2018/8/31.
 */
public class TestNetState {
    public static void main(String []args){
        NetStateUtil netStateUtil=new NetStateUtil();
        String url1="http://127.0.0.1:8080";//测试https
        String url2="http://baidu.com";//测试http
        String url3="127.0.0.1";//测试普通ip
        System.out.println(url1+":"+netStateUtil.connectingAddress(url1));
        System.out.println(url2+":"+netStateUtil.connectingAddress(url2));
        System.out.println(url3+":"+netStateUtil.connectingAddress(url3));
    }
}
