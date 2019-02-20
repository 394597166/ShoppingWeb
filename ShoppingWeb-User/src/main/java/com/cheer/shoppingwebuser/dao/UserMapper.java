package com.cheer.shoppingwebuser.dao;

import com.cheer.shoppingwebuser.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * 插入账号信息
     * @param user
     */
    void insertUser(User user);

    /**
     * 更改用户信息
     * @param userId
     * @param userEmail
     * @param userPasswor
     */
    void updateUser(@Param("userId") Integer userId, @Param("userEmail") String userEmail, @Param("userPassword") String userPasswor, @Param("userSex") String userSex, @Param("userAge") Integer userAge);

    /**
     * 检查用户
     * @param userName
     * @param userEmail
     * @param userPassword
     * @return
     */
    User checkUser(@Param("userName") String userName, @Param("userEmail") String userEmail, @Param("userPassword") String userPassword);

    /**
     * 更改会员等级
     * @param userVip
     */
    void updateUserVip(@Param("userVip") Integer userVip,@Param("userId") Integer userId);
}
