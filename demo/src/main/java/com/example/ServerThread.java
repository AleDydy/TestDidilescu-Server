package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThread extends Thread{
    protected int numerobiglietti;
    protected Socket socket;

    public ServerThread(int number, Socket socket) {
        this.numerobiglietti = number;
        this.socket = socket;
    }

    @Override
    public void run(){
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            boolean exit=true;

            while (exit == true) {

                String messagereceived = in.readLine();

                if(messagereceived.equals("D")){
                    if(numerobiglietti==5){
                        out.writeBytes("5." + "\n");
                    }
                    if(numerobiglietti==4){
                        out.writeBytes("4." + "\n");
                    }
                    if(numerobiglietti==3){
                        out.writeBytes("3." + "\n");
                    }
                    if(numerobiglietti==2){
                        out.writeBytes("2." + "\n");
                    }
                    if(numerobiglietti==1){
                        out.writeBytes("1." + "\n");
                    }
                    if(numerobiglietti==0){
                        out.writeBytes("." + "\n");
                    }
                }

                if(messagereceived.equals("A")){
                    if(numerobiglietti!=0){
                        numerobiglietti--;
                        out.writeBytes("@" + "\n");
                    }
                    else{
                        out.writeBytes("." + "\n");
                    }
                }

                if(messagereceived.equals("Q")){
                    out.writeBytes(".." + "\n");
                    exit=false;
                }
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }


}
