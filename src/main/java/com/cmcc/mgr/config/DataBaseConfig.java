package com.cmcc.mgr.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

@Configuration
public class DataBaseConfig {

    
    @Bean
    public BasicDataSource getDateSource(DataBasePerperties dataBasePerperties){
        BasicDataSource dataSource = new BasicDataSource();
        propertiesSet(dataSource,dataBasePerperties);
        return dataSource;
    }
    
    @Bean(name="sqlSessionFactory")
    public SqlSessionFactory getSqlSessionFactoryBean(BasicDataSource dataSource) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:sqlmapper/*Mapper.xml"));
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }
    
    
    @Bean
    public static MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.cmcc.mgr.dao");
        return mapperScannerConfigurer;
    }

    private void propertiesSet(BasicDataSource dataSource,DataBasePerperties dataBasePerperties) {
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername(dataBasePerperties.getUsername());
        dataSource.setUrl(dataBasePerperties.getUrl());
        dataSource.setPassword(dataBasePerperties.getPassword());
        dataSource.setMaxActive(dataBasePerperties.getMaxActive());
        dataSource.setMaxIdle(dataBasePerperties.getMaxIdle());
        dataSource.setMaxWait(dataBasePerperties.getMaxWait());
        dataSource.setDefaultAutoCommit(true);
        dataSource.setMinEvictableIdleTimeMillis(3600000l);
        dataSource.setTimeBetweenEvictionRunsMillis(600000l);
        dataSource.setNumTestsPerEvictionRun(-1);
    }
    
//  @Bean
//  @Order(value=3)
//  public MapperFactoryBean getMapperFactoryBean(SqlSessionFactory sqlSessionFactory) throws Exception{
//      MapperFactoryBean MapperFactoryBean = new MapperFactoryBean();
//      MapperFactoryBean.setSqlSessionFactory(sqlSessionFactory);
//      MapperFactoryBean.setMapperInterface(mapperInterface);
//      return MapperFactoryBean;
//  }


    
    
}
