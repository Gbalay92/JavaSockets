package com.psp.gbl;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Server {
    private static ArrayList<Integer> numbers = new ArrayList<Integer>();
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Server up..");
            Socket client = server.accept();
            ObjectInputStream entrada = new ObjectInputStream(client.getInputStream());
            Contenedor cont=(Contenedor) entrada.readObject();

            ExecutorService servicio= Executors.newSingleThreadExecutor();
            Future<Contenedor> mayor=servicio.submit(new Mayor(cont.getNumbers()));

            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            out.writeObject(mayor.get());


            out.close();
            entrada.close();
            client.close();
            server.close();




        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
