package com.smart.basic.complicating;

import java.util.concurrent.ThreadFactory;

public class DaemonThreadFactory  implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t= new Thread(r);
//        t.setDaemon(true);
        t.setPriority(Thread.MAX_PRIORITY);
        return t;
    }
}
