package com.cheer.shoppingweb.controller;


import com.cheer.shoppingweb.service.UtilService;
import com.cheer.shoppingwebcoupon.model.Coupon;
import com.cheer.shoppingwebcoupon.model.Usercoupon;
import com.cheer.shoppingwebcoupon.service.CouponService;
import com.cheer.shoppingwebcoupon.service.UsercouponService;
import com.cheer.shoppingwebuser.model.User;
import com.cheer.shoppingwebuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class CouponController {
    @Autowired
    private UserService userService;
    @Autowired
    private UsercouponService usercouponService;
    @Autowired
    private CouponService couponService;
    @Autowired
    private UtilService utilService;
    /**
     * 打开优惠券页面
     * @return
     */
    @RequestMapping(value = "/userCoupon.html")
    public String userCoupon(){
        return "userCoupon";
    }

    /**
     * 打开领取优惠券页面
     * @return
     */
    @RequestMapping(value = "/receiveCoupon.html")
    public String receiveCoupon(){
        return "receiveCoupon";
    }

    /**
     * 获得优惠券数据
     */
    @RequestMapping(value = "/selectAllUserCoupon")
    @ResponseBody
    public Map<String,Object> selectAllUserCoupon(HttpSession session){
        //获取用户名
        String userName = (String) session.getAttribute("username");
        //检查是否登录
        Map<String,Object> map = this.utilService.checkUserName(userName);
        Boolean flog = (Boolean) map.get("result");
        //已登录
        if (flog){
            User user = this.userService.checkUserName(userName);
            List<Usercoupon> usercouponList = this.usercouponService.selectUsercouponAndState(user.getUserId(),"可用");
            Iterator<Usercoupon> usercouponIterator = usercouponList.iterator();
            //获得当前时间
            Calendar c = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
            String data = dateFormat.format(c.getTime());
            while (usercouponIterator.hasNext()){
                Usercoupon usercoupon = usercouponIterator.next();
                //如果可用优惠券已过期，则更改优惠券的状态
                if (usercoupon.getCoupon().getCouponFinish().compareTo(data) == -1){
                    this.usercouponService.updateUsercoupon(usercoupon.getUserCouponId(),"过期");
                }
            }
            List<Usercoupon> usable = this.usercouponService.selectUsercouponAndState(user.getUserId(),"可用");
            List<Usercoupon> used = this.usercouponService.selectUsercouponAndState(user.getUserId(),"已用");
            List<Usercoupon> overdue = this.usercouponService.selectUsercouponAndState(user.getUserId(),"过期");
            List<Usercoupon> trash = this.usercouponService.selectUsercouponAndState(user.getUserId(),"回收站");
            map.put("usable",usable);
            map.put("used",used);
            map.put("overdue",overdue);
            map.put("trash",trash);
        }
        return map;
    }

    /**
     * 更改优惠券状态
     * @param userCouponId
     * @param userCouponState
     * @param session
     * @return
     */
    @RequestMapping(value = "/updateUserCoupon")
    @ResponseBody
    public Map<String,Object> updateUserCoupon(@RequestParam(value = "userCouponId") Integer userCouponId,@RequestParam(value = "userCouponState") String userCouponState,HttpSession session){
        //获取用户名
        String userName = (String) session.getAttribute("username");
        //检查是否登录
        Map<String,Object> map = this.utilService.checkUserName(userName);
        Boolean flog = (Boolean) map.get("result");
        //已登录
        if (flog){
            this.usercouponService.updateUsercoupon(userCouponId,userCouponState);
            map.put("data","更新成功!");
        }
        return map;
    }

    /**
     * 获得领取优惠券数据
     */
    @RequestMapping(value = "/selectAllCoupon")
    @ResponseBody
    public Map<String,Object> selectAllCoupon(HttpSession session){
        //获取用户名
        String userName = (String) session.getAttribute("username");
        //检查是否登录
        Map<String,Object> map = this.utilService.checkUserName(userName);
        Boolean flog = (Boolean) map.get("result");
        //已登录
        if (flog){
            User user = this.userService.checkUserName(userName);
            List<Usercoupon> usercouponList = this.usercouponService.selectAllUsercoupon(user.getUserId());
            //获得当前时间
            Calendar c = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
            String data = dateFormat.format(c.getTime());
            List<Coupon> couponList = this.couponService.selectAllCoupon(data);
            //删除已领优惠券
            Iterator<Coupon> couponIterator = couponList.iterator();
            while (couponIterator.hasNext()){
                Coupon coupon = couponIterator.next();
                Iterator<Usercoupon> usercouponIterator = usercouponList.iterator();
                while (usercouponIterator.hasNext()){
                    Usercoupon usercoupon = usercouponIterator.next();
                    if (coupon.getCouponId().equals(usercoupon.getCoupon().getCouponId())){
                        couponIterator.remove();
                    }
                }
            }
            map.put("couponList",couponList);
        }
        return map;
    }


    /**
     * 领取优惠券
     */
    @RequestMapping(value = "/insertCoupon")
    @ResponseBody
    public Map<String,Object> insertCoupon(@RequestParam(value = "couponId") Integer couponId,HttpSession session){
        //获取用户名
        String userName = (String) session.getAttribute("username");
        //检查是否登录
        Map<String,Object> map = this.utilService.checkUserName(userName);
        Boolean flog = (Boolean) map.get("result");
        //已登录
        if (flog){
            User user = this.userService.checkUserName(userName);
            Integer userCouponId = this.utilService.UUID();
            this.usercouponService.insertUsercoupon(userCouponId,couponId,user.getUserId(),"可用");
            map.put("data","领取成功!");
        }
        return map;
    }
}
