package com.smart.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Autowired
    private LogDao logDao;

    @Bean
    public LogonService logonService(){
        LogonService logonService = new LogonService();
        logonService.setLogDao(logDao);
        return logonService;
    }
}
