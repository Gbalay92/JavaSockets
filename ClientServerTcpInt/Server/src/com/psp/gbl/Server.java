package com.psp.gbl;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private static ArrayList<Integer> numbers = new ArrayList<Integer>();
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Server up..");
            Socket client = null;
            InputStream entrada = null;
            DataInputStream di = null;
            client = server.accept();
            for (int i = 0; i < 5; i++) {
                entrada = client.getInputStream();
                di = new DataInputStream(entrada);
                int numero = di.readInt();
                numbers.add(numero);
            }

            int[] numeros = new int[5];
            for (int i = 0; i < 5; i++) {
                numeros[i]=numbers.get(i);
            }

            new Thread((new Suma(numeros))).start();
            new Thread((new Mayor(numeros))).start();
            new Thread((new Primo(numeros))).start();


            di.close();
            entrada.close();
            client.close();
            server.close();




        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
