package com.psp.gbl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor1Objeto {
    public static void main(String[] args) {
        int puerto=6000;
        try {
            ServerSocket server=new ServerSocket(puerto);
            System.out.println("Esperando al cliente..");
            Socket client=server.accept();


            ObjectOutputStream outObject=new ObjectOutputStream(client.getOutputStream());
            Persona person=new Persona("Juan", 20);
            outObject.writeObject(person);
            System.out.println("Envio: " + person.getNombre() + person.getEdad());

            ObjectInputStream inObject=new ObjectInputStream(client.getInputStream());
            Persona data= (Persona) inObject.readObject();
            System.out.println("Recibo: "+data.getNombre()+data.getEdad());

            outObject.close();
            inObject.close();
            client.close();
            server.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
