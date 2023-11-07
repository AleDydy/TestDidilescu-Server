package com.example;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            ServerSocket servsock= new ServerSocket(3000);
            int numerobiglietti=5;

            while(true){
                Socket s=servsock.accept();

                ServerThread thread=new ServerThread(numerobiglietti, s);
                thread.start();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
