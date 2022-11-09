package testinetadress;

import java.net.*;

public class App {
    public static void main(String[] args) {

        InetAddress dir =null;
        System.out.println("SALIDA PARA LOCALHOST: ");




        try {
            dir=InetAddress.getByName("LAPTOP-635RC3G7");
            pruebaMetodos(dir);

            //youtube.es
            System.out.println("================");
            System.out.println("SALIDA PARA EL URL: ");
            dir=InetAddress.getByName("www.youtube.com");
            pruebaMetodos(dir);


            //array de inetadress

            System.out.println("\tDIRECCIONES IP PARA: " + dir.getHostName());
            InetAddress[] direcciones= InetAddress.getAllByName(dir.getHostName());
            for (int i = 0; i < direcciones.length; i++) {
                System.out.println(direcciones[i].toString());
                System.out.println("================");


            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

    }

    private static void pruebaMetodos(InetAddress dir) {
        System.out.println("\tMetodo getByName(): "+dir);
        InetAddress dir2;

        try {
            dir2=InetAddress.getLocalHost();
            System.out.println("\tMetodo getLocalHost(): "+dir2);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\tMetodo getHostName: "+dir.getHostName());
        System.out.println("\tMetodo getHostAddress: "+dir.getHostAddress());
        System.out.println("\tMEtodo toString: "+ dir);
        System.out.println("\tMetodo getcanonicalHostName: "+dir.getCanonicalHostName());

    }
}
