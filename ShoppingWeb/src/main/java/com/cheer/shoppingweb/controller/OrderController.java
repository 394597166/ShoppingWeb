package com.cheer.shoppingweb.controller;


import com.cheer.shoppingweb.service.ScheduledService;
import com.cheer.shoppingweb.service.UtilService;
import com.cheer.shoppingwebbalance.model.Balance;
import com.cheer.shoppingwebbalance.service.BalanceItemService;
import com.cheer.shoppingwebbalance.service.BalanceService;
import com.cheer.shoppingwebcart.service.CartService;
import com.cheer.shoppingwebcoupon.model.Usercoupon;
import com.cheer.shoppingwebcoupon.service.UsercouponService;
import com.cheer.shoppingweborder.model.Userorder;
import com.cheer.shoppingweborder.model.Userorderitem;
import com.cheer.shoppingweborder.service.UserorderService;
import com.cheer.shoppingweborder.service.UserorderitemService;
import com.cheer.shoppingwebuser.model.User;
import com.cheer.shoppingwebuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.lang.String.valueOf;


@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private UserorderService userorderService;
    @Autowired
    private UserService userService;
    @Autowired
    private UsercouponService usercouponService;
    @Autowired
    private UserorderitemService userorderitemService;
    @Autowired
    private CartService cartService;
    @Autowired
    private BalanceService balanceService;
    @Autowired
    private BalanceItemService balanceItemService;
    @Autowired
    private ScheduledService scheduledService;
    @Autowired
    private UtilService utilService;

    public static ScheduledExecutorService service = Executors.newScheduledThreadPool(10);

    /**
     * 打开确认订单页面
     * @return
     */
    @RequestMapping(value = "/confirmOrder.html")
    public String confirmOrder(){
        return "confirmOrder";
    }

    /**
     * 打开支付页面
     * @return
     */
    @RequestMapping(value = "/userPay.html")
    public String userPay(){
        return "userPay";
    }

    /**
     * 打开支付页面
     * @return
     */
    @RequestMapping(value = "/order.html")
    public String order(){
        return "order";
    }

    /**
     * 提交数据到确认订单页面
     * @return
     */
    @RequestMapping(value = "/confirmorder")
    @ResponseBody
    public String confirmorder(@RequestParam(value = "data[]")String[] data, HttpSession session){
        //获取用户名
        String userName = (String) session.getAttribute("username");
        //检查是否登录
        Map<String,Object> map = this.utilService.checkUserName(userName);
        Boolean flog = (Boolean) map.get("result");
        //已登录
        if (flog){//已登录
            //获得订单对象
            Userorder userorder = new Userorder();
//            获得订单号
            Integer userorderId = this.utilService.UUID();
            userorder.setUserorderId(userorderId);
            //创建一个订单项目集合
            List<Userorderitem> userorderitemList = new ArrayList<>();
            //商品合计价格
            Double userorderPrice = 0.0;
            //商品合计数量
            Integer userorderCount = 0;
            for (String str:data
                 ) {
                //创建一个订单项目
                Userorderitem userorderitem = new Userorderitem();
                //购物车编号
                Integer cartId = Integer.valueOf(str.split(",")[0]);
                userorderitem.setCartId(cartId);
                //获得商品编号
                Integer goodsId = Integer.valueOf(str.split(",")[1]);
                userorderitem.setGoodsId(goodsId);
                //获得商品标签编号
                Integer inventoryId = Integer.valueOf(str.split(",")[2]);
                userorderitem.setInventoryId(inventoryId);
                //获得商品名
                String goodsName = valueOf(str.split(",")[3]);
                userorderitem.setGoodsName(goodsName);
                //获得商品标签名称
                String inventoryName = valueOf(str.split(",")[4]);
                userorderitem.setInventoryName(inventoryName);
                //获得商品数量
                Integer userorderitemCount = Integer.valueOf(str.split(",")[5]);
                userorderitem.setUserorderitemCount(userorderitemCount);
                //获得商品单价
                Double userorderitemPrice = Double.valueOf(str.split(",")[6]);
                userorderitem.setUserorderitemPrice(userorderitemPrice);
                userorderitemList.add(userorderitem);
                //获得合计价格
                userorderPrice += userorderitemCount * userorderitemPrice;
                //商品合计数量
                userorderCount += userorderitemCount;
            }
            userorder.setUserorderPrice(userorderPrice);
            userorder.setUserorderCount(userorderCount);
            userorder.setUserorderitemList(userorderitemList);
            //将数据加入到session中
            session.setAttribute("userorder",userorder);
            return "true";
        }else{//未登录
            return "false";
        }
    }


    /**
     * 提交数据到确认订单页面
     * @return
     */
    @RequestMapping(value = "/confirmorderone")
    @ResponseBody
    public String confirmorderone(@RequestParam(value = "data[]")String data, HttpSession session){
        //获得用户信息
        String userName = (String) session.getAttribute("username");
        if (null != userName){//已登录
            //获得订单对象
            Userorder userorder = new Userorder();
//            获得订单号
            Integer userorderId = this.utilService.UUID();
            userorder.setUserorderId(userorderId);
            //创建一个订单项目集合
            List<Userorderitem> userorderitemList = new ArrayList<>();
            //商品合计价格
            Double userorderPrice = 0.0;
            //商品合计数量
            Integer userorderCount = 0;
            //创建一个订单项目
            Userorderitem userorderitem = new Userorderitem();
            //获得购物车编号
            Integer cartId = Integer.valueOf(data.split(",")[0]);
            userorderitem.setCartId(cartId);
            //获得商品编号
            Integer goodsId = Integer.valueOf(data.split(",")[1]);
            userorderitem.setGoodsId(goodsId);
            //获得商品标签编号
            Integer inventoryId = Integer.valueOf(data.split(",")[2]);
            userorderitem.setInventoryId(inventoryId);
            //获得商品名
            String goodsName = valueOf(data.split(",")[3]);
            userorderitem.setGoodsName(goodsName);
            //获得商品标签编号

            //获得商品标签名称
            String inventoryName = valueOf(data.split(",")[4]);
            userorderitem.setInventoryName(inventoryName);
            //获得商品数量
            Integer userorderitemCount = Integer.valueOf(data.split(",")[5]);
            userorderitem.setUserorderitemCount(userorderitemCount);
            //获得商品单价
            Double userorderitemPrice = Double.valueOf(data.split(",")[6]);
            userorderitem.setUserorderitemPrice(userorderitemPrice);
            userorderitemList.add(userorderitem);
            //获得合计价格
            userorderPrice += userorderitemCount * userorderitemPrice;
            //商品合计数量
            userorderCount += userorderitemCount;
            userorder.setUserorderPrice(userorderPrice);
            userorder.setUserorderCount(userorderCount);
            userorder.setUserorderitemList(userorderitemList);
            //将数据加入到session中
            session.setAttribute("userorder",userorder);
            return "true";
        }else{//未登录
            return "false";
        }
    }

    /**
     * 提交数据到确认订单页面
     * @return
     */
    @RequestMapping(value = "/selectConfirmOrder")
    @ResponseBody
    public Map<String,Object> selectConfirmOrder(HttpSession session){
        //获取用户名
        String userName = (String) session.getAttribute("username");
        //检查是否登录
        Map<String,Object> map = this.utilService.checkUserName(userName);
        Boolean flog = (Boolean) map.get("result");
        //已登录
        if (flog){//已登录
            User user = this.userService.checkUserName(userName);
            Userorder userorder  = (Userorder) session.getAttribute("userorder");
            if (null != userorder){
                map.put("result2",true);
                map.put("userorder",userorder);
                map.put("user",user);
            }else{
                map.put("result2",false);
                map.put("data","请通过购物车转到订单确认页面！");
            }
        }
        return map;
    }

    /**
     * 返回购物车修改
     * @return
     */
    @RequestMapping(value = "/returnCart")
    @ResponseBody
    public Map<String,Object> returnCart(HttpSession session){
        //获取用户名
        String userName = (String) session.getAttribute("username");
        //检查是否登录
        Map<String,Object> map = this.utilService.checkUserName(userName);
        Boolean flog = (Boolean) map.get("result");
        //已登录
        if (flog){//已登录
            session.removeAttribute("userorder");
        }
        return map;
    }

    /**
     * 获得优惠券数据
     */
    @RequestMapping(value = "/yhj")
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
            map.put("usable",usable);
        }
        return map;
    }

    /**
     * 生成订单(单商品)
     */
    @RequestMapping(value = "/insertOrderoneitem")
    @ResponseBody
    public Map<String,Object> insertOrderoneitem(@RequestParam(value = "address")String address,@RequestParam(value = "data[]")String data,@RequestParam(value = "userorderId")Integer userorderId,@RequestParam(value = "userorderCount")Integer userorderCount,@RequestParam(value = "userorderPrice")Double userorderPrice,@RequestParam(value = "couponSubtract")Integer couponSubtract,@RequestParam(value = "userCouponId")Integer userCouponId,HttpSession session){
        //获取用户名
        String userName = (String) session.getAttribute("username");
        //检查是否登录
        Map<String,Object> map = this.utilService.checkUserName(userName);
        Boolean flog = (Boolean) map.get("result");
        //已登录
        if (flog){
            User user = this.userService.checkUserName(userName);
            Integer userId = user.getUserId();
            String userorderState = "待支付";
            //获得当前时间
            Calendar c = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
            String userorderTime = dateFormat.format(c.getTime());
            //获得地址
            String addressAlias = valueOf(address.split(",")[0]);
            String addressName = valueOf(address.split(",")[1]);
            String addressDistrict = valueOf(address.split(",")[2]);
            String addressDetailed = valueOf(address.split(",")[3]);
            String addressPhone = valueOf(address.split(",")[4]);
            //插入订单数据
            this.userorderService.insertUserorder(userorderId,addressAlias,addressName,addressDistrict,addressDetailed,addressPhone,userorderCount,userorderPrice,userorderState,userorderTime,null,couponSubtract,userId);
            //获得订单项目
            Integer userorderitemId = this.utilService.UUID();
            Integer goodsId = Integer.valueOf(data.split(",")[1]);
            String goodsName = valueOf(data.split(",")[2]);
            String inventoryName = valueOf(data.split(",")[3]);
            Double userorderitemPrice = Double.valueOf(data.split(",")[5]);
            Integer userorderitemCount =  Integer.valueOf(data.split(",")[4]);
            Integer inventoryId = Integer.valueOf(data.split(",")[6]);
            //插入订单项目数据
            this.userorderitemService.insertUserorderitem(userorderitemId,goodsId,goodsName,inventoryId,inventoryName,userorderitemPrice,userorderitemCount,userorderId);
            //删除购物车
            Integer cartId = Integer.valueOf(data.split(",")[0]);
            this.cartService.deleteCart(cartId);
            //使用优惠券
            if (null != userCouponId){
                this.usercouponService.updateUsercoupon(userCouponId,"已用");
                this.userorderService.insertUserordercouponId(userorderId,userCouponId);
            }
            //定时器（24小时）
            this.scheduledService.setUserorderId(userorderId);
            service.schedule(scheduledService,1, TimeUnit.DAYS);
            //清空订单确认页面
            session.removeAttribute("userorder");
            session.setAttribute("userorderId",userorderId);
        }
        return map;
    }

    /**
     * 生成订单(多商品)
     */
    @RequestMapping(value = "/insertOrderallitem")
    @ResponseBody
    public Map<String,Object> insertOrderallitem(@RequestParam(value = "address")String address,@RequestParam(value = "data[]")String[] data,@RequestParam(value = "userorderId")Integer userorderId,@RequestParam(value = "userorderCount")Integer userorderCount,@RequestParam(value = "userorderPrice")Double userorderPrice,@RequestParam(value = "couponSubtract")Integer couponSubtract,@RequestParam(value = "userCouponId")Integer userCouponId,HttpSession session){
        //获取用户名
        String userName = (String) session.getAttribute("username");
        //检查是否登录
        Map<String,Object> map = this.utilService.checkUserName(userName);
        Boolean flog = (Boolean) map.get("result");
        //已登录
        if (flog){
            User user = this.userService.checkUserName(userName);
            Integer userId = user.getUserId();
            String userorderState = "待支付";
            //获得当前时间
            Calendar c = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
            String userorderTime = dateFormat.format(c.getTime());
            //获得地址
            String addressAlias = valueOf(address.split(",")[0]);
            String addressName = valueOf(address.split(",")[1]);
            String addressDistrict = valueOf(address.split(",")[2]);
            String addressDetailed = valueOf(address.split(",")[3]);
            String addressPhone = valueOf(address.split(",")[4]);
            //插入订单数据
            this.userorderService.insertUserorder(userorderId,addressAlias,addressName,addressDistrict,addressDetailed,addressPhone,userorderCount,userorderPrice,userorderState,userorderTime,null,couponSubtract,userId);
            for (String str:data
                 ) {
                //获得订单项目
                Integer userorderitemId = this.utilService.UUID();
                Integer goodsId = Integer.valueOf(str.split(",")[1]);
                String goodsName = valueOf(str.split(",")[2]);
                String inventoryName = valueOf(str.split(",")[3]);
                Double userorderitemPrice = Double.valueOf(str.split(",")[5]);
                Integer userorderitemCount =  Integer.valueOf(str.split(",")[4]);
                Integer inventoryId = Integer.valueOf(str.split(",")[6]);
                //插入订单项目数据
                this.userorderitemService.insertUserorderitem(userorderitemId,goodsId,goodsName,inventoryId,inventoryName,userorderitemPrice,userorderitemCount,userorderId);
                //删除购物车
                Integer cartId = Integer.valueOf(str.split(",")[0]);
                this.cartService.deleteCart(cartId);
            }
            //使用优惠券
            if (null != userCouponId){
                this.usercouponService.updateUsercoupon(userCouponId,"已用");
                this.userorderService.insertUserordercouponId(userorderId,userCouponId);
            }
            //定时器（24小时）
            this.scheduledService.setUserorderId(userorderId);
            service.schedule(scheduledService,1, TimeUnit.DAYS);
            //清空订单确认页面
            session.removeAttribute("userorder");
            session.setAttribute("userorderId",userorderId);
        }
        return map;
    }

    /**
     * 访问支付页面
     */
    @RequestMapping(value = "/userPay")
    @ResponseBody
    public Map<String,Object> userPay(HttpSession session){
        //获取用户名
        String userName = (String) session.getAttribute("username");
        //检查是否登录
        Map<String,Object> map = this.utilService.checkUserName(userName);
        Boolean flog = (Boolean) map.get("result");
        //已登录
        if (flog){
            Integer userorderId = (Integer) session.getAttribute("userorderId");
            if (null != userorderId){
                Userorder userorder = this.userorderService.selectUserorderAnduserorderId(userorderId);
                map.put("result2",true);
                map.put("userorder",userorder);
            }else{
                map.put("result2",false);
                map.put("data","操作错误!");
            }
        }
        return map;
    }

    /**
     * 访问支付页面
     */
    @RequestMapping(value = "/Pay")
    @ResponseBody
    public Map<String,Object> Pay(@RequestParam(value = "userPassword")String userPassword,@RequestParam(value = "userorderId")Integer userorderId,@RequestParam(value = "userorderPrice")Double userorderPrice, HttpSession session) {
        //获取用户名
        String userName = (String) session.getAttribute("username");
        //检查是否登录
        Map<String,Object> map = this.utilService.checkUserName(userName);
        Boolean flog = (Boolean) map.get("result");
        //已登录
        if (flog){
            User user = this.userService.loginUser(userName,userPassword);
            if (null != user){
                Balance balance = this.balanceService.getBalance(user.getUserId());
                if (balance.getBalanceMoney() >= userorderPrice){
                    Double newBalanceMoney = balance.getBalanceMoney() - userorderPrice;
                    //更改订单状态为待发货
                    this.userorderService.updateUserorder(userorderId,"待发货");
                    //余额变更增加一条记录
                    //余额明细项目的编号
                    Integer banlanceItemId = this.utilService.UUID();
                    //余额明细项目的时间
                    Date now = new Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
                    String balanceItemData = dateFormat.format(now);
                    //余额明细项目的金额
                    String balanceItemMoney = "-"+ userorderPrice;
                    //余额明细项目的操作
                    String balanceItemOperation = "转出";
                    //余额明细项目的备注
                    String balanceItemRemark = "订单购物："+userorderId;
                    this.balanceItemService.insertBanlanceItem(banlanceItemId,balanceItemData,balanceItemMoney,balanceItemOperation,balanceItemRemark,balance.getBalanceId());
                    //余额变更
                    this.balanceService.updateBalance(balance.getBalanceId(),newBalanceMoney);
                    //发送扣款邮件
                    String text = "账号余额变动：订单号："+userorderId+";金额："+userorderPrice+".";
                    try {
                        this.utilService.sendMail(user.getUserEmail(),text,"账号余额变动");
                    } catch (MessagingException e) {
                    }
                    //清楚userorderId
                    session.removeAttribute("userorderId");
                    //增加支付时间
                    this.userorderService.insertUserorderpayTime(userorderId,balanceItemData);
                    map.put("result2",true);
                    map.put("result3",true);
                    map.put("data","支付完成!");
                }else{
                    map.put("result2",true);
                    map.put("result3",false);
                    map.put("data","余额不够，请先充值!");
                }
            }else{
                map.put("result2",false);
                map.put("data","密码错误!");
            }
        }
        return map;
    }

    /**
     * 访问订单页面
     */
    @RequestMapping(value = "/selectAllorder")
    @ResponseBody
    public Map<String,Object> selectAllorder(HttpSession session){
        //获取用户名
        String userName = (String) session.getAttribute("username");
        //检查是否登录
        Map<String,Object> map = this.utilService.checkUserName(userName);
        Boolean flog = (Boolean) map.get("result");
        //已登录
        if (flog){
            User user = this.userService.checkUserName(userName);
            //所有订单
            List<Userorder> userorderList = this.userorderService.selectUserorderAndId(user.getUserId());
            //待支付
            List<Userorder> userorderListPayment = this.userorderService.selectUserorderAndIdAndState(user.getUserId(),"待支付");
            //待发货
            List<Userorder> userorderListSendgoods = this.userorderService.selectUserorderAndIdAndState(user.getUserId(),"待发货");
            //待收货
            List<Userorder> userorderListReceivinggoods = this.userorderService.selectUserorderAndIdAndState(user.getUserId(),"待收货");
            //待评价
            List<Userorder> userorderListEvaluate= this.userorderService.selectUserorderAndIdAndState(user.getUserId(),"待评价");
            //已完成
            List<Userorder> userorderListFinish= this.userorderService.selectUserorderAndIdAndState(user.getUserId(),"已完成");
            //已取消
            List<Userorder> userorderListCancel = this.userorderService.selectUserorderAndIdAndState(user.getUserId(),"已取消");
            //返修中
            List<Userorder> userorderListRepair = this.userorderService.selectUserorderAndIdAndState(user.getUserId(),"返修中");
            //退货中
            List<Userorder> userorderListReturn= this.userorderService.selectUserorderAndIdAndState(user.getUserId(),"退货中");
            map.put("userorderList",userorderList);
            map.put("userorderListPayment",userorderListPayment);
            map.put("userorderListSendgoods",userorderListSendgoods);
            map.put("userorderListReceivinggoods",userorderListReceivinggoods);
            map.put("userorderListEvaluate",userorderListEvaluate);
            map.put("userorderListFinish",userorderListFinish);
            map.put("userorderListCancel",userorderListCancel);
            map.put("userorderListRepair",userorderListRepair);
            map.put("userorderListReturn",userorderListReturn);
        }
        return map;
    }

    /**
     * 去支付
     */
    @RequestMapping(value = "/userorderId")
    @ResponseBody
    public Map<String,Object> userorderId(@RequestParam(value = "userorderId")Integer userorderId, HttpSession session){
        //获取用户名
        String userName = (String) session.getAttribute("username");
        //检查是否登录
        Map<String,Object> map = this.utilService.checkUserName(userName);
        Boolean flog = (Boolean) map.get("result");
        //已登录
        if (flog){
            session.setAttribute("userorderId",userorderId);
        }
        return map;
    }

    /**
     * 取消订单
     */
    @RequestMapping(value = "/cancelOrder")
    @ResponseBody
    public Map<String,Object> cancelOrder(@RequestParam(value = "userorderId")Integer userorderId, HttpSession session){
        //获取用户名
        String userName = (String) session.getAttribute("username");
        //检查是否登录
        Map<String,Object> map = this.utilService.checkUserName(userName);
        Boolean flog = (Boolean) map.get("result");
        //已登录
        if (flog){
            Userorder userorder = this.userorderService.selectUserorderAnduserorderId(userorderId);
            this.userorderService.updateUserorder(userorderId,"已取消");
            if (null != userorder.getUserCouponId()){
                this.usercouponService.updateUsercoupon(userorder.getUserCouponId(),"可用");
                this.userorderService.clearUserCoupon(userorderId);
            }
        }
        return map;
    }

    /**
     * 取消订单
     */
    @RequestMapping(value = "/confirmReceipt")
    @ResponseBody
    public Map<String,Object> confirmReceipt(@RequestParam(value = "userorderId")Integer userorderId, HttpSession session){
        //获取用户名
        String userName = (String) session.getAttribute("username");
        //检查是否登录
        Map<String,Object> map = this.utilService.checkUserName(userName);
        Boolean flog = (Boolean) map.get("result");
        //已登录
        if (flog){
            this.userorderService.updateUserorder(userorderId,"待评价");
        }
        return map;
    }
}
