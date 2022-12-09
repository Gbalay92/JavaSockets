package com.psp.gbl;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Client {
    public static void main( String[] args ) {
        String host = "localhost";
        int puerto=6000;
        System.out.print("introduzca consulta(coche/ordenador): ");
        String peticion=new Scanner(System.in).next();

        try {
            Socket client= new Socket(host, puerto);
            DataOutputStream in = new DataOutputStream(client.getOutputStream());
            in.writeUTF(peticion);

            ObjectInputStream oiu=new ObjectInputStream(client.getInputStream());
            ArrayList<Object> obs= (ArrayList<Object>) oiu.readObject();
            for(Object o: obs){
                if (peticion.equalsIgnoreCase("coche")){
                    Coche c = (Coche) o;
                    System.out.println(c.getId()+" "+ c.getMarca());
                } else if (peticion.equalsIgnoreCase("ordenador")) {
                    Ordenador or =(Ordenador) o;
                    System.out.println(or.getId()+" "+ or.getMarca());
                }
            }





        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
