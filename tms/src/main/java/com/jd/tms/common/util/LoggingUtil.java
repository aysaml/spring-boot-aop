package com.jd.tms.common.util;

import com.jd.tms.common.entity.MonitorTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志记录工具类
 * 把信息记录到日志中，留作以后分析
 *
 * @author wangning113
 * @since 2017/12/13
 */
public class LoggingUtil {
    private static final Logger log = LoggerFactory.getLogger(LoggingUtil.class);

    /**
     * 将信息记录到日志文件中
     *
     * @param obj
     */
    public void log(Object obj) {
        log.info("wait logging...");
        log.info(obj.toString());
    }
}
