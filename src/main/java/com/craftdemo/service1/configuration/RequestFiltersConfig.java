package com.craftdemo.service1.configuration;

import com.craftdemo.requestfilter.LoggingFilter;
import com.craftdemo.requestfilter.TracingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RequestFiltersConfig {
    public RequestFiltersConfig() {
    }

    @Bean
    public FilterRegistrationBean<TracingFilter> tracingFilter() {
        FilterRegistrationBean<TracingFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new TracingFilter());
        registrationBean.setFilter(new TracingFilter());
        registrationBean.setOrder(1);
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<LoggingFilter> loggingFilter() {
        FilterRegistrationBean<LoggingFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new LoggingFilter());
        registrationBean.setFilter(new LoggingFilter());
        registrationBean.setOrder(2);
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
