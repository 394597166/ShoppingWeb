package com.cheer.shoppingweb.service;

import javax.mail.MessagingException;
import java.util.Map;

public interface UtilService {
    /**
     * 发送邮件
     * @param to
     * @param text
     * @param title
     */
    void sendMail(String to,String text,String title) throws MessagingException;

    /**
     * 生成uuid
     * @return
     */
    Integer UUID();

    /**
     * 检查用户
     * @param userName
     * @return
     */
    Map<String,Object> checkUserName(String userName);

    /**
     * 检查用户
     * @param adminName
     * @return
     */
    Map<String,Object> checkAdminName(String adminName);
}
