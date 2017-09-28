package com.szl.quartzx.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor{
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        Object user = request.getSession().getAttribute("user_session_key");
        String requestType = request.getHeader("X-Requested-With");//识别ajax的响应头
        System.out.println("requestType===="+requestType);
        System.out.println("url===="+request.getRequestURI());
        if(user ==null){
            if (requestType != null && requestType.equals("XMLHttpRequest")) {//如果是ajax类型，响应logout给前台
                response.getWriter().print("logout");
            }else{
                response.sendRedirect("/login.html");
            }
            return false;
        }
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
