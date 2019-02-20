package com.cheer.shoppingweb.controller;


import com.cheer.shoppingweb.service.UtilService;
import com.cheer.shoppingwebgoodscollect.model.Goodscollect;
import com.cheer.shoppingwebgoodscollect.service.GoodscollectService;
import com.cheer.shoppingwebuser.model.User;
import com.cheer.shoppingwebuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class GoodscollectController {
    @Autowired
    private GoodscollectService goodscollectService;
    @Autowired
    private UserService userService;
    @Autowired
    private UtilService utilService;
    /**
     * 打开商品收藏页面
     * @return
     */
    @RequestMapping(value = "/usergoodscollect.html")
    public String usergoodscollect(){
        return "usergoodscollect";
    }

    /**
     * 获得所有商品收藏
     * @return
     */
    @RequestMapping(value = "/selectGoodscollectAll")
    @ResponseBody
    public Map<String,Object> selectGoodscollectAll(HttpSession session){
        //获取用户名
        String userName = (String) session.getAttribute("username");
        //检查是否登录
        Map<String,Object> map = this.utilService.checkUserName(userName);
        Boolean flog = (Boolean) map.get("result");
        //已登录
        if (flog){
            User user = this.userService.checkUserName(userName);
            List<Goodscollect> goodscollectList = this.goodscollectService.selectGoodscollectAll(user.getUserId());
            map.put("goodscollectList",goodscollectList);
        }
        return map;
    }

    /**
     * 通过用户编号和商品编号检查是否有该收藏商品对象
     * @return
     */
    @RequestMapping(value = "/selectGoodscollectAndgoodsIduserId")
    @ResponseBody
    public Map<String,Object> selectGoodscollectAndgoodsIduserId(@RequestParam(value = "goodsId")Integer goodsId, HttpSession session){
        //获取用户名
        String userName = (String) session.getAttribute("username");
        //检查是否登录
        Map<String,Object> map = this.utilService.checkUserName(userName);
        Boolean flog = (Boolean) map.get("result");
        //已登录
        if (flog){
            User user = this.userService.checkUserName(userName);
            Goodscollect goodscollect = this.goodscollectService.selectGoodscollectAndgoodsIduserId(goodsId,user.getUserId());
            if (null != goodscollect){
                map.put("result",true);
                map.put("goodscollect",goodscollect);
            }else{
                map.put("result",false);
            }
        }
        return map;
    }

    /**
     * 通过商品收藏编号取消收藏
     * @return
     */
    @RequestMapping(value = "/deleteGoodscollectAndgoodscollectId")
    @ResponseBody
    public Map<String,Object> deleteGoodscollectAndgoodscollectId(@RequestParam(value = "goodscollectId")Integer goodscollectId, HttpSession session){
        //获取用户名
        String userName = (String) session.getAttribute("username");
        //检查是否登录
        Map<String,Object> map = this.utilService.checkUserName(userName);
        Boolean flog = (Boolean) map.get("result");
        //已登录
        if (flog){
            this.goodscollectService.deleteGoodscollectAndgoodscollectId(goodscollectId);
            map.put("data","取消收藏商品成功！");
        }
        return map;
    }

    /**
     * 添加商品收藏
     * @return
     */
    @RequestMapping(value = "/insertGoodscollect")
    @ResponseBody
    public Map<String,Object> insertGoodscollect(@RequestParam(value = "goodsId")Integer goodsId,HttpSession session){
        //获取用户名
        String userName = (String) session.getAttribute("username");
        //检查是否登录
        Map<String,Object> map = this.utilService.checkUserName(userName);
        Boolean flog = (Boolean) map.get("result");
        //已登录
        if (flog){
            User user = this.userService.checkUserName(userName);
            Goodscollect goodscollect = this.goodscollectService.selectGoodscollectAndgoodsIduserId(goodsId,user.getUserId());
            if (null != goodscollect){
                map.put("result",false);
                map.put("data","已收藏！");
            }else{
                Integer goodscollectId = this.utilService.UUID();
                this.goodscollectService.insertGoodscollect(goodscollectId,goodsId,user.getUserId());
                map.put("result",true);
                map.put("data","商品收藏成功！");
            }
        }
        return map;
    }
}
