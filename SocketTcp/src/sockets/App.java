package sockets;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class App {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto=6000;

        try {
            Socket client = new Socket(host,puerto);
            InetAddress i = client.getInetAddress();

            System.out.println("puerto local: " + client.getLocalPort());
            System.out.println("puerto remoto: "+ client.getPort());
            System.out.println("host remoto: "+ i.getHostName());
            System.out.println("ip host remoto: "+ i.getHostAddress());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
