package com.cheer.shoppingweb.service;

import com.cheer.shoppingwebcoupon.service.impl.UsercouponServiceImpl;
import com.cheer.shoppingweborder.model.Userorder;
import com.cheer.shoppingweborder.service.impl.UserorderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService implements Runnable{
    private Integer userorderId ;

    @Autowired
    private UserorderServiceImpl userorderService;
    @Autowired
    private UsercouponServiceImpl usercouponService;

    public Integer getUserorderId() {
        return userorderId;
    }

    public void setUserorderId(Integer userorderId) {
        this.userorderId = userorderId;
    }

    @Override
    public void run() {
        Userorder userorder = this.userorderService.selectUserorderAnduserorderId(userorderId);
        System.out.println(userorder);
        this.userorderService.updateUserorder(userorderId,"已取消");
        if (null != userorder.getUserCouponId()){
            this.usercouponService.updateUsercoupon(userorder.getUserCouponId(),"可用");
            this.userorderService.clearUserCoupon(userorderId);
        }
    }
}
