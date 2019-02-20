package com.cheer.shoppingweborder.service.impl;

import com.cheer.shoppingweborder.dao.UserorderMapper;
import com.cheer.shoppingweborder.model.Userorder;
import com.cheer.shoppingweborder.service.UserorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
 * 业务处理
 * @author Lean
 */
@Service
public class UserorderServiceImpl implements UserorderService {
    //依赖注入
    @Autowired
    private UserorderMapper userorderMapper;

    @Override
    public List<Userorder> selectUserorderAndIdAndState(Integer userId,  String userorderState){
        return this.userorderMapper.selectUserorderAndIdAndState(userId,userorderState);
    }

    @Override
    public List<Userorder> selectUserorderAndId(Integer userId){
        return this.userorderMapper.selectUserorderAndId(userId);
    }

    @Override
    public Userorder selectUserorderAnduserorderId(Integer userorderId){
        return this.userorderMapper.selectUserorderAnduserorderId(userorderId);
    }

    @Override
    public void insertUserorder(Integer userorderId,String addressAlias,String addressName,String addressDistrict,String addressDetailed,String addressPhone,Integer userorderCount,Double userorderPrice,String userorderState,String userorderTime,Integer userCouponId,Integer couponSubtract,Integer userId){
        this.userorderMapper.insertUserorder(userorderId,addressAlias,addressName,addressDistrict,addressDetailed,addressPhone,userorderCount,userorderPrice,userorderState,userorderTime,userCouponId,couponSubtract,userId);
    }

    @Override
    public void insertUserorderpayTime(Integer userorderId,String payTime){
        this.userorderMapper.insertUserorderpayTime(userorderId,payTime);
    }

    @Override
    public void updateUserorder(Integer userorderId,String userorderState){
        this.userorderMapper.updateUserorder(userorderId,userorderState);
    }

    @Override
    public void insertUserordercouponId(Integer userorderId,Integer userCouponId){
        this.userorderMapper.insertUserordercouponId(userorderId,userCouponId);
    }

    @Override
    public void clearUserCoupon(Integer userorderId){
        this.userorderMapper.clearUserCoupon(userorderId);
    }

    @Override
    public List<Userorder> selectAllUserorderAndState( String userorderState){
        return this.userorderMapper.selectAllUserorderAndState(userorderState);
    }

    @Override
    public List<Userorder> selectAllUserorder(){
        return this.userorderMapper.selectAllUserorderAndState(null);
    }

}
