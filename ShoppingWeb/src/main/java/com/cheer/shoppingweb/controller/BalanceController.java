package com.cheer.shoppingweb.controller;


import com.cheer.shoppingweb.service.UtilService;
import com.cheer.shoppingwebbalance.model.Balance;
import com.cheer.shoppingwebbalance.service.BalanceItemService;
import com.cheer.shoppingwebbalance.service.BalanceService;
import com.cheer.shoppingwebuser.model.User;
import com.cheer.shoppingwebuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class BalanceController {
    //依赖注入
    @Autowired
    private BalanceService balanceService;
    @Autowired
    private BalanceItemService balanceItemService;
    @Autowired
    private UserService userService;
    @Autowired
    private UtilService utilService;

    /**
     * 打开余额页面
     * @return
     */
    @RequestMapping(value = "/balance.html")
    public String balance(){
        return "balance";
    }

    /**
     * 获得所有的余额明细的数据
     * @param session
     * @return
     */
    @RequestMapping(value = "/balanceAll")
    @ResponseBody
    public Map<String,Object> balanceAll(HttpSession session){
        //获取用户名
        String userName = (String) session.getAttribute("username");
        //检查是否登录
        Map<String,Object> map = this.utilService.checkUserName(userName);
        Boolean flog = (Boolean) map.get("result");
        //已登录
        if (flog){
            //获得用户信息
            User user = this.userService.checkUserName(userName);
            //获得余额信息
            Balance balance = this.balanceService.getBalance(user.getUserId());
            map.put("balance",balance);
        }
        return map;
    }

    /**
     * 充值
     * @param balanceMoney
     * @param session
     * @return
     */
    @RequestMapping(value = "/updateBalance")
    @ResponseBody
    public Map<String,Object> updateBalance(@RequestParam(value = "balanceMoney") Double balanceMoney, HttpSession session){
        //获取用户名
        String userName = (String) session.getAttribute("username");
        //检查是否登录
        Map<String,Object> map = this.utilService.checkUserName(userName);
        Boolean flog = (Boolean) map.get("result");
        //已登录
        if (flog){
            //获得用户信息
            User user = this.userService.checkUserName(userName);
            //获得余额信息
            Balance balance = this.balanceService.getBalance(user.getUserId());
            //获得新余额
            Double newBalanceMoney = balance.getBalanceMoney() + balanceMoney;
            //如果新余额资金达到100000，升级为会员
            if (newBalanceMoney >= 100000.00){
                this.userService.updateUserVip(1,user.getUserId());
            }
            //更新余额
            this.balanceService.updateBalance(balance.getBalanceId(),newBalanceMoney);
            //余额明细项目的编号
            Integer banlanceItemUuid = this.utilService.UUID();
            //余额明细项目的时间
            Date now = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
            String balanceItemData = dateFormat.format(now);
            //余额明细项目的金额
            String balanceItemMoney = "+"+balanceMoney;
            //余额明细项目的操作
            String balanceItemOperation = "转入";
            //余额明细项目的备注
            String balanceItemRemark = "线上充值";
            this.balanceItemService.insertBanlanceItem(banlanceItemUuid,balanceItemData,balanceItemMoney,balanceItemOperation,balanceItemRemark,balance.getBalanceId());
            map.put("data","充值成功！");
        }
        return map;
    }
}
