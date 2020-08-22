package com.atguigu.crowd.mvc.handler;

import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.service.api.AdminService;
import com.atguigu.crowd.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResultEntity<Object> doLogin(@RequestParam("loginAcct") String loginAcct, @RequestParam("userPswd") String userPswd, HttpSession session){
        // 如果账号密码不正确，getAdminByLoginAcct就会抛出异常
        Admin admin = adminService.getAdminByLoginAcct(loginAcct,userPswd);
        session.setAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN,admin);
        return ResultEntity.successWithoutData();
    }

    @RequestMapping("/getAdminName")
    public ResultEntity getAdminName(HttpSession session){
        Admin admin= (Admin) session.getAttribute("loginAdmin");
        return ResultEntity.successWithData(admin.getUserName());
    }

    @RequestMapping("/do/logout")
    public ResultEntity<Object> doLogout(HttpSession session){
        session.invalidate();
        return ResultEntity.successWithoutData();
    }
}
