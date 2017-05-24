package com.cmcc.mgr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RestController;

import com.cmcc.mgr.config.BizConfig;
import com.cmcc.mgr.config.DataBasePerperties;
import com.cmcc.mgr.controller.model.ipresent.PresentInputMoneyModel;
import com.cmcc.mgr.validator.TimePatternValidator;


@RestController
@SpringBootApplication
@EnableConfigurationProperties(DataBasePerperties.class)
@EnableTransactionManagement
@EnableCaching
@EnableScheduling
public class Application extends SpringBootServletInitializer {
    

    public static void main(String[] args) throws Exception {
        SpringApplication  p =new SpringApplication(Application.class);
        p.run(args);
    }
    
    @Override  
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {  
        return application.sources(Application.class);  
    }

}
