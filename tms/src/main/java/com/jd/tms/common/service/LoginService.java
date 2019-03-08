package com.jd.tms.common.service;

import com.jd.tms.common.entity.User;
import com.jd.tms.common.exception.ServiceException;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户登录处理接口
 *
 * @author wangning113
 * @since 2017/12/10
 */
public interface LoginService {
    /**
     * 用于处理用户登录验证
     *
     * @param name     用户名
     * @param password 密码
     * @return 用户实体类
     */
    @Transactional(rollbackFor = ServiceException.class)
    public User checkLogin(String name, String password);

    /**
     * 处理用户注册
     *
     * @param name
     * @param password
     * @return
     */
    @Transactional(rollbackFor = ServiceException.class)
    public boolean regist(String name, String password);

    /**
     * 修改用户信息
     *
     * @param name
     * @param password
     * @return
     */
    @Transactional(rollbackFor = ServiceException.class)
    public void update(String name, String password);
}
