package com.creasy.openai.config;

import com.creasy.openai.filter.AuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<AuthenticationFilter> authenticationFilter() {
        FilterRegistrationBean<AuthenticationFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new AuthenticationFilter());
        //这里很奇怪，按理说/api/**能匹配所有/api/下的一级&多级子路径，但测试时，只有/api/*能匹配
        registrationBean.addUrlPatterns("/api/*"); // 设置过滤的URL模式
        return registrationBean;
    }

}
