package com.cheer.shoppingwebuser.service;

import com.cheer.shoppingwebuser.model.User;

public interface UserService {
    /**
     *  存储用户
     * @param user
     * @return
     */
    void insertUser(User user);

    /**
     * 查询是否存在该用户名
     * @param userName
     * @return
     */
    User checkUserName(String userName);

    /**
     * 查询是否存在该邮箱
     * @param userEmail
     * @return
     */
    User checkEmail(String userEmail);

    /**
     * 查询是否存在该用户名和邮箱
     * @param userName
     * @return
     */
    User checkMailUserName(String userName,String userEmail);

    /**
     * 更改密码
     * @param user
     * @return
     */
    void updatePassword(User user);

    /**
     * 更改信息
     * @param user
     * @return
     */
    void updateCenter(User user);

    /**
     * 更改邮箱
     * @param user
     * @return
     */
    void updateMail(User user);

    /**
     * 用户登录
     * @param userName
     * @param userPassword
     * @return
     */
    User loginUser(String userName,String userPassword);

    /**
     * 更改会员等级
     * @param userVip
     */
    void updateUserVip( Integer userVip,Integer userId);
}
