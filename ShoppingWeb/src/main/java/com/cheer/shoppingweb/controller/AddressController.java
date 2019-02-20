package com.cheer.shoppingweb.controller;


import com.cheer.shoppingweb.service.UtilService;
import com.cheer.shoppingwebaddress.model.Address;
import com.cheer.shoppingwebaddress.service.AddressService;
import com.cheer.shoppingwebaddress.service.DefaultaddressService;
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
public class AddressController {
    //依赖注入
    @Autowired
    private AddressService addressService;
    @Autowired
    private UserService userService;
    @Autowired
    private DefaultaddressService defaultaddressService;
    @Autowired
    private UtilService utilService;
    /**
     * 打开地址页面
     * @return
     */
    @RequestMapping(value = "/address.html")
    public String address(){
        return "address";
    }

    /**
     * 获得所有的收货地址
     * @param session
     * @return
     */
    @RequestMapping(value = "/addressAll")
    @ResponseBody
    public Map<String,Object> addressAll(HttpSession session){
        //获得用户名
        String userName = (String) session.getAttribute("username");
        //判定用户是否登录
        Map<String,Object> map = utilService.checkUserName(userName);
        boolean flog = (boolean) map.get("result");
        //已登录
        if (flog){
            //获得用户信息
            User user = this.userService.checkUserName(userName);
            //获得用户所有收货地址
            List<Address> addressList = this.addressService.AddressAll(user.getUserId());
            if (addressList.size()>0){
                map.put("result2",true);
                map.put("addressList",addressList);
            }else{
                map.put("result2",false);
                map.put("data","暂无收货地址！");
            }
        }
        return map;
    }

    /**
     * 设置默认地址
     * @param addressId
     * @param session
     * @return
     */
    @RequestMapping(value = "/updateDefaultAddress")
    @ResponseBody
    public Map<String,Object> updateDefaultAddress(@RequestParam(value = "addressId") Integer addressId,HttpSession session){
        //获得用户名
        String userName = (String) session.getAttribute("username");
        //判定用户是否登录
        Map<String,Object> map = utilService.checkUserName(userName);
        boolean flog = (boolean) map.get("result");
        //已登录
        if (flog){
            //获得用户信息
            User user = this.userService.checkUserName(userName);
            //变更默认地址
            this.defaultaddressService.updateDefault(user.getUserId(),addressId);
            map.put("data","设置成功!");
        }
        return map;
    }

    /**
     * 删除收货地址
     * @param addressId
     * @param session
     * @return
     */
    @RequestMapping(value = "/deleteAddress")
    @ResponseBody
    public Map<String,Object> deleteAddress(@RequestParam(value = "addressId") Integer addressId,HttpSession session){
        //获得用户名
        String userName = (String) session.getAttribute("username");
        //检查用户名
        Map<String,Object> map = utilService.checkUserName(userName);
        boolean flog = (boolean) map.get("result");
        //已登录
        if (flog){
            //删除用户地址
            this.addressService.deleteAddress(addressId);
            map.put("data","删除成功!");
        }
        return map;
    }

    /**
     * 新增收货地址
     * @param addressAlias
     * @param addressName
     * @param addressDistrict
     * @param addressDetailed
     * @param addressPhone
     * @param session
     * @return
     */
    @RequestMapping(value = "/insertAddress")
    @ResponseBody
    public Map<String,Object> insertAddress(@RequestParam(value = "addressAlias") String addressAlias,@RequestParam(value = "addressName")String addressName,@RequestParam(value = "addressDistrict")String addressDistrict,@RequestParam(value = "addressDetailed")String addressDetailed,@RequestParam(value = "addressPhone")String addressPhone,HttpSession session){
        //获得用户名
        String userName = (String) session.getAttribute("username");
        //检查用户是否登录
        Map<String,Object> map = utilService.checkUserName(userName);
        boolean flog = (boolean) map.get("result");
        //已登录
        if (flog){
            //获得用户信息
            User user = this.userService.checkUserName(userName);
            //获得地址编号
            Integer uuid = this.utilService.UUID();
            //新建地址
            this.addressService.insertAddress(uuid,addressAlias,addressName,addressDistrict,addressDetailed,addressPhone,user.getUserId());
            map.put("data","新增收货地址成功！");
        }
        return map;
    }

    /**
     * 更新地址
     * @param address
     * @param session
     * @return
     */
    @RequestMapping(value = "/updateAddress")
    @ResponseBody
    public Map<String,Object> updateAddress(Address address,HttpSession session){
        //获得用户名
        String userName = (String) session.getAttribute("username");
        //检查用户是否登录
        Map<String,Object> map = utilService.checkUserName(userName);
        boolean flog = (boolean) map.get("result");
        //已登录
        if (flog){
            //更细地址
            this.addressService.updateAddress(address);
            map.put("data","更新收货地址成功！");
        }
        return map;
    }


}
