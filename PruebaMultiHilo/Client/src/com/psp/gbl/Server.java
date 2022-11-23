package com.psp.gbl;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        ServerSocket server;
        try {
            server = new ServerSocket(6000);
            System.out.println("Server start..");
            while(true){
                Socket client=new Socket();
                client=server.accept();
                HiloServidor hilo=new HiloServidor(client);
                hilo.start();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
