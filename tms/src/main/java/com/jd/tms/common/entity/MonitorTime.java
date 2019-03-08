package com.jd.tms.common.entity;

import java.util.Date;

/**
 * 性能监控信息类
 *
 * @author wangning113
 * @since 2017/12/13
 */
public class MonitorTime {
    /**
     * 类名
     */
    private String className;
    /**
     * 属性名
     */
    private String methodName;
    /**
     * 记录时间
     */
    private Date logTime;
    /**
     * 消耗时间（毫秒）
     */
    private long consumTime;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }


    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public long getConsumTime() {
        return consumTime;
    }

    public void setConsumTime(long consumTime) {
        this.consumTime = consumTime;
    }

    @Override
    public String toString() {
        return "MonitorTime{" +
                "className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", logTime=" + logTime +
                ", consumTime=" + consumTime +"ms"+
                '}';
    }
}
