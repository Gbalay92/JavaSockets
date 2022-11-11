package com.psp.sockets;

import java.io.*;
import java.net.Socket;

public class SocketTCPClient {
    private String serverIp;
    private int serverPort;
    private Socket socket;
    private InputStream is;
    private OutputStream os;
    private InputStreamReader isr;
    private BufferedReader br;
    private PrintWriter pw;

    public static void main(String[] args) {
        SocketTCPClient client = new SocketTCPClient("localhost", 49171);
        try {
            client.start();
            client.abrirCanalesDeTexto();
            client.enviarMensaje("mensaje enviado desde el CLIENTE");
            String mensajeRec=client.leerMensajes();
            System.out.println("Cliente: mensaje recibido "+ mensajeRec);
            client.cerrarCanales();
            client.stop();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public SocketTCPClient(String serverIp, int serverPort)  {
        this.serverIp=serverIp;
        this.serverPort=serverPort;
    }

    public void start() throws IOException {
        System.out.println("Cliente: estableciendo conexion..");
        socket=new Socket(serverIp, serverPort);
        os=socket.getOutputStream();
        is=socket.getInputStream();

        System.out.println("Cliente: conexion establecida.. ");
    }

    public void stop() throws IOException {
        System.out.println("Cliente: cerrando conexiones..");
        is.close();
        os.close();
        socket.close();
        System.out.println("Cliente: conexiones cerradas");
    }

    public void abrirCanalesDeTexto(){
        System.out.println("Cliente: abriendo canales de texto..");
        isr=new InputStreamReader(is);
        br=new BufferedReader(isr);
        pw=new PrintWriter(os, true);
        System.out.println("Cliente: canales de texto abiertos..");
    }

    public void cerrarCanales() throws IOException {
        System.out.println("Cliente: cerrando canales de texto..");
        pw.close();
        br.close();
        isr.close();
    }

    public String leerMensajes() throws IOException {
        System.out.println("Cliente: leyendo mensaje..");
        String mensaje=br.readLine();
        System.out.println("Cliente: mensaje leido..");
        return mensaje;
    }

    public void enviarMensaje(String mensaje){
        System.out.println("Cliente: enviando mensaje..");
        pw.println(mensaje);
        System.out.println("Cliente: mensaje enviado..");
    }
}
