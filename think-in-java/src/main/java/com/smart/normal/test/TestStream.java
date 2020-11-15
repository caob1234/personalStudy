
package com.smart.normal.test;

import net.mindview.simple.List;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;

/**
 * <p>
 *
 * @author <a href="mailto:caob@smartdot.com.cn">caob</a>
 * @version 1.0, 2020/11/12
 */
public class TestStream {
    public static void main(String[] args){
        ArrayList<User> userList= new ArrayList<User>();
        User u=new User();
        u.setPassword("1");
        u.setUsername("u");
        userList.add(u);
//        User u1=new User();
//        u1.setPassword("1");
//        u1.setUsername("o");
//        userList.add(u1);
//        for (int i = 0; i < 100; i++) {
//            User user=new User();
//            user.setUsername(i+"");
//            user.setPassword(i+"");
//            userList.add(user);
//        }
        boolean b=userList.stream().allMatch(e->e.getUsername().equals("u"));
        System.out.println(b);
    }
}
