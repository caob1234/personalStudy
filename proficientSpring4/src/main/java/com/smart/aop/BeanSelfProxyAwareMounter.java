package com.smart.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class BeanSelfProxyAwareMounter implements SystemBootAddon, ApplicationContextAware {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void onReady() {
        Map<String,BeanSelfProxyAware> proxyAwareMap=
                applicationContext.getBeansOfType(BeanSelfProxyAware.class);
        if (proxyAwareMap!=null){
            for (BeanSelfProxyAware beanSelfProxyAware:proxyAwareMap.values()
                 ) {
                beanSelfProxyAware.setSelfProxy(beanSelfProxyAware);
                if (logger.isDebugEnabled()){
                    logger.debug("{}register an instance of its own proxy");
                }
            }
        }
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}
