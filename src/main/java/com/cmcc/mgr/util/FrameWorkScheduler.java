package com.cmcc.mgr.util;

import java.util.concurrent.TimeUnit;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import com.cmcc.mgr.dao.AcComcontractInfoMapper;

@Component
public class FrameWorkScheduler {
    @Scheduled(fixedRate = 30 * 1000)
    public void closeIdleConnections() throws InterruptedException{
        HttpUtil.getCm().closeIdleConnections(1, TimeUnit.MINUTES);
        HttpUtil.getSynManger().closeIdleConnections(1, TimeUnit.MINUTES);
        
    }
    
    @Autowired
    private AcComcontractInfoMapper acComcontractInfoMapper;

    public void test() throws InterruptedException{
        System.out.println("test:"+Thread.currentThread().getName());
        System.out.println(String.valueOf(acComcontractInfoMapper.select1()));
    }

    
    
}
