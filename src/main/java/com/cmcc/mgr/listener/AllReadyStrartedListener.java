package com.cmcc.mgr.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class AllReadyStrartedListener implements ApplicationListener<ApplicationReadyEvent> {

    private Logger logger = LoggerFactory.getLogger(AllReadyStrartedListener.class);
    
    public void onApplicationEvent(ApplicationReadyEvent event) {
        logger.info("the project Mgr started already ...");
        
    }

}
