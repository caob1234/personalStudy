package com.smart.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DaoConfig.class)
public class ServiceConfigC {
    @Bean
    public LogonService logonService(){
        LogonService logonService = new LogonService();
        return logonService;
    }
}
