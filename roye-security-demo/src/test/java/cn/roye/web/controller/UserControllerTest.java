package cn.roye.web.controller;


import cn.roye.domain.ResultObj;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * 测试用例, 第一次的额启动报错：
 * java.lang.IllegalStateException: Could not load TestContextBootstrapper [null].
 * Specify @BootstrapWith's 'value' attribute or make the default bootstrapper class available.
 * 是因为 测试依赖的版本配置错误
 */
@RunWith(SpringRunner.class)// 如何运行这个测试用例
@SpringBootTest // 表示这个类是一个测试用例的类
public class UserControllerTest {

    @Autowired
    private WebApplicationContext wac;

//    伪造MVC 环境
    private MockMvc mockMvc;

    @Before
    public void steup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    /**
     * $ : the root object/element       ResultObj
     * 如果这个类下面有多个测试用例的话， 那么可以双击方法名称，然后右键执行该方法
     * @throws Exception
     */
    @Test
    public void whenQuerySuccess() throws Exception {
        mockMvc.perform(get("/user").param("username", "yuyi").contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("0"));
    }

    @Test
    public void whenGetInfoSuccess() throws Exception {
        mockMvc.perform(get("/user/1a")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * 写所有的代码之前，需要创建测试用例
     * @throws Exception
     */
    @Test
    public void whenCreateSuccess() throws Exception {
        //Date date = new Date();
        // 拿到一年以后的时间
        Date date = new Date(LocalDateTime.now()
                .plusYears(1).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        // 要用时间戳的形式；
        System.out.println(date.getTime());
        String content = "{ \"username\" : \"tom\", \"age\": null, \"birthday\": "+date.getTime()+"}";
        mockMvc.perform(post("/user/add")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
