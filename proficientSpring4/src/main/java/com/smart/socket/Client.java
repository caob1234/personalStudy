package com.smart.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket client=new Socket("127.0.0.1",2003);
//        Scanner input=new Scanner(System.in);
        OutputStream os=client.getOutputStream();
        while(true){
//            String s=input.nextLine();
            os.write(System.in.read());
//            System.out.println(s);
        }
    }
}
