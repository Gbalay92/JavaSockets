package com.psp.gbl;


import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        Persona person = new Persona("Gonzalo", 30);


        try {
            DatagramSocket  socketUdp=new DatagramSocket();
            InetAddress host=InetAddress.getByName("localhost");
            int port=49171;
            DatagramPacket envio;
            ByteArrayOutputStream bs = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bs);
            out.writeObject(person);
            out.close();
            byte[] bytes = bs.toByteArray();
            envio=new DatagramPacket(bytes, bytes.length, host, port);
            socketUdp.send(envio);

            byte[] buffer=new byte[1024];
            DatagramPacket datagramaEntrada = new DatagramPacket(buffer, buffer.length);
            socketUdp.receive(datagramaEntrada);
            ByteArrayInputStream bais =new ByteArrayInputStream(buffer);
            ObjectInputStream in = new ObjectInputStream(bais);
            person = (Persona) in.readObject();
            System.out.println(person.getNombre() + person.getEdad());
            in.close();

            socketUdp.close();
            System.out.println("cliente cerrado");
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
