package com.jd.tms.common.annotation;

/**
 * 自定义注解，用于指定数据源
 * @author wangning113
 * @since 2017/12/14
 */

import java.lang.annotation.*;

/**
 * 在方法上使用，用于指定使用哪个数据源
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {

    String value();

}
