package com.jd.tms.common.exception;

/**
 * 细化运行时异常,自己定义一个业务异常
 *
 * @author wangning113
 * @since 2017/12/9
 */
public class ServiceException extends RuntimeException {

    public ServiceException() {
        super();
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression,
                            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);

    }

    public ServiceException(String message) {
        super(message);

    }

    public ServiceException(Throwable cause) {
        super(cause);

    }

}
