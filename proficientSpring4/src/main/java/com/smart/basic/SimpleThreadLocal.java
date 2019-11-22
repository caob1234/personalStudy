package com.smart.basic;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SimpleThreadLocal<T> implements SimpleThreadLocalService<T> {
    private Map valueMap = Collections.synchronizedMap(new HashMap());
    public void set(T newValue){
        valueMap.put(Thread.currentThread(),newValue);
    }
    public T get(){
        Thread currentThread = Thread.currentThread();
        T o = (T) valueMap.get(currentThread);
        if (o == null && !valueMap.containsKey(currentThread)){
            o = initialValue();
            valueMap.put(currentThread,o);
            set(o);
        }
        return o;
    }
    public void remove(){
        valueMap.remove(Thread.currentThread());
    }
    public T initialValue(){
        return null;
    }
}
