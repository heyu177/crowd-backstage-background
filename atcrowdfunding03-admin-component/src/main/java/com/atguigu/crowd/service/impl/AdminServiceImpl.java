package com.atguigu.crowd.service.impl;

import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.entity.AdminExample;
import com.atguigu.crowd.exception.LoginFailedException;
import com.atguigu.crowd.mapper.AdminMapper;
import com.atguigu.crowd.service.api.AdminService;
import com.atguigu.crowd.util.CrowdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin getAdminByLoginAcct(String loginAcct,String userPswd) {
        AdminExample adminExample=new AdminExample();
        // 创建criteria对象
        AdminExample.Criteria criteria = adminExample.createCriteria();
        // 添加查询条件
        criteria.andLoginAcctEqualTo(loginAcct);
        // 执行查询
        List<Admin> list = adminMapper.selectByExample(adminExample);
        // 如果查询结果为空，就抛出异常
        if (list==null || list.size()==0){
            throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }
        // 如果查询结果大于1，就抛出异常
        if (list.size()>1){
            throw new RuntimeException(CrowdConstant.MESSAGE_SYSTEM_ERROR_LOGIN_NOT_UNIQUE);
        }
        Admin admin=list.get(0);
        if (admin==null){
            throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }
        // 得到数据库保存的密码
        String userPswdDB = admin.getUserPswd();
        // 将表单提交的密码进行加密
        String userPaswdForm = CrowdUtil.md5(userPswd);
        // 如果密码不相等，就抛出异常
        if (!Objects.equals(userPswdDB,userPaswdForm)){
            throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }
        return admin;
    }
}
