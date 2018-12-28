/*
package com.itcast.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.DefaultServletHttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Method;

public class LoginInter implements HandlerInterceptor{
    */
/**
     * 拦截器：拦截的是controller中的方法
     * @param request
     * @param response
     * @param handler
     * @return  false:拦截不继续下一个拦截器或者执行controller方法    true:表示放过
     *//*

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if(handler instanceof DefaultServletHttpRequestHandler){
            return true;
        }
//        String path=request.getRequestURI();
////        String pathName=path.substring(path.lastIndexOf(".")+1);
////       // System.out.println(pathName);
////        if(pathName.equals("css")){
////            return true;
////        }
        //session是是否有值
        HttpSession session=request.getSession();
        if(session.getAttribute("user")==null){
            try {
                //request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request,response);
                response.sendRedirect("/ssm/index.jsp");
                return false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;

    }

//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
//
//    }
}
*/
