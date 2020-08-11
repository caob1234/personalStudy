package com.smart.socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestLocalIP {
    public static void main(String[] args){
        try {
            System.out.println("Local ip:"+InetAddress.getLocalHost().getCanonicalHostName());
            System.out.println("Local ip2:"+InetAddress.getLocalHost().getHostName());
            System.out.println("Local ip3:"+InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress("google.com", 80));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(socket.getLocalAddress().toString().substring(1));
    }
}
