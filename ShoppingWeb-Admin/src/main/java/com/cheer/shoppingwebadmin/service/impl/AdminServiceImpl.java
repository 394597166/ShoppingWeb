package com.cheer.shoppingwebadmin.service.impl;

import com.cheer.shoppingwebadmin.dao.AdminMapper;
import com.cheer.shoppingwebadmin.model.Admin;
import com.cheer.shoppingwebadmin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 业务处理
 * @author Lean
 */
@Service
public class AdminServiceImpl implements AdminService {
    //依赖注入
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin checkAdmin(String adminName, String adminPassword){
        return this.adminMapper.checkAdmin(adminName,adminPassword);
    }
}
