package com.psp.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ClienteMC1 {
    public static void main(String[] args) {
        int puerto=12345;
        try {
            MulticastSocket ms= new MulticastSocket(puerto);
            InetAddress grupo=InetAddress.getByName("224.0.0.1");

            ms.joinGroup(grupo);
            String msg="";
            byte[] buff= new byte[1024];
            while(!msg.trim().equals("*")){
                DatagramPacket pqt = new DatagramPacket(buff, buff.length);
                ms.receive(pqt);
                msg= new String(pqt.getData());
                System.out.println("Recibo: " + msg.trim());
            }
            ms.leaveGroup(grupo);
            ms.close();
            System.out.println("Socket cerrado...");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
