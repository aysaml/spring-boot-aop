package com.jd.tms.common.controller;

import com.jd.tms.common.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jd.tms.common.web.JsonResult;


import javax.annotation.Resource;


/**
 * 实现管理系统功能的登录注册功能
 *
 * @author wangning113
 * @since 2017/12/9
 */
@Controller
public class UserController {

    @Resource
    private LoginService loginService;

    @RequestMapping("/login")
    @ResponseBody
    public JsonResult login(String name, String password) {

        return new JsonResult(loginService.checkLogin(name, password));
    }

    @RequestMapping("/regist")
    @ResponseBody
    public JsonResult regist(String name, String password) {
        return new JsonResult(loginService.regist(name, password));
    }

    @RequestMapping("/updateUser")
    @ResponseBody
    public JsonResult update(String name, String password) {
        loginService.update(name, password);
        return new JsonResult();
    }

}
