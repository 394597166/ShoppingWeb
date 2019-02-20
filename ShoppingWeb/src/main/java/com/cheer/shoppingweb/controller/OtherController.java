package com.cheer.shoppingweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/other")
public class OtherController {
    /**
     * 打开服务协议页面
     * @return
     */
    @RequestMapping(value = "/service.html")
    public String service(){
        return "service";
    }

    /**
     * 打开在线支付页面
     * @return
     */
    @RequestMapping(value = "/onlinePayment.html")
    public String onlinePayment(){
        return "onlinePayment";
    }

    /**
     * 打开配送费标准页面
     * @return
     */
    @RequestMapping(value = "/distribution.html")
    public String distribution(){
        return "distribution";
    }

    /**
     * 打开购物常见问题页面
     * @return
     */
    @RequestMapping(value = "/FAQ.html")
    public String FAQ(){
        return "FAQ";
    }

    /**
     * 打开购物流程页面
     * @return
     */
    @RequestMapping(value = "/shoppingProcess.html")
    public String shoppingProcess(){
        return "shoppingProcess";
    }

    /**
     * 打开退换货政策总则页面
     * @return
     */
    @RequestMapping(value = "/exchanged.html")
    public String exchanged(){
        return "exchanged";
    }

    /**
     * 打开自营商品退换货细则页面
     * @return
     */
    @RequestMapping(value = "/exchanged2.html")
    public String exchanged2(){
        return "exchanged2";
    }

    /**
     * 打开关于我们页面
     * @return
     */
    @RequestMapping(value = "/about.html")
    public String about(){
        return "about";
    }

}
