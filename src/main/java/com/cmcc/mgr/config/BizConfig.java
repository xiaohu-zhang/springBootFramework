package com.cmcc.mgr.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.ClassPathResource;

import com.cmcc.mgr.filter.LogFilter;

@Configuration
@EnableCaching
@ImportResource(locations={"classpath:quartzJob.xml"})
public class BizConfig {
//    @Bean  
//    public FilterRegistrationBean  filterRegistrationBean() {  
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean();  
//        LogFilter logFilter = new LogFilter();  
//        registrationBean.setFilter(logFilter);  
//        registrationBean.setOrder(1);
//        registrationBean.addUrlPatterns("/*");
//        return registrationBean;  
//    }  
    


    
    
}
