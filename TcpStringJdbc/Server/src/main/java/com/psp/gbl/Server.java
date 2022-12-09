package com.psp.gbl;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class Server {
    private static ArrayList<Object> obs=new ArrayList<Object>();
    public static void main( String[] args ) {
        try {
            Database.conexionSql();
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Server up..");
            Socket client = server.accept();
            DataInputStream in = new DataInputStream(client.getInputStream());
            String peticion=in.readUTF().toLowerCase();
            //System.out.println(peticion);

            ResultSet rs=Database.realizarConsulta(peticion);
            while(rs.next()){
                int id=rs.getInt(1);
                String marca=rs.getString(2);
                //System.out.println(id + marca);
                if(peticion.equals("coche")){
                    Coche c = new Coche(id, marca);
                    obs.add(c);
                } else if (peticion.equals("ordenador")) {
                    Ordenador o = new Ordenador(id, marca);
                    obs.add(o);
                }
            }

            ObjectOutputStream oos=new ObjectOutputStream(client.getOutputStream());
            oos.writeObject(obs);

            oos.close();
            in.close();
            client.close();
            server.close();



        } catch (SQLException e) {
            System.out.println("error al conectar con db");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
