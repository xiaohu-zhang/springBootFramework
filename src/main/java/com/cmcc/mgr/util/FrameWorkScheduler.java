package com.cmcc.mgr.util;

import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FrameWorkScheduler {
    @Scheduled(fixedRate = 30 * 1000)
    public void closeIdleConnections(){
        HttpUtil.getCm().closeIdleConnections(1, TimeUnit.MINUTES);
        HttpUtil.getSynManger().closeIdleConnections(1, TimeUnit.MINUTES);
    }
}
