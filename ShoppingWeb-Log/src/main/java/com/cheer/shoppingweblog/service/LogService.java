package com.cheer.shoppingweblog.service;

public interface LogService {
    /**
     * 插入日志
     * @param logId
     * @param logData
     * @param logUserName
     * @param logMethod
     */
    void insertLog(Integer logId,String logData,String logUserName,String logMethod);
}
