package com.emrekirman.glaceon.gateway.common.logging;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggingConfiguration {

    @Bean
    public FilterRegistrationBean<LoggingFilter> mdcContextFilter() {
        FilterRegistrationBean<LoggingFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new LoggingFilter());
        registrationBean.addUrlPatterns("/api/v1/*");
        registrationBean.setOrder(Integer.MAX_VALUE);
        return registrationBean;
    }
}