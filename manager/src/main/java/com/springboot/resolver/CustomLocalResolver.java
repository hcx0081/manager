package com.springboot.resolver;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * {@code @Description:} 自定义区域环境解析器
 */
// @Component("localeResolver")// 也可以这样直接注册到SpringBoot容器中
public class CustomLocalResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        // 获取请求参数
        String l = request.getParameter("locale");
        // 获取默认的区域环境，一般是主机的区域环境
        Locale locale = Locale.getDefault();
        // 根据请求中的参数重新创建区域环境对象
        if (StringUtils.hasText(l)) {
            String[] s = l.split("_");
            // 语言、国家
            locale = new Locale(s[0], s[1]);
        }
        return locale;
    }
    
    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
    
    }
}