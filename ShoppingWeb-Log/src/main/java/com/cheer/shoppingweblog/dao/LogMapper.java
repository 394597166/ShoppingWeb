package com.cheer.shoppingweblog.dao;

import org.apache.ibatis.annotations.Param;

public interface LogMapper {
    /**
     * 插入日志
     * @param logId
     * @param logData
     * @param logUserName
     * @param logMethod
     */
    void insertLog(@Param("logId") Integer logId, @Param("logData") String logData, @Param("logUserName")String logUserName, @Param("logMethod")String logMethod);
}
