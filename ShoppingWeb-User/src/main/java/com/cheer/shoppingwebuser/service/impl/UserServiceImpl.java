package com.cheer.shoppingwebuser.service.impl;

import com.cheer.shoppingwebuser.dao.UserMapper;
import com.cheer.shoppingwebuser.model.User;
import com.cheer.shoppingwebuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 业务处理
 * @author Lean
 */
@Service
public class UserServiceImpl implements UserService {
    //依赖注入
    @Autowired
    private UserMapper userMapper;

    @Override
    public void insertUser(User user){
        this.userMapper.insertUser(user);
    }

    @Override
    public User checkUserName(String userName){
        return this.userMapper.checkUser(userName,null,null);
    }

    @Override
    public User checkEmail(String userEmail){
        return this.userMapper.checkUser(null,userEmail,null);
    }

    @Override
    public User checkMailUserName(String userName,String userEmail){
        return this.userMapper.checkUser(userName,userEmail,null);
    }

    @Override
    public void updatePassword(User user){
        this.userMapper.updateUser(user.getUserId(),null,user.getUserPassword(),null,null);
    }

    @Override
    public void updateCenter(User user){
        this.userMapper.updateUser(user.getUserId(),null,null,user.getUserSex(),user.getUserAge());
    }

    @Override
    public void updateMail(User user){
        this.userMapper.updateUser(user.getUserId(),user.getUserEmail(),null,null,null);
    }

    @Override
    public User loginUser(String userName,String userPassword){
        return this.userMapper.checkUser(userName,null,userPassword);
    }

    @Override
    public void updateUserVip( Integer userVip,Integer userId){
        this.userMapper.updateUserVip(userVip,userId);
    }
}
