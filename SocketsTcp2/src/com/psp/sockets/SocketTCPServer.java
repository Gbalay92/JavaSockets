package com.psp.sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCPServer {
    private ServerSocket serverSocket;
    private Socket socket;
    private InputStream is;
    private OutputStream os;

    private InputStreamReader isr;
    private BufferedReader br;
    private PrintWriter pw;

    public static void main(String[] args) {
        try {
            SocketTCPServer server = new SocketTCPServer(49171);
            server.start();
            server.abrirCanalesDeTexto();

            String mensajeRec= server.leerMensajes();
            System.out.println("Servidor: mensaje recibido: "+ mensajeRec);

            server.enviarMensaje("mensaje enviado desde SERVIDOR");
            server.cerrarCanales();
            server.stop();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public SocketTCPServer(int puerto) throws IOException {
        serverSocket=new ServerSocket(puerto);
    }

    public void start() throws IOException {
        System.out.println("Servidor: Esperando conexiones..");
        socket=serverSocket.accept();
        is=socket.getInputStream();
        os=socket.getOutputStream();
        System.out.println("Servidor: conexion establecida..");
    }

    public void stop() throws IOException {
        System.out.println("Servidor: cerrando conexiones..");
        is.close();
        os.close();
        socket.close();
        serverSocket.close();
        System.out.println("Servidor: conexiones cerradas..");
    }

    public void abrirCanalesDeTexto(){
        System.out.println("Servidor: abriendo canales de texto..");
        isr=new InputStreamReader(is);
        br=new BufferedReader(isr);
        pw=new PrintWriter(os, true);
        System.out.println("Servidor: canales de texto abiertos");
    }

    public void cerrarCanales() throws IOException {
        System.out.println("Servidor: cerrar canales de texto..");
        br.close();
        isr.close();
        pw.close();
        System.out.println("Servidor: canales de texto cerrados..");
    }

    public String leerMensajes() throws IOException {
        System.out.println("Servidor: leer mensajes de texto..");
        String mensaje=br.readLine();
        System.out.println("Servidor: mensaje leido.");
        return mensaje;
    }

    public void enviarMensaje(String mensaje){
        System.out.println("servidor: enviando mensaje..");
        pw.println(mensaje);
        System.out.println("servidor: mensaje enviado");
    }

}
