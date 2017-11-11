package com.tmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by OovEver on 2017/11/11.
 */
//做服务端跳转
@Controller
@RequestMapping("")
public class PageController {
    @RequestMapping("registerPage")
    public String registerPage() {
        return "fore/register";
    }
    @RequestMapping("registerSuccessPage")
    public String registerSuccessPage() {
        return "fore/registerSuccess";
    }
    @RequestMapping("loginPage")
    public String loginPage() {
        return "fore/login";
    }
    @RequestMapping("forealipay")
    public String alipay(){
        return "fore/alipay";
    }
}

