package com.atguigu.crowd.service.impl;

import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.entity.AdminExample;
import com.atguigu.crowd.exception.LoginFailedException;
import com.atguigu.crowd.mappper.AdminMapper;
import com.atguigu.crowd.service.api.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin getAdminByLoginAcct(Admin admin) {
        AdminExample adminExample=new AdminExample();
        // 创建criteria对象
        AdminExample.Criteria criteria = adminExample.createCriteria();
        // 添加查询条件
        criteria.andLoginAcctEqualTo(admin.getLoginAcct());
        // 执行查询
        List<Admin> list = adminMapper.selectByExample(adminExample);
        // 如果查询结果为空，就抛出异常
        if (list==null || list.size()==0){
            throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }

        return null;
    }
}
