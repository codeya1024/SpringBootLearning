package com.codeya.springboot.util;

/**
 * Created by codeya on 2018/1/18.
 */
public class SessionUtil {
    /**
     * 把必要的信息设置到session里。。
     * @param name
     * @param value
     */
    public static void setSessionAttr(String name, Object value){
        RequestUtil.getRequest().getSession().setAttribute(name,value);
    }

    /**从session的属性里获取信息
     * @param name
     * @return
     */
    public static Object getSessionAttr(String name){
       return RequestUtil.getRequest().getSession().getAttribute(name);
    }

}
