package com.smart.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConf {
    @Bean
    public UserDao userDao(){
        return new UserDao();
    }
    @Bean
    public LogDao logDao(){
        return new LogDao();
    }

    @Bean
    public LogonService logonService(){
        LogonService loglonService = new LogonService();
        loglonService.setLogDao(logDao());
        loglonService.setUserDao(userDao());
        return loglonService;
    }
}
//    The above code is equivalent to the following xml
//    <bean id="userDao" class="com.smart.conf.UserDao"/>
//    <bean id="logDao" class="com.smart.conf.LogDao"/>
//    <bean id="logonService" class="com.smart.conf.LogonService"
//          p:logDao-ref="logDao" p:userDao-ref="userDao"/>