import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        try {
            Socket client= new Socket(host, 6000);
            OutputStream salida= null;
            DataOutputStream dos =  null;
            for (int i = 0; i < 5; i++) {
                dos =  new DataOutputStream(client.getOutputStream());
                System.out.print("Introduzca numero " + (i+1) +": ");
                int numero=new Scanner(System.in).nextInt();
                dos.writeInt(numero);
            }

            DataInputStream in = new DataInputStream(client.getInputStream());
            System.out.println("El numero mayor es: " + in.readInt());
            System.out.println("la suma de los numeros es: " + in.readInt());
            System.out.println("son numeros primos: "+ in.readUTF());

            dos.close();
            client.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
