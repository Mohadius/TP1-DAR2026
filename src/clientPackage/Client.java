package clientPackage;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Scanner;
public class Client {
    public static void main(String[] args) throws Exception {
        System.out.println("Je suis un client pas encore connecté...");
        Socket socket = new Socket("127.0.0.1", 12345);
        System.out.println("Je suis un client connecté");
        Scanner scanner = new Scanner(System.in);
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        while (true) {
            System.out.println("Tapez un entier x : ");
            int x = scanner.nextInt();
            dos.writeInt(x);
            dos.flush();
            if (x == 0) {break;}
            int response = dis.readInt();
            System.out.println("Résultat du serveur =" + response);
        }
        socket.close();
        scanner.close();
    }
}
