package com.yhr.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {   //拦截器接口

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录成功后，应该有用户的Session
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser==null){//没有Session
            request.setAttribute("msg","没有权限，先登录");
            request.getRequestDispatcher("/login.html").forward(request,response);
            return false;
        }
        return true;
    }
}
