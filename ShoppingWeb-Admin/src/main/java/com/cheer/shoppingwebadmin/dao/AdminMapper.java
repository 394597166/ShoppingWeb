package com.cheer.shoppingwebadmin.dao;

import com.cheer.shoppingwebadmin.model.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {

    /**
     * 检查账号
     * @param adminName
     * @param adminPassword
     * @return
     */
    Admin checkAdmin(@Param("adminName") String adminName, @Param("adminPassword") String adminPassword);
}
