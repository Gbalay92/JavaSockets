package com.psp.gbl;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class HiloServer implements Runnable{
    private Socket socket;
    private Resultado result;

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public Resultado getResult() {
        return result;
    }

    public void setResult(Resultado result) {
        this.result = result;
    }

    public HiloServer(Socket socket, Resultado result) {
        this.socket = socket;
        this.result = result;
    }

    @Override
    public void run() {
        ObjectOutputStream salida = null;
        try {
            salida = new ObjectOutputStream(socket.getOutputStream());

            salida.writeObject(result);
            salida.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
