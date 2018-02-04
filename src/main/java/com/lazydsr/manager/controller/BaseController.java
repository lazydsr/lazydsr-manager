package com.lazydsr.manager.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * BaseController
 * PROJECT_NAME: lazydsr-application
 * PACKAGE_NAME: com.lazydsr.manager.controller
 * Created by Lazy on 2018/1/4 13:10
 * Version: 0.1
 * Info: @TODO:...
 */
@Controller
public class BaseController implements ErrorController {
    @RequestMapping({"/", "/index"})
    public ModelAndView index(ModelAndView modelAndView) {

        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("/login")
    public String login(String s,Model model) {

        model.addAttribute("hello", "1111111111");
        if ("1".equals(s)){
            model.addAttribute("index","hello");
        }
        return "login";
    }

    @RequestMapping("/logout")
    public String logout() {
        return "logout";
    }

    @RequestMapping("/error")
    public String error() {
        return "404";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
