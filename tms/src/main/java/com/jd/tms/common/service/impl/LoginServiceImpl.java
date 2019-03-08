package com.jd.tms.common.service.impl;

import com.jd.tms.common.entity.User;
import com.jd.tms.common.exception.ServiceException;
import com.jd.tms.common.mapper.UserMapper;
import com.jd.tms.common.service.LoginService;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 登录处理实现类
 *
 * @author wangning113
 * @since 2017/12/10
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void update(String name, String password) {
        User user = null;
        user = userMapper.findByName(name);
        if (user == null) {
            throw new ServiceException("用户不存在");
        }
        userMapper.update(name, password);
    }

    @Override
    public boolean regist(String name, String password) {
        User user = null;
        user = userMapper.findByName(name);
        if (user != null) {
            throw new ServiceException("用户名已存在");
        }
        userMapper.insert(name, password);

        return true;
    }

    @Override
    public User checkLogin(String name, String password) {
        User user = null;
        user = userMapper.findByName(name);
        if (user == null) {
            /*
             * 抛出应用异常
             *     应用异常指的是因为用户的错误操作引起的异常，比如用户名填写错误。
             *     这样的异常发生之后，应该给用户明确的提示。
             */
            throw new ServiceException("用户名错误");
        }

        if (!user.getPassword().equals(password)) {
            throw new ServiceException("密码错误");
        }

        //登录验证通过
        return user;
    }

}
