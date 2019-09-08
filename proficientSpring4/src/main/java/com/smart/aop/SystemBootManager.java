package com.smart.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.OrderComparator;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.List;


@Component
public class SystemBootManager implements ApplicationListener<ContextRefreshedEvent> {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    private List<SystemBootAddon> systemBootAddons = Collections.EMPTY_LIST;
    private boolean hasRunOnce = false;

    @Autowired(required = false)
    public void setSystemBootAddons(List<SystemBootAddon> systemBootAddons){
        Assert.notEmpty(systemBootAddons,"it must contain at least a element");
        OrderComparator.sort(systemBootAddons);
        this.systemBootAddons = systemBootAddons;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (!hasRunOnce){
            for (SystemBootAddon systemBootAddon:systemBootAddons
                 ) {
                systemBootAddon.onReady();
                if (logger.isDebugEnabled()){
                    logger.debug("Excutive plugin:{}",systemBootAddon.getClass().getCanonicalName());
                }
            }
            hasRunOnce=true;
        }else{
            if (logger.isDebugEnabled()){
                logger.debug("container launch plugin set has been excuted,this time ignored");
            }
        }
    }
}
