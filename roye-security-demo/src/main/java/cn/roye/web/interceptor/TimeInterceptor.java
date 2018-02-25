package cn.roye.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 比拦截器的好处就在于方法的第三个参数： Object handler
 * 是真正用来用来处理请求的控制器的方法的说明；
 *
 * 光加上Component是不能让拦截器起作用的， 还需要有配置；
 *
 * 注意的地方就是：不光是自己定义的controller 会被拦截，spring 的controller 也是会被拦截的；
 * 拦截器能拿到的是请求， 响应， 以及处理请求和响应的那个方法
 *
 * 问题：
 * 拿不到 具体执行的那个方法的参数
 */
@Component
public class TimeInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        request.setAttribute("start", new Date().getTime());
        System.out.println("pre");
        System.out.println(((HandlerMethod)handler).getBean().getClass().getName());
        System.out.println(((HandlerMethod)handler).getMethod().getName());

        //只有当这里的返回值是true的情况下，才会执行最后的afterCompletion
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("post");

        Long start = (Long) request.getAttribute("start");
        System.out.println("耗时：" + (new Date().getTime() - start));
    }

    /**
     * 必须是preHandle返回值是true的情况下
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("不执行！");

        // 这里异常没有的原因是之前把异常给处理掉了
        // ControllerExceptionHandler
        System.out.println(ex);
    }
}
