package com.cheer.shoppingweb.service.impl;


import com.cheer.shoppingweb.service.UtilService;
import org.springframework.stereotype.Service;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

@Service
public class UtilServiceImpl implements UtilService {
    @Override
    public void sendMail(String to, String text, String title) throws MessagingException {
        //创建连接对象 连接到邮件服务器
        Properties properties = new Properties();
        //设置发送邮件的基本参数
        //发送邮件服务器
        properties.put("mail.smtp.host", "smtp.qq.com");
        //发送端口
        properties.put("mail.smtp.port", "25");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.transport.protocol", "smtp");
        //遇到最多的坑就是下面这行，不加要报“A secure connection is requiered”错。
        properties.put("mail.debug", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        // 发件人的账号
        properties.put("mail.user", "394597166@qq.com");
        // 访问SMTP服务时需要提供的密码
        properties.put("mail.password", "ipcczojxxmbwcahj");
        //设置发送邮件的账号和密码
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //两个参数分别是发送邮件的账户和密码
                return new PasswordAuthentication("394597166","ipcczojxxmbwcahj");
            }
        });
        //创建邮件对象
        Message message = new MimeMessage(session);
        //设置发件人
        message.setFrom(new InternetAddress("394597166@qq.com"));
        //设置收件人
        message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
        //设置主题
        message.setSubject(title);
        //设置邮件正文  第二个参数是邮件发送的类型
        message.setContent(text,"text/html;charset=UTF-8");
        //发送一封邮件
        Transport.send(message);
    }

    @Override
    public Integer UUID() {
        //获得随机UUID
        int uuid = UUID.randomUUID().toString().hashCode();
        //如果是负数则转正
        if (uuid < 0) {
            uuid = -uuid;
        }
        return uuid;
    }

    @Override
    public Map<String, Object> checkUserName(String userName) {
        Map<String,Object> map = new HashMap<>();
        if (null != userName){
            map.put("result",true);
        }else{
            map.put("result",false);
            map.put("data","未登录!");
        }
        return map;
    }

    @Override
    public Map<String, Object> checkAdminName(String adminName) {
        Map<String,Object> map = new HashMap<>();
        if (null != adminName){
            map.put("result",true);
        }else{
            map.put("result",false);
            map.put("data","未登录!");
        }
        return map;
    }
}
