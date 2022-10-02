package com.springboot.resolver;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @Description: 自定义语言环境解析器
 */
// @Component("localeResolver")// 也可以直接这样注册到容器中
public class CustomLocalResolver implements LocaleResolver {
    /**
     * 解析请求中的语言环境
     *
     * @param request
     * @return
     */
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        // 获取请求中参数
        String l = request.getParameter("locale");
        // 获取默认的语言环境，一般是主机的语言环境
        Locale locale = Locale.getDefault();
        // 根据请求中的参数重新构造区域信息对象
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
