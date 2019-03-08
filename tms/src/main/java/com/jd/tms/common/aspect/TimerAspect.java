package com.jd.tms.common.aspect;

import com.jd.tms.common.entity.MonitorTime;
import com.jd.tms.common.util.LoggingUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.logging.Logger;

/**
 * API接口性能分析
 *
 * @author wangning113
 * @since 2017/12/13
 */
@Aspect
@Component
@Order(4)
public class TimerAspect {

    /**
     * 切点函数，过滤com.jd.tms包下任意返回值，任意参数的类的所有方法
     */
    @Pointcut("within(com.jd.tms..*)")
    public void timer() {
    }

    @Around("timer()")
    public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {
        MonitorTime monitorTime = new MonitorTime();
        //获取目标函数名
        String className = joinPoint.getTarget().getClass().getName();
        //获取目标方法名
        String methodName = joinPoint.getSignature().getName();

        //记录相关信息
        monitorTime.setClassName(className);
        monitorTime.setMethodName(methodName);
        monitorTime.setLogTime(new Date());

        //计时并调用目标函数
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();

        //设置消耗时间
        monitorTime.setConsumTime(end - start);


        //通过日志记录工具类记录性能信息
        LoggingUtil loggingUtil = new LoggingUtil();
        loggingUtil.log(monitorTime);

        return result;
    }
}
