package com.jd.tms.common.aspect;

import com.jd.tms.common.annotation.TargetDataSource;
import com.jd.tms.common.datasource.DynamicDataSourceNameMaintain;
import com.jd.tms.common.util.LoggingUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author wangning113
 * @since 2017/12/14
 */
@Aspect
@Component
@Order(-1)
public class DataSourceChangeAspect{

        private LoggingUtil log = new LoggingUtil();

        @Before("@annotation(targetDataSource)")
        public void changeDataSource(JoinPoint joinPoint, TargetDataSource targetDataSource){
            String dsName = targetDataSource.value();
            if (!DynamicDataSourceNameMaintain.containsDataSource(dsName)) {
                log.log("数据源不存在，使用默认数据源 " + targetDataSource.value() + joinPoint.getSignature());
            } else {
                DynamicDataSourceNameMaintain.setDataSourceName(targetDataSource.value());
            }
        }

        @After("@annotation(targetDataSource)")
        public void restoreDataSource(JoinPoint point, TargetDataSource targetDataSource){
            //方法执行完毕之后，销毁当前数据源信息，进行垃圾回收。
            DynamicDataSourceNameMaintain.clearDataSourceName();
    }
}
