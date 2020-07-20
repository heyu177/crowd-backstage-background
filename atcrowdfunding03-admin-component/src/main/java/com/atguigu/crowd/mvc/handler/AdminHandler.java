package com.atguigu.crowd.mvc.handler;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.service.api.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin")
public class AdminHandler {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/do/login")
    public String doLogin(@RequestParam("loginAcct") String loginAcct, @RequestParam("userPswd") String userPswd, HttpSession session){
        // 如果账号密码不正确，getAdminByLoginAcct就会抛出异常
        Admin admin = adminService.getAdminByLoginAcct(loginAcct,userPswd);
        session.setAttribute("loginAdmin",admin);
        return "success";
    }
}
