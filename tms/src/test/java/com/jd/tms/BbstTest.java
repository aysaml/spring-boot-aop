package com.jd.tms;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author wangning113
 * @since 2017/12/10
 */
public class BbstTest {
    @RunWith(SpringRunner.class)
    @SpringBootTest
    @WebAppConfiguration
    @AutoConfigureMockMvc
    public abstract class BaseTest {
        @Autowired
        protected MockMvc mvc;
    }
}
