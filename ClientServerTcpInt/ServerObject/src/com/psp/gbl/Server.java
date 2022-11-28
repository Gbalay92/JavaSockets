package com.psp.gbl;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private static ArrayList<Integer> numbers = new ArrayList<Integer>();
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Server up..");
            Socket client = server.accept();
            ObjectInputStream entrada = new ObjectInputStream(client.getInputStream());
            Contenedor cont=(Contenedor) entrada.readObject();

            new Thread((new Suma(cont.getNumbers()))).start();
            new Thread((new Mayor(cont.getNumbers()))).start();
            new Thread((new Primo(cont.getNumbers()))).start();



            entrada.close();
            client.close();
            server.close();




        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
