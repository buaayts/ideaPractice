package com.heitian.ssm.controller;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yetaoshan on 17/8/30.
 * 对拦截器应用。
 比如：统一日志处理拦截器，需要该拦截器preHandle一定要放行，且将它放在拦截器链接中第一个位置。
 比如：登陆认证拦截器，放在拦截器链接中第一个位置（在日志之后）。权限校验拦截器，放在登陆认证拦截器之后。（因为登陆通过后才校验权限）
 */
//测试拦截器1
public class HandlerInterceptor1 implements HandlerInterceptor {


    //执行Handler方法之前执行
    //用于身份认证、身份授权
    //比如身份认证，如果认证通过表示当前用户没有登陆，需要此方法拦截不再向下执行
//    两个拦截器都放行：preHandle方法按顺序执行，postHandle和afterCompletion按拦截器配置的逆向顺序执行。
//    拦截器1放行，拦截器2不放行：拦截器2 preHandle不放行，拦截器2 postHandle和afterCompletion不会执行。
//                          只要有一个拦截器不放行，postHandle不会执行。
//    结果为 HandlerInterceptor1...preHandle
//          HandlerInterceptor2...preHandle
//          HandlerInterceptor1...afterCompletion

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {

        System.out.println("HandlerInterceptor1......preHandle");
        System.out.println();
        System.out.println("master");

        //return false表示拦截，不向下执行
        //return true表示放行
        return false;
    }

    //进入Handler方法之后，返回modelAndView之前执行
    //应用场景从modelAndView出发：将公用的模型数据(比如菜单导航)在这里
    //传到视图，也可以在这里统一指定视图
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("HandlerInterceptor1......postHandle");

    }

    //执行Handler完成执行此方法
    //应用场景：统一异常处理，统一日志处理
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex)
            throws Exception {

        System.out.println("HandlerInterceptor1......afterHandle");

    }
}
