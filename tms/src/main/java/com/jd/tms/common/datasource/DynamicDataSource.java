package com.jd.tms.common.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 数据源类，可以通过key值获取数据源
 * @author wangning113
 * @since 2017/12/14
 */
public class DynamicDataSource extends AbstractRoutingDataSource{

    @Override
    protected Object determineCurrentLookupKey() {
        String dataSourceName = DynamicDataSourceNameMaintain.getDataSourceName();
        return dataSourceName;
    }
}
