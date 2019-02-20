package com.cheer.shoppingwebcoupon.service.impl;

import com.cheer.shoppingwebcoupon.dao.CouponMapper;
import com.cheer.shoppingwebcoupon.model.Coupon;
import com.cheer.shoppingwebcoupon.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * 业务处理
 * @author Lean
 */
@Service
public class CouponServiceImpl implements CouponService {
    //依赖注入
    @Autowired
    private CouponMapper couponMapper;

    @Override
    public void insertCoupon( Integer couponId,  Integer couponFull,  Integer couponSubtract,  String couponStart,  String couponFinish){
        this.couponMapper.insertCoupon(couponId,couponFull,couponSubtract,couponStart,couponFinish);
    }

    @Override
    public List<Coupon> selectAllCoupon(String couponFinish){
        return this.couponMapper.selectAllCoupon(couponFinish);
    }

    @Override
    public Coupon selectCoupon( Integer couponId){
        return this.couponMapper.selectCoupon(couponId);
    }

}
