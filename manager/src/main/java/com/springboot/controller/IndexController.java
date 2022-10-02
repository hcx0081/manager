package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 */
@Controller
public class IndexController {
    @RequestMapping({"/", "/index.html"})
    public String index() {
        return "index";
    }
}
