package com.creasy.openai.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 在这里执行过滤逻辑，例如鉴权、请求日志等
        String authorizationStr = ((HttpServletRequest)servletRequest).getHeader("AuthorizationStr");
        if(!"24342751f59b90938a65df68eae508f1".equals(authorizationStr)){
            servletResponse.getOutputStream().println("You are not allow to use this service!");
            return;
        }
        // 调用链中的下一个过滤器，或者最终的请求处理器
        filterChain.doFilter(servletRequest, servletResponse);

        // 在请求处理完成后可以进行后处理操作
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
