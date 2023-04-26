package com.youkeda.application.ebusiness;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
class EbusinessApplicationTests {
    private static final Logger LOG = LoggerFactory.getLogger(EbusinessApplicationTests.class);

    @Autowired
    private HelloControl helloControl;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    /**
     * 所有测试方法执行之前执行该方法
     */
    @BeforeEach
    public void before() {
        //获取mockmvc对象实例
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void contextLoads() throws Exception {
        try {
            checkClass();

            MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/index")).andExpect(
                MockMvcResultMatchers.status().isOk()).andReturn();

            String contentAsString = mvcResult.getResponse().getContentAsString();
            LOG.info("开始检查 /index 调用：");
            Assertions.assertThat(contentAsString).contains("HelloWorld");
            Assert.assertTrue("请求 /index 必须输出 “HelloWorld” .", contentAsString.contains("HelloWorld"));
            LOG.info("check successful");
            LOG.info("检查完毕");
        } catch (Exception e) {
            LOG.error("检查出错，请对照错误信息提示修正程序。", e);
            throw e;
        }
    }

    private void checkClass() throws Exception {
        LOG.info("开始检查类是否存在：");
        try {
            Class sobjClass = Class.forName("com.youkeda.application.ebusiness.control.HelloControl");
        } catch (ClassNotFoundException cnfe) {
            LOG.error("缺少 com.youkeda.application.ebusiness.control.HelloControl");
            throw cnfe;
        }

        LOG.info("检查完毕");
    }

}
