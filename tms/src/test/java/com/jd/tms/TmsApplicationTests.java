package com.jd.tms;

import com.jd.tms.common.entity.User;
import com.jd.tms.common.mapper.UserMapper;
import com.jd.tms.common.service.LoginService;
import org.apache.ibatis.annotations.Param;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TmsApplicationTests {

    /**
     * junit测试业务层
     */
    @Resource
    private LoginService loginService;
    @Autowired
    private MockMvc mvc;
    @Resource
    private UserMapper userMapper;

    @Test
    public void testCheckLogin() {
        System.out.println("业务层测试开始");
        User user = loginService.checkLogin("wn", "123");
        Assert.assertNotNull(user);
        System.out.println(user.toString());
        System.out.println("业务层测试结束");
    }

    /**
     * Mock对controller测试
     */
    @Test
    public void testUserController() throws Exception {
        System.out.println("controller测试开始");
        mvc.perform(MockMvcRequestBuilders.get("/login"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("URL测试正确"));
        System.out.println("controller层测试结束");
    }


    /**
     * dao层测试增删改查
     */
    @Test
    public void testFind() {
        System.out.println("dao层测试开始");
        //简单验证结果集是否正确
        //数据tms的tms_user表中有5条数据
        Assert.assertEquals(5, userMapper.findAllUser().size());
    }

    @Test
    @Rollback
    public void testInsert() {
        System.out.println("测试新增");
        User user = new User();
        user.setName("测试新增1");
        user.setPassword("123456");
        Assert.assertEquals(1, userMapper.insert(user.getName(), user.getPassword()));
    }

    @Test
    @Rollback
    public void testUpdate() {
        System.out.println("测试更新");
        User user = new User();
        user.setName("wn");
        user.setPassword("123456");
        Assert.assertEquals(1, userMapper.update(user.getName(), user.getPassword()));
    }

    @Test
    @Rollback
    public void testDel() {
        System.out.println("测试删除");
        Assert.assertEquals(1, userMapper.delete(1));
        System.out.println("dao层测试完毕");
    }


}
