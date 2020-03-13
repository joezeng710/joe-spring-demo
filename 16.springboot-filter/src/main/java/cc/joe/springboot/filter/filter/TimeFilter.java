package cc.joe.springboot.filter.filter;


import cc.joe.springboot.filter.utils.TimeUtils;

import javax.servlet.*;
import java.io.IOException;

public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("开始执行过滤器");
        long start = TimeUtils.getTime();
        chain.doFilter(request, response);
        long end = TimeUtils.getTime();
        System.out.println("filter consuming time:" + (end - start));
        System.out.println("结束过滤行为");

    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
