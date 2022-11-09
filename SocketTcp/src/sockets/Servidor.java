package sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        int puerto=6000;
        try {
            ServerSocket server = new ServerSocket(puerto);
            System.out.println("escuchando: " + server.getLocalPort());
            Socket cliente1= server.accept();
            Socket cliente2= server.accept();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
