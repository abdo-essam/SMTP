import java.io.*;
import java.net.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

public class Server
{

    private static Timestamp ts;
    private static InetAddress serverAd;
    private static String serverHostName;
    private static String serverIP;
    private static int serverPort;

    public static void main(String[] args) throws IOException 
    {
        // Check if exactly one argument was passed
        if (args.length != 1) {
            System.err.println("Usage: <tcp-port-number>");
            System.exit(1);
        } 

        // check if client database exists
        if (!new File("db/").exists())
        {
            (new File("db/")).mkdir();
        }

        // get current path
        String path = System.getProperty("user.dir");
        // report various info to console
        System.out.println("Current path: " + path);
        
        serverAd = InetAddress.getLocalHost();
        
        serverIP = serverAd.getHostAddress();
        System.out.println("Internal IP: " + serverIP);
        
        serverHostName = serverAd.getHostName();
        System.out.println("Host Name: " + serverHostName);
        
        serverPort = Integer.parseInt(args[0]);
        System.out.println("Listening Port: " + serverPort);
        
        
        ts = new Timestamp(System.currentTimeMillis());
        System.out.println("Current Time: " + ts);

        
        boolean running = true;
        System.out.println("SMTP Server starting...");
        ServerSocket ss = new ServerSocket(serverPort) ;
        while (running) {
            Socket s = null;
            try 
            { 
                // socket object to receive incoming client requests 
                s = ss.accept(); 

                System.out.println("A new client is connected : " + s); 

                // obtaining input and out Streams 
                DataInputStream dis = new DataInputStream(s.getInputStream()); 
                DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 

                System.out.println("Assigning new thread for this client"); 

                // create a new thread object 
                Thread t =  new Responder(s, dis, dos, serverIP, serverHostName) ; 

                // Invoking the start() method 
                t.start(); 

            } 
            catch (Exception e){ 
                s.close();
                e.printStackTrace(); 
            }
        }
        System.out.println("Server closing..."); 
    }
}