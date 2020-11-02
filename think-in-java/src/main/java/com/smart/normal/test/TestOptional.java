
package com.smart.normal.test;

import java.util.Optional;

/**
 * <p>
 *
 * @author caob
 * @version 1.0, 2020/10/26
 */
public class TestOptional {
    public static void main(String[] args){
        String s="Hello world!";
        String s1=null;
        Optional optionalS= Optional.of(s);
        Optional optionalS1=Optional.ofNullable(s1);
        System.out.println(optionalS.get());
        System.out.println(optionalS1.orElse("This is null"));
        System.out.println(optionalS.isPresent()+"|"+optionalS1.isPresent());
        System.out.println(FlowLockStatus.values()[0]);
    }
}
