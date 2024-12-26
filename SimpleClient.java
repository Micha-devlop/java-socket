import java.io.*;
import java.net.*;

public class SimpleClient
{
    public static void main(String[] args)
    {
        final String HOST = "10.240.1.81";
        final int PORT = 2017;
        
        try (Socket socket = new Socket(HOST, PORT)) {
            System.out.println("Conected to server");
            
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            
            String serverMessage = reader.readLine();
            System.out.println("Server say: " + serverMessage);
            
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            
            writer.println("hi i am ethiopian from adama university ");
            
        } 
        catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } 
        catch (IOException ex) {
            System.out.println("Inpt/output error: " + ex.getMessage());
        }
    }
}
