package serverPackage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
public class Server {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket=new ServerSocket();
        InetAddress localAddr=InetAddress.getByName("0.0.0.0");
        serverSocket.bind(new InetSocketAddress(localAddr,12345));
        System.out.println("Je suis un serveur en attente la connexion d'un client");
        Socket clientSocket=serverSocket.accept();
        System.out.println("un client est connecté");
        DataInputStream dis=new DataInputStream(clientSocket.getInputStream());
        DataOutputStream dos=new DataOutputStream(clientSocket.getOutputStream());
        while(true){
            int op=dis.readInt();
            if(op==0){
                break;
            }
            int x=dis.readInt();
            int res=0;
            if(op==1) res=x+5;
            else if (op==2) res=x-5;
            else if (op==3) res=x*5;
            else if (op==4) res=x/5;
            dos.writeInt(res);
            dos.flush();
        }
        clientSocket.close();
        serverSocket.close();
    }
}
