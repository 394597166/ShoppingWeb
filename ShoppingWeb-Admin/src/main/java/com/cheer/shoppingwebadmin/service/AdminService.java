package com.cheer.shoppingwebadmin.service;

import com.cheer.shoppingwebadmin.model.Admin;

public interface AdminService {
    /**
     * 管理员登录登录
     * @param adminName
     * @param adminPassword
     * @return
     */
    Admin checkAdmin(String adminName, String adminPassword);
}
