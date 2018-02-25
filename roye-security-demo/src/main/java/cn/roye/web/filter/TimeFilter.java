package cn.roye.web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * 关于过滤器的使用，
 * 自定义的过滤器， 可以通过@Component来让spring识别；
 * 第三方的过滤器是没有办法使用 @Component的
 * 现在可以去掉 @Component 来模拟一个第三方的过滤器
 * 第三方的过滤器， 使用的是web.xml来进行配置；
 * spring boot 没有配置文件应该怎么办
 * 如何把一个普通的类加到过滤器链上去呢？
 *
 *
 *
 * 拦截器的限制就是只能拿到http的请求和响应，只能从请求响应里面拿到一些参数；
 * 但是这个请求是由那个控制器的哪个方法来处理的， 是无法知道的
 *
 * Filter  J2EE 是规范中的东西；
 * 是无法获取到spring 的东西的；
 *
 */
@Component
public class TimeFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("time filter init!");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("time filter start!");
        long start = new Date().getTime();
        chain.doFilter(request, response);
        System.out.println("time filter finish!耗时：" + (new Date().getTime() - start));
        System.out.println("time filter finish!");
    }

    @Override
    public void destroy() {
        System.out.println("time filter destory");
    }
}
