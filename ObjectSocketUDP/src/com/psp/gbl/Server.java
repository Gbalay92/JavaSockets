package com.psp.gbl;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) {
        DatagramSocket socket;

        System.out.println("creando servidor..");

        try {
            socket=new DatagramSocket(49171);
            byte[] buffer=new byte[1024];

            DatagramPacket datagramaEntrada = new DatagramPacket(buffer, buffer.length);
            socket.receive(datagramaEntrada);
            ByteArrayInputStream bais =new ByteArrayInputStream(buffer);
            ObjectInputStream in = new ObjectInputStream(bais);
            Persona person = (Persona) in.readObject();
            System.out.println(person.getNombre() + person.getEdad());
            in.close();

            person.setEdad(21);
            person.setNombre("Pablo");


            ByteArrayOutputStream bs = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bs);
            out.writeObject(person);
            out.close();
            byte[] bytes = bs.toByteArray();


            DatagramPacket datagramaSalida = new DatagramPacket(bytes, bytes.length,
                    datagramaEntrada.getAddress(), datagramaEntrada.getPort());
            socket.send(datagramaSalida);

            socket.close();
            System.out.println("Server cerrado");
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
