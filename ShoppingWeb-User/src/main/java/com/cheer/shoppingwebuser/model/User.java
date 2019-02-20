package com.cheer.shoppingwebuser.model;

import com.cheer.shoppingwebaddress.model.Address;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

//解决json序列化问题（对象中存在其他对象时需要）
@JsonIgnoreProperties(value = { "handler" })
/**
 * 用户表
 */
public class User {
//    用户编号
    private Integer userId;
//    用户名
    private String userName;
//    用户密码
    private String userPassword;
//    用户性别
    private String userSex;
//    用户邮箱
    private String userEmail;
//    用户状态
    private String userState;
//    用户VIP等级
    private Integer userVip;
//    用户年龄
    private Integer userAge;
//    收货地址
    private List<Address> addressList;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("userId=").append(userId);
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", userPassword='").append(userPassword).append('\'');
        sb.append(", userSex='").append(userSex).append('\'');
        sb.append(", userEmail='").append(userEmail).append('\'');
        sb.append(", userState='").append(userState).append('\'');
        sb.append(", userVip=").append(userVip);
        sb.append(", userAge=").append(userAge);
        sb.append(", addressList=").append(addressList);
        sb.append('}');
        return sb.toString();
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    public Integer getUserVip() {
        return userVip;
    }

    public void setUserVip(Integer userVip) {
        this.userVip = userVip;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }
}
