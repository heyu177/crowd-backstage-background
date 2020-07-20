package com.atguigu.crowd.service.api;

import com.atguigu.crowd.entity.Admin;

public interface AdminService {

    public Admin getAdminByLoginAcct(String loginAcct,String userPswd);
}
