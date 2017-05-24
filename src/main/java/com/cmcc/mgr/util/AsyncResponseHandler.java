package com.cmcc.mgr.util;

@FunctionalInterface
public  interface AsyncResponseHandler{
    public abstract void handleResponse(String result);
    
}
