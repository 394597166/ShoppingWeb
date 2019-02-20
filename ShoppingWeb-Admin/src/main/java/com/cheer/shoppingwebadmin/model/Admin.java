package com.cheer.shoppingwebadmin.model;

/**
 * 管理员表
 */
public class Admin {
//    管理员编号
    private Integer adminId;
//    管理员用户名
    private String adminName;
//    管理员用户密码
    private String adminPassword;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Admin{");
        sb.append("adminId=").append(adminId);
        sb.append(", adminName='").append(adminName).append('\'');
        sb.append(", adminPassword='").append(adminPassword).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}
