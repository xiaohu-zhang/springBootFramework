package com.cmcc.mgr.dao;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

@CacheConfig(cacheNames = "properties")
public interface AcComcontractInfoMapper {
    @Cacheable
    int select1();
    void insert();

}
