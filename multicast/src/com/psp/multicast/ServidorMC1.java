package com.psp.multicast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ServidorMC1 {
    public static void main(String[] args) {
        BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
        //se crea el socket multicast

        try {
            MulticastSocket ms = new MulticastSocket();
            int puerto=12345;
            InetAddress grupo = InetAddress.getByName("224.0.0.1");
            String cadena="";


            while (!cadena.trim().equals("*")){
                System.out.println("Datos a enviar al grupo: ");
                cadena=in.readLine();

                DatagramPacket paquete = new DatagramPacket(cadena.getBytes(),
                        cadena.length(), grupo, puerto);
                ms.send(paquete);
            }
            System.out.println("Socket cerrado..");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
