package com.cmcc.mgr.controller.model;

import java.util.Date;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.hibernate.validator.internal.util.privilegedactions.GetClassLoader;

public class ThreadLocalModel {
    public  static ThreadLocal<ThreadLocalModel> threadLocal = new InheritableThreadLocal<ThreadLocalModel>();
    
    private String remoteIp;
    private String localIp;
    private String treceId;
    private String url;
    private Date now;
    
    public String getRemoteIp() {
        return remoteIp;
    }
    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp;
    }
    public String getLocalIp() {
        return localIp;
    }
    public void setLocalIp(String localIp) {
        this.localIp = localIp;
    }
    public String getTreceId() {
        return treceId;
    }
    public void setTreceId(String treceId) {
        this.treceId = treceId;
    }
    
    public ThreadLocalModel(String remoteIp, String localIp, String treceId, String url, Date now) {
        super();
        this.remoteIp = remoteIp;
        this.localIp = localIp;
        this.treceId = treceId;
        this.url = url;
        this.now = now;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getUrl() {
        return url;
    }
    
    public static ThreadLocalModel getThreadLocal(){
        return threadLocal.get();
    }
    public Date getNow() {
        return now;
    }
    public void setNow(Date now) {
        this.now = now;
    }
    
    
    
    
}
