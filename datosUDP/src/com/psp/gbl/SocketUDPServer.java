package com.psp.gbl;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class SocketUDPServer {
    public static void main(String[] args) {


        DatagramSocket socket;

        System.out.println("Servidor: creando socket..");

        try {
            socket = new DatagramSocket(49171);
            byte[] bufferLectura = new byte[10];

            DatagramPacket datagramaEntrada= new DatagramPacket(bufferLectura, bufferLectura.length);
            while(!new String(bufferLectura).trim().equals("FINsaje 49")) {
                socket.receive(datagramaEntrada);
                System.out.println("Servidor: " + new String(bufferLectura).trim());
            }

            byte[] mensajeEnviado= new String("Mensaje enviado desde el servidor").getBytes();
            DatagramPacket datagramaSalida = new DatagramPacket(mensajeEnviado, mensajeEnviado.length,
                    datagramaEntrada.getAddress(), datagramaEntrada.getPort());
            socket.send(datagramaSalida);
            System.out.println("Servidor: cerrando socket..");
            socket.close();






        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
