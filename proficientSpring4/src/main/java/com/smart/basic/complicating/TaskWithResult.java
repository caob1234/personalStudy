package com.smart.basic.complicating;

import java.util.concurrent.Callable;

public class TaskWithResult implements Callable<String> {
    private int id;
    public TaskWithResult(int id) {
        this.id=id;
    }

    @Override
    public String call() throws Exception {
//        Thread.sleep(3000);
        return Thread.currentThread().getName()+"//result of TaskWithResult "+ id;
    }
}
