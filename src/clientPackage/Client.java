package clientPackage;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Scanner;
import java.net.InetAddress;
public class Client {
    public static void main(String[] args) throws Exception {
        String serverIp="192.168.100.5";
        System.out.println("Je suis un client pas encore connecté...");
        Socket socket = new Socket(InetAddress.getByName(serverIp), 12345);
        System.out.println("Je suis un client connecté");
        Scanner scanner = new Scanner(System.in);
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        while (true) {
            System.out.println("\n--- MENU CALCULATRICE ---");
            System.out.println("1. ADDITION (x+5)");
            System.out.println("2. SOUSTRACTION (x-5)");
            System.out.println("3. MULTIPLICATION (x*5)");
            System.out.println("4. DIVISION (x/5)");
            System.out.println("0. QUITTER");
            System.out.println("Choisissez une opération:");
            int op = scanner.nextInt();
            dos.writeInt(op);
            dos.flush();
            if (op == 0) {break;}
            System.out.println("Tapez un entier x : ");
            int x = scanner.nextInt();
            dos.writeInt(x);
            dos.flush();
            int response = dis.readInt();
            System.out.println("Résultat du serveur =" + response);
        }
        socket.close();
        scanner.close();
    }
}
