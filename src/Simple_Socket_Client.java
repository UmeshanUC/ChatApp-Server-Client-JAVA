import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;


public class Simple_Socket_Client {
    static int PORT = 4040; //Server PORT

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        System.out.println("_____Simple Socket Client______");

        //127.0.0.1
        InetAddress localIp = InetAddress.getLocalHost();

        Socket sock = new Socket(localIp, PORT);

        InputStreamReader isr = new InputStreamReader(sock.getInputStream());
        BufferedReader in = new BufferedReader(isr);
        PrintWriter out = new PrintWriter(sock.getOutputStream(), true);


        try {
            System.out.println("Connected to Server");

            while (true) {
                if(in.ready()){
                    System.out.println("Received: " + in.readLine());
                }

                System.out.print("Send: ");
                out.println(scan.nextLine());
            }
        } finally {
            sock.close();
            out.close();
            in.close();
        }
    }
}
