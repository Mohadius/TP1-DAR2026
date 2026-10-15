package serverPackage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket=new ServerSocket(12345);
        System.out.println("Je suis un serveur en attente la connexion d'un client");
        Socket clientSocket=serverSocket.accept();
        System.out.println("un client est connecté");
        DataInputStream dis=new DataInputStream(clientSocket.getInputStream());
        DataOutputStream dos=new DataOutputStream(clientSocket.getOutputStream());
        while(true){
            int x=dis.readInt();
            if(x==0){
                break;
            }
            int res=x*5;
            dos.writeInt(res);
            dos.flush();
        }
        clientSocket.close();
        serverSocket.close();
    }
}
