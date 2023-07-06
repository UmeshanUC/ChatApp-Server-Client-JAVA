import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Simple_Sock_Server {
    static int PORT = 4040;

    public static void main(String[] args) throws IOException {
        System.out.println("___Simple Socket Server_____");

        ServerSocket serverSocket = new ServerSocket(PORT);

        try {
            while (true) {
                AcceptClient(serverSocket);
            }
        } finally {
            serverSocket.close();
        }
    }

    private static void AcceptClient(ServerSocket serverSocket) throws IOException {
        Socket client = serverSocket.accept();
        System.out.println("client: " + client.getRemoteSocketAddress().toString() + " connected");

        Scanner scan = new Scanner(System.in);
        InputStreamReader isr = new InputStreamReader(client.getInputStream());
        BufferedReader in = new BufferedReader(isr);

        PrintWriter out = new PrintWriter(client.getOutputStream(), true);

        try {
            while (true) {
                if (in.ready()) {
                    System.out.println("Received: " + in.readLine());

                }
                System.out.print("Send: ");
                out.println(scan.nextLine());
            }

        } catch (Exception ex) {
            System.out.println("clint disconnected");
        } finally {
            out.close();
            in.close();
            client.close();
        }
    }
}
