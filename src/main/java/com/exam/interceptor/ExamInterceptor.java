package com.exam.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.exam.entity.Users;


public class ExamInterceptor implements HandlerInterceptor {

    //拦截前处理
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //获取Session 如果为空拦截
        Users user = (Users) httpServletRequest.getSession().getAttribute("myUser");
        //判断是否为空
        if (user!=null) {
        	return true;
		}

        httpServletResponse.sendRedirect("/login.html");
        return false;
    }

    //拦截后处理
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    //全部完成后处理
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion");
    }
}
