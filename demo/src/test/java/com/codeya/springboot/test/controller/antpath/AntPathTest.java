package com.codeya.springboot.test.controller.antpath;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.util.UrlPathHelper;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

/**
 * Created by codeya on 2018/3/20.
 */
@RunWith(JUnit4.class)
public class AntPathTest {

    private UrlPathHelper urlPathHelper = new UrlPathHelper();
    private PathMatcher pathMatcher = new AntPathMatcher();
    protected  PathMatcher getPathMatcher(){
        return pathMatcher;
    }
    private UrlPathHelper getUrlPathHelper() {
        return urlPathHelper;
    }

    @Test
    public void pathMatch(){
        String pattern="/resweb/{version}/user/{id}";
        String pattern2="/resweb/1.0/user/{id}";
        String url_1="/resweb/1.0/user/000111";
        String url_2="/resweb//1.0/user/000111";
        String url_3="/resweb/user/000111";
        Assert.assertTrue(getPathMatcher().match(pattern,url_1));
        Assert.assertTrue(getPathMatcher().match(pattern2,url_1));
        Assert.assertTrue(getPathMatcher().match(pattern,url_2));
        Assert.assertFalse(getPathMatcher().match(pattern,url_3));

    }

    @Test
    public void extractPathWithinPattern(){
        String pattern="/resweb/{version}/user/*";
        String url_1="/resweb/1.0/user/000111.html";
        String url_2="/resweb//1.0/user/000111";
        Assert.assertEquals("000111.html",getPathMatcher().extractPathWithinPattern(pattern,url_1));
        Assert.assertEquals("000111",getPathMatcher().extractPathWithinPattern(pattern,url_2));

    }

    @Test
    public void extractUriTemplateVariables(){
        String pattern="/resweb/{version}/user/{user}";
        String url_1="/resweb/1.0/user/000111";
        String url_2="/resweb//1.0/user/000111";
        try {
           System.out.println( URLEncoder.encode(pattern,"utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace( );
        }
        Map<String, String> vars = getPathMatcher().extractUriTemplateVariables(pattern, url_1);
        //Map<String, String> decodedVars = getUrlPathHelper().decodePathVariables(request, vars);
        System.out.println(vars);

        vars.clear();

    }

    @Test
    public void bestMatch() {

        List<String> patterns = new ArrayList<String>(3);

        String pattern1 = "/resweb/{version}/user/{user}";
        String pattern2 = "/resweb/1.0/user/{user}";
        String pattern3 = "/resweb/1.0/user/000111";
        String pattern4 = "/resweb/user/{user}";
        patterns.add(pattern1);
        patterns.add(pattern2);
        patterns.add(pattern3);
        patterns.add(pattern4);

        String url_1 = "/resweb/1.0/user/000111";
        String url_2 = "/resweb/user/000111";

        String urlPath = url_2;
        List<String> matchingPatterns = new ArrayList<String>();
        for (String pattern : patterns) {
            if (getPathMatcher().match(pattern, urlPath)) {
                matchingPatterns.add(pattern);
            }
        }
        System.out.println(matchingPatterns);
        Comparator<String> patternComparator = getPathMatcher().getPatternComparator(urlPath);
        if (!matchingPatterns.isEmpty()) {
            Collections.sort(matchingPatterns, patternComparator);
        }
        System.out.println(matchingPatterns);
    }

    }
