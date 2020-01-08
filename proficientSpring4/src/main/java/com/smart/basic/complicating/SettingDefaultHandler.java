package com.smart.basic.complicating;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SettingDefaultHandler {
    public static void main(String[] args){
        //setting default handler capture escape exception by static domain
        // when have't current current thread handler.
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService service= Executors.newCachedThreadPool();
        service.execute(new ExceptionThread());
        service.shutdown();
    }
}
