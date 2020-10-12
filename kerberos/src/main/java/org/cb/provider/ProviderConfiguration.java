package org.cb.provider;

import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableDubbo(scanBasePackages = "org.cb.provider")
@PropertySource("classpath:/spring/dubbo-provider.properties")
public class ProviderConfiguration {
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://104.168.219.106:2181");
        return registryConfig;
    }
}
