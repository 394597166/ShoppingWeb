package com.cheer.shoppingweb.controller;


import com.cheer.shoppingweb.service.UtilService;
import com.cheer.shoppingwebaddress.service.DefaultaddressService;
import com.cheer.shoppingwebbalance.service.BalanceService;
import com.cheer.shoppingweblog.aspect.LoggerAspect;
import com.cheer.shoppingwebuser.model.User;
import com.cheer.shoppingwebuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class UserController {
    //依赖注入
    @Autowired
    private UserService userService;
    @Autowired
    private DefaultaddressService defaultaddressServiceImpl;
    @Autowired
    private BalanceService balanceService;
    @Autowired
    private UtilService utilService;
    @Autowired
    private LoggerAspect loggerAspect;
    /**
     * 打开登录页面
     * @return
     */
    @RequestMapping(value = "/login.html")
    public String login(){
        return "login";
    }

    /**
     * 打开注册页面
     * @return
     */
    @RequestMapping(value = "/register.html")
    public String register(){
        return "register";
    }

    /**
     * 打开个人资料页面
     * @return
     */
    @RequestMapping(value = "/personalCenter.html")
    public String personalCenter(){
        return "personalCenter";
    }

    /**
     * 获得个人资料
     * @param session
     * @return
     */
    @RequestMapping(value = "/readPersonalCenter")
    @ResponseBody
    public Map<String, Object> readPersonalCenter(HttpSession session){
        //获取用户名
        String userName = (String) session.getAttribute("username");
        //检查是否登录
        Map<String,Object> map = this.utilService.checkUserName(userName);
        Boolean flog = (Boolean) map.get("result");
        //已登录
        if (flog){
            User user = this.userService.checkUserName(userName);
            map.put("userName",user.getUserName());
            map.put("userSex",user.getUserSex());
            map.put("userVip",user.getUserVip());
            map.put("userAge",user.getUserAge());
        }
        return map;
    }

    /**
     * 打开找回密码页面
     * @return
     */
    @RequestMapping(value = "/retrievePassword.html")
    public String retrievePassword(){
        return "retrievePassword";
    }

    /**
     * 打开邮箱设置页面
     * @return
     */
    @RequestMapping(value = "/updateMail.html")
    public String updateMail(){
        return "updateMail";
    }

    /**
     * 打开密码设置页面
     * @return
     */
    @RequestMapping(value = "/updatePassword.html")
    public String updatePassword(){
        return "updatePassword";
    }


    /**
     * 更新信息
     * @param userSex
     * @param userAge
     * @param session
     * @return
     */
    @RequestMapping(value = "/updateUser")
    @ResponseBody
    public Map<String,String> updateUser(@RequestParam(value = "userSex") String userSex,@RequestParam(value = "userAge") Integer userAge, HttpSession session){
        String userName = (String) session.getAttribute("username");
        Map<String,String> map = new HashMap<>();
        if (null != userName){
            User user = this.userService.checkUserName(userName);
            if (null != user){
                user.setUserSex(userSex);
                user.setUserAge(userAge);
                this.userService.updateCenter(user);
                map.put("data","信息更改成功！");
                return map;
            }else{
                map.put("data","未登录!");
                return map;
            }
        }else{
            map.put("data","未登录!");
            return map;
        }
    }

    /**
     * 更新密码
     * @param userPassword
     * @param session
     * @return
     */
    @RequestMapping(value = "/updateUserPassword")
    @ResponseBody
    public Map<String,String> updateUserPassword(@RequestParam(value = "oldPassword") String oldPassword,@RequestParam(value = "userPassword") String userPassword, HttpSession session){
        String userName = (String) session.getAttribute("username");
        Map<String,String> map = new HashMap<>();
        if (null != userName){
            User user = this.userService.loginUser(userName,oldPassword);
            if (null != user){
                user.setUserPassword(userPassword);
                this.userService.updatePassword(user);
                map.put("data","密码更改成功！");
                return map;
            }else{
                map.put("data","旧密码输入错误");
                return map;
            }
        }else{
            map.put("data","未登录!");
            return map;
        }
    }

    /**
     * 更新邮箱
     * @param oldMail
     * @param newMail
     * @param session
     * @return
     */
    @RequestMapping(value = "/updateUserMail")
    @ResponseBody
    public Map<String,String> updateUserMail(@RequestParam(value = "oldMail") String oldMail,@RequestParam(value = "newMail") String newMail, HttpSession session){
        String userName = (String) session.getAttribute("username");
        Map<String,String> map = new HashMap<>();
        if (null != userName){
            User user = this.userService.checkMailUserName(userName,oldMail);
            if (null != user){
                user.setUserEmail(newMail);
                this.userService.updateMail(user);
                map.put("data","邮箱更改成功！");
                return map;
            }else{
                map.put("data","旧邮箱输入错误");
                return map;
            }
        }else{
            map.put("data","未登录!");
            return map;
        }
    }

    /**
     * 更改密码
     * @param userName
     * @param userEmail
     * @param userPassword
     * @return
     */
    @RequestMapping(value = "/updatePassword")
    @ResponseBody
    public String updatePassword(@RequestParam(value = "userName") String userName,@RequestParam(value = "userEmail") String userEmail,@RequestParam(value = "userPassword") String userPassword){
        User user = this.userService.checkMailUserName(userName,userEmail);
        if (null != user){
            user.setUserPassword(userPassword);
            this.userService.updatePassword(user);
            return "true";
        }else{
            return "false";
        }
    }

    /**
     * 查询是否存在该用户及邮箱
     * @param userEmail
     * @return
     */
    @RequestMapping(value = "/checkMailUserName")
    @ResponseBody
    public String checkMailName(@RequestParam(value = "userName") String userName,@RequestParam(value = "userEmail") String userEmail){
        User user = this.userService.checkMailUserName(userName,userEmail);
        if (null != user){
            String text ="验证码：";
            Integer code = (int) ((Math.random() * 8999)+1000);
            text +=code;
            boolean flog = false;
            try {
                this.utilService.sendMail(userEmail,text,"欢迎注册宅客微购网站");
                flog = true;
            } catch (MessagingException e) {
            }
            if (flog){
                return String.valueOf(code);
            }else{
                return "false";
            }
        }else{
            return "false";
        }
    }

    /**
     * 查询是否存在该用户名
     * @param userName
     * @return
     */
    @RequestMapping(value = "/checkUserName")
    @ResponseBody
    public Boolean checkUserName(@RequestParam(value = "data") String userName){
        User user = this.userService.checkUserName(userName);
        //创建比对变量
        Boolean flog = false;
        if (null != user){
            //把flog设置为真
            flog = true;
        }
        return flog;
    }

    /**
     * 查询是否存在该邮箱
     * @param userEmail
     * @return
     */
    @RequestMapping(value = "/checkMail")
    @ResponseBody
    public String checkMail(@RequestParam(value = "data") String userEmail){
        User user = this.userService.checkEmail(userEmail);
        if (null == user){
            String text ="验证码：";
            Integer code = (int) ((Math.random() * 8999)+1000);
            text +=code;
            boolean flog = false;
            try {
                this.utilService.sendMail(userEmail,text,"欢迎注册宅客微购网站");
                flog = true;
            } catch (MessagingException e) {
            }
            if (flog){
                return String.valueOf(code);
            }else{
                return "false";
            }
        }else{
            return "false";
        }
    }

    /**
     * 注册用户
     * @param user
     */
    @RequestMapping(value = "/insertUser")
    @ResponseBody
    public String insert(User user){
        if (null != user){
            //初始化用户
            user.setUserVip(0);
            user.setUserState("normal");
            user.setUserAge(0);
            Integer userUuid = this.utilService.UUID();
            Integer balanceUuid = this.utilService.UUID();
            user.setUserId(userUuid);
            this.userService.insertUser(user);
            this.defaultaddressServiceImpl.insert(userUuid);
            this.balanceService.insertBalance(balanceUuid,0.00,userUuid);
            return "true";
        }else{
            return "false";
        }
    }

    /**
     * 登录账号和密码
     * @param userName
     * @param userPassword
     * @return
     */
    @RequestMapping(value = "/loginUser")
    @ResponseBody
    public Boolean checkUserName(@RequestParam(value = "userName") String userName,@RequestParam(value = "userPassword") String userPassword, HttpSession session){
        User user = this.userService.loginUser(userName,userPassword);
        //创建比对变量
        Boolean flog = false;
        if (null != user){
            //把flog设置为真
            flog = true;
            this.loggerAspect.setUser(user);
            session.setAttribute("username",user.getUserName());
        }
        return flog;
    }

    /**
     * 退出
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        //清空session
        session.invalidate();
        return "redirect:http://localhost:8080/user/login.html";
    }
}
