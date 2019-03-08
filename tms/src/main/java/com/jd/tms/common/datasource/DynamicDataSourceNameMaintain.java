package com.jd.tms.common.datasource;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 动态数据源名字维护类
 * 在这里解决线程安全问题
 * @author wangning113
 * @since 2017/12/14
 */
public class DynamicDataSourceNameMaintain {

    /**
     *DATA_SOURCE_NAME  数据源名字，使用ThreadLocal维护
     */
    private static final ThreadLocal<String> DATA_SOURCE_NAME = new ThreadLocal<>();
    public static List<String> dataSourceNames = new ArrayList<>();

    public static void setDataSourceName(String name){
        DATA_SOURCE_NAME.set(name);
    }

    public static String getDataSourceName(){
        return DATA_SOURCE_NAME.get();
    }

    public static void clearDataSourceName(){
        DATA_SOURCE_NAME.remove();
    }

    /**
     * 通过key的值判断数据源中是否包含对应的数据源
     * @param dataSourceName
     * @return
     */
    public static boolean containsDataSource(String dataSourceName){
        return dataSourceNames.contains(dataSourceName);
    }
}
