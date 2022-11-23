package com.psp.gbl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        int puerto=6000;

        try {
            Socket client=new Socket("localhost", puerto);
            PrintWriter flujoSalida=new PrintWriter(client.getOutputStream(), true);
            BufferedReader flujoEntrada=new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String cadena, eco="";
            System.out.print("Introduce cadena: ");
            cadena=in.readLine();
            while(cadena!=null){
                flujoSalida.println(cadena);
                eco=flujoEntrada.readLine();
                System.out.println("ECO: "+eco);
                System.out.print("Introduce cadena: ");
                cadena=in.readLine();

            }

            flujoSalida.close();
            flujoEntrada.close();
            in.close();
            client.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
