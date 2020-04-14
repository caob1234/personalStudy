package com.smart.basic.complicating;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class GreenhouseScheduler {
    private volatile boolean light=false;
    private volatile boolean water=false;
    private String thermostat="Day";

    public synchronized String getThermostat() {
        return thermostat;
    }

    public synchronized void setThermostat(String thermostat) {
        this.thermostat = thermostat;
    }
    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor=new ScheduledThreadPoolExecutor(10);
    public void schedule(Runnable event,long delay){
        scheduledThreadPoolExecutor.schedule(event,delay, TimeUnit.MILLISECONDS);
    }
}
