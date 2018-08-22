package com.codeya.springboot.testyml;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by codeya on 2018/7/31.
 * 1.为能力开放平台的管理者视图功能提供免登陆功能。。
 * 外系统需要免登陆访问能力开放平台时，需要将这些参数传入：1.需要登录的用户登录名staffCode，对应登录名字段 2.外系统标示，比如RESGIS 3.时间戳time  4.token，token的生成规则为 MD5(key+ staffCode +time)
 * 其中key 是能力开放平台与外系统协商好的。。比如RESGIS的key为 res_gis
 * 外系统对应的key可能会定期换，请将外系统标示 与 key的关系存放在配置文件里
 */
@Slf4j
public class TokenFilter implements Filter {

    @Autowired
    OuterLoginProperties properties;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession( );

        if (isLogin(session))
            gotoNextFilter(servletRequest, servletResponse, filterChain);
        else {//未登录
            String token = request.getParameter("token");
            String staffCode = request.getParameter("staffCode");
            String ask_source = request.getParameter("ask_source");//请求来源
            String time = request.getParameter("time");//时间戳
            String uuid = request.getParameter("uuid");
            if (isParamExist(token, staffCode, ask_source, time, uuid)) {//这些参数都存在
                String key = getKey_by_askSource(ask_source);
                if(!isExist(key)) {
                    log.error("未找到对应的key，ask_source={}", ask_source);
                    gotoNextFilter(servletRequest, servletResponse, filterChain);
                    return;
                }

                String rawPass = key + staffCode + time;//需要被MD5加密的参数
               /* PasswordEncoder passwordEncoder = new Md5PasswordEncoder( );
                if (passwordEncoder.isPasswordValid(token, rawPass, null)) {//token验证通过，进行免登陆
                   innerLogin_without_password(staffCode);
                }*/
            }else{//参数不存在，就继续原来的操作，需要鉴权的后面拦截器会做提示。。
                gotoNextFilter(servletRequest, servletResponse, filterChain);
            }

        }
    }

    private void innerLogin_without_password(String staffCode) {
    }

    private void gotoNextFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private boolean isParamExist(String token, String staffCode, String ask_source, String time, String uuid) {
        return isExist(token) && isExist(staffCode) && isExist(ask_source) && isExist(time) && isExist(uuid);
    }

    private boolean isLogin(HttpSession session) {
        //if (session == null || null == session.getAttribute(ManaAuth.SESSION_KEY) || null == session.getAttribute(AuthInfo.SK_USER_INFO))
            return false;
       // return true;
    }

    private boolean isExist(String token) {
        return StringUtils.hasText(token);
    }

    private String getKey_by_askSource(String ask_source) {
        if(properties.getAsk_resouces()!=null)
            return properties.getAsk_resouces().get(ask_source);
        return null;
    }

    @Override
    public void destroy() {

    }
}
