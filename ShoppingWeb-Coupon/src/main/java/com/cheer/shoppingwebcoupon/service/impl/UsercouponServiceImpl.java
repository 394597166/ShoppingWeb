package com.cheer.shoppingwebcoupon.service.impl;

import com.cheer.shoppingwebcoupon.dao.UsercouponMapper;
import com.cheer.shoppingwebcoupon.model.Usercoupon;
import com.cheer.shoppingwebcoupon.service.UsercouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * 业务处理
 * @author Lean
 */
@Service
public class UsercouponServiceImpl implements UsercouponService {
    //依赖注入
    @Autowired
    private UsercouponMapper usercouponMapper;

    @Override
    public Integer insertUsercoupon(Integer userCouponId,  Integer couponId,  Integer userId, String userCouponState){
    return this.usercouponMapper.insertUsercoupon(userCouponId,couponId,userId,userCouponState);
    }

    @Override
    public List<Usercoupon> selectAllUsercoupon( Integer userId){
        return this.usercouponMapper.selectAllUsercoupon(userId);
    }

    @Override
    public List<Usercoupon> selectUsercouponAndState( Integer userId, String userCouponState){
        return this.usercouponMapper.selectUsercouponAndState(userId,userCouponState);
    }

    @Override
    public void updateUsercoupon(Integer userCouponId,String userCouponState){
        this.usercouponMapper.updateUsercoupon(userCouponId,userCouponState);
    }

}
