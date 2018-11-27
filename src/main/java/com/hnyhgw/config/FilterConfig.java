package com.hnyhgw.config;

import com.hnyhgw.filter.ProjectNameFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {


    @Bean
    public FilterRegistrationBean registFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new ProjectNameFilter());
        registration.addUrlPatterns("/*");
        registration.setName("ProjectNameFilter");
        registration.setOrder(1);
        return registration;
    }

    @Bean
    public FilterRegistrationBean registFilterManage(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new ProjectNameFilter());
        registration.addUrlPatterns("/manage/");
        registration.setName("ProjectNameFilter");
        registration.setOrder(1);
        return registration;
    }

}
