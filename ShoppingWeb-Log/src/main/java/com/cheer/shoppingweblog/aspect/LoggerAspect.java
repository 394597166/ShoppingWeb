package com.cheer.shoppingweblog.aspect;

import com.cheer.shoppingweb.service.UtilService;
import com.cheer.shoppingweblog.service.LogService;
import com.cheer.shoppingwebuser.model.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Aspect
@Component
public class LoggerAspect {
    private User user;
    @Autowired
    private LogService logService;
    @Autowired
    private UtilService utilService;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    //指定余额变动时执行
    @Pointcut("execution(* com.cheer.shoppingwebbalance.service.BalanceService.updateBalance(..))")
    private void logger(){}

    //余额变动成功后执行
    @After("logger()")
    public void logAfter(JoinPoint point){
        //日志编号
        Integer logId = this.utilService.UUID();
        //获得当前时间
        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
        String logData = dateFormat.format(c.getTime());
        //获得执行的方法名
        String logMethod = point.getSignature().getDeclaringTypeName() +
                "." + point.getSignature().getName();
        this.logService.insertLog(logId,logData,user.getUserName(),logMethod);
    }
}
