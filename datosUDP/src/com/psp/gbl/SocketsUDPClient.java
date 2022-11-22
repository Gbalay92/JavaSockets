package com.psp.gbl;

import java.io.IOException;
import java.net.*;

public class SocketsUDPClient {

    public static void main(String[] args) {

        String mensaje="mensaje ";
        DatagramSocket socketUdp = null;
        try {
            socketUdp = new DatagramSocket();

        System.out.println("Cliente: estableciendo parametros de conexión ");

            InetAddress hostServer = InetAddress.getByName("localhost");
            int puertoServer = 49171;
            System.out.println("cliente: creando socket");
            DatagramPacket peticion;
            for (int i = 0; i < 50; i++) {
                mensaje="mensaje " + i;
                peticion = new DatagramPacket(mensaje.getBytes(), mensaje.length(), hostServer, puertoServer);
                socketUdp.send(peticion);

            }
            mensaje="FIN";
            peticion = new DatagramPacket(mensaje.getBytes(), mensaje.length(), hostServer, puertoServer);
            socketUdp.send(peticion);


            socketUdp.close();
            System.out.println("cliente cerrado");


        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }  catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
