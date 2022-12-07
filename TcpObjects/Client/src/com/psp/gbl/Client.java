package com.psp.gbl;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        System.out.println("cliente..");
        System.out.print("introduzca un numero: ");
        int numb=new Scanner(System.in).nextInt();
        boolean comp=true;
        if(numb%2==0){
            comp=false;
        }
        Contenedor cont = new Contenedor(numb, comp);
        Socket client= null;
        try {
            client = new Socket(host, 6000);
            ObjectOutputStream salida= new ObjectOutputStream(client.getOutputStream());
            salida.writeObject(cont);

            ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
            Resultado res= (Resultado) ois.readObject();
            System.out.println("resultado de 1= "+res.getSuma1()+ " resultado de 2= "+ res.getSuma2());

            ois.close();
            salida.close();
            client.close();



        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}