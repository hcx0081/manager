package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * {@code @Description:}
 */
@Controller
public class LoginController {
    
    @RequestMapping("/toDashboard")
    public String toDashboard() {
        return "dashboard";
    }
    
    @RequestMapping("/login")
    public String login(String name, String password, Model model, HttpSession session) {
        if (StringUtils.hasLength(name) && "123".equals(password)) {
            session.setAttribute("name", name);
            return "redirect:toDashboard";
        }
        model.addAttribute("msg", "用户名或密码错误！");
        return "index.html";
    }
    
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("name");
        return "index.html";
    }
}