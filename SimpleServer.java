import java.io.*;
import java.net.*;

public class SimpleServer 
{
    public static void main(String[] args) {
        final int PORT = 2017;
        
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("lessen " + PORT);
            
            while (true)
            {
                try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("connected");
                    
                    OutputStream output = clientSocket.getOutputStream();
                    PrintWriter writer = new PrintWriter(output, true);
                    
                    writer.println("hi iam server andi know about Ethiopia !");
                    
                    InputStream input = clientSocket.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    
                    String clientMessage = reader.readLine();
                    System.out.println("Message from client: " + clientMessage);
                }
            }
        } 
        catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
