package com.springboot.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * {@code @Description:}
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object name = session.getAttribute("name");
        System.out.println(name);
        if (name != null) {
            System.out.println("执行拦截器----用户存在，放行");
            return true;
        }
        System.out.println("执行拦截器----用户不存在，不放行");
        request.setAttribute("msg", "请先登录");
        request.getRequestDispatcher("/index.html").forward(request, response);
        return false;
    }
}