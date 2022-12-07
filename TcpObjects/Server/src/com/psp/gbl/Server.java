package com.psp.gbl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.*;

public class Server {
    private static ArrayList<Contenedor> cont = new ArrayList<Contenedor>();
    private static ArrayList<HiloServer> clients =new ArrayList<HiloServer>();
    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(6000);
            System.out.println("Server up..");
            Socket client=null;
            for (int i = 0; i < 5; i++) {
                client = server.accept();
                ObjectInputStream entrada = new ObjectInputStream(client.getInputStream());
                Contenedor contenedor=(Contenedor) entrada.readObject();
                cont.add(contenedor);
                clients.add(new HiloServer(client,null));

            }
            Operaciones op= new Operaciones(cont);
            ExecutorService service= Executors.newSingleThreadExecutor();
            Future<Resultado> result = service.submit(op);

            for(HiloServer hs:clients) {

               hs.setResult(result.get());
               new Thread(hs).start();

            }

            server.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}