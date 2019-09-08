package com.smart.aop;


import org.springframework.core.Ordered;

public interface SystemBootAddon extends Ordered {
    void onReady();
}
