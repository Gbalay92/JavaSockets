package com.psp.gbl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente1Obj {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto=6000;
        System.out.println("Programa cliente iniciado..");
        Socket client = null;
        try {
            client = new Socket(host,puerto);
            ObjectInputStream personEntry = new ObjectInputStream(client.getInputStream());

            Persona data = (Persona) personEntry.readObject();
            data.setNombre("Gonzalo");
            data.setEdad(30);

            ObjectOutputStream personOut=new ObjectOutputStream(client.getOutputStream());

            personOut.writeObject(data);
            System.out.println("Envio: "+ data.getNombre() + data.getEdad());

            personEntry.close();
            personOut.close();
            client.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
