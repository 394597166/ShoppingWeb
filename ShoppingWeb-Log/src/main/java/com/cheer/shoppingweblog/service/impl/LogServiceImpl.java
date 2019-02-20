package com.cheer.shoppingweblog.service.impl;

import com.cheer.shoppingweblog.dao.LogMapper;
import com.cheer.shoppingweblog.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logManager;

    @Override
    public void insertLog(Integer logId, String logData, String logUserName, String logMethod) {
        this.logManager.insertLog(logId,logData,logUserName,logMethod);
    }
}
