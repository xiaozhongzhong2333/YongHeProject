package com.zb.utils;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements javax.servlet.Filter {//实现过滤器的功能 需要实现Filter接口
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化过滤器");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器准备就绪");
        //通过过滤器设置编码
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        //放行 执行后续操作
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }

}
