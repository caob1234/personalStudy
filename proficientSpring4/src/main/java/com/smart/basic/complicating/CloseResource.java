package com.smart.basic.complicating;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

public class CloseResource {
    public static void main(String[] args)throws Exception{
        ExecutorService executorService= Executors.newCachedThreadPool();
        ServerSocket server=new ServerSocket(8080);
        InputStream socketInput=new Socket("localhost",8080).getInputStream();
        executorService.execute(new IOBlocked(socketInput));
        executorService.execute(new IOBlocked(System.in));
        TimeUnit.SECONDS.sleep(10);
        print("Shutting down all thread");
        executorService.shutdownNow();
        TimeUnit.SECONDS.sleep(2);
        print("Closing "+System.in.getClass().getName());
        System.in.close();//Release lock resource
        TimeUnit.SECONDS.sleep(2);
        print("Closing "+socketInput.getClass().getName());
        socketInput.close();//Release lock resource
    }
}
