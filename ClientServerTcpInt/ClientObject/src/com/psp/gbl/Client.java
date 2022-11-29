package com.psp.gbl;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        try {



            int[] numbers=new int[5];
            for (int i = 0; i < 5; i++) {
                System.out.println("Introduzca numero " + (i+1) +": ");
                int numero=new Scanner(System.in).nextInt();
                numbers[i]=numero;
            }
            Contenedor cont =new Contenedor(numbers);
            Socket client= new Socket(host, 6000);
            ObjectOutputStream salida= new ObjectOutputStream(client.getOutputStream());
            salida.writeObject(cont);


        salida.close();
        client.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
