package com.psp.gbl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
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

            Mayor mayor=new Mayor(numeros);
            ExecutorService servicio= Executors.newSingleThreadExecutor();
            Future<Integer> resultado= servicio.submit(mayor);
            System.out.println("server: " +resultado.get());

            Suma suma = new Suma(numeros);
            ExecutorService servicio1= Executors.newSingleThreadExecutor();
            Future<Integer> resultado1= servicio1.submit(suma);
            System.out.println("server: " +resultado1.get());

            Primo primo = new Primo(numeros);
            ExecutorService servicio2= Executors.newSingleThreadExecutor();
            Future<String> resultado2= servicio2.submit(primo);
            System.out.println("server: " + resultado2.get());

            DataOutputStream out =new DataOutputStream(client.getOutputStream());
            out.writeInt(resultado.get());
            out.writeInt(resultado1.get());
            out.writeUTF(resultado2.get());


            out.close();
            di.close();
            entrada.close();
            client.close();
            server.close();




        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
