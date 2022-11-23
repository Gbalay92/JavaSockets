package com.psp.gbl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloServidor extends Thread{
    BufferedReader flujoEntrada;
    PrintWriter flujoSalida;
    Socket socket;

    public HiloServidor(Socket socket) {
        try {
            this.flujoSalida = new PrintWriter(socket.getOutputStream(), true);
            this.flujoEntrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.socket = socket;
    }

    @Override
    public void run() {
        String cadena="";
        while(!cadena.trim().equals("*")){
            System.out.println("COMUNICA CON: "+  socket.toString());
            try {
                cadena=flujoEntrada.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            flujoSalida.println(cadena.trim().toUpperCase());
        }
        System.out.println("FIN CON: " + socket.toString());

        try {
            flujoSalida.close();
            flujoEntrada.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
