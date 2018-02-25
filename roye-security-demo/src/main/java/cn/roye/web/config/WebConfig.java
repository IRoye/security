package cn.roye.web.config;


import cn.roye.web.filter.TimeFilter;
import cn.roye.web.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 在使用第三方的过滤器的时候, 就可以使用这个来配置
 *
 *
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{

    // 把拦截器声明为一个组件之后，现在可以注入了；
    @Autowired
    private TimeInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor);
    }

    @Bean
    public FilterRegistrationBean timerFilter(){

        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        // 自定义的 timeFilter
        TimeFilter timeFilter = new TimeFilter();

        registrationBean.setFilter(timeFilter);

        List<String> urls = new ArrayList<>();
        urls.add("/*");
        registrationBean.setUrlPatterns(urls);

        return registrationBean;
    }
}
