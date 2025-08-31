
import java.io.*;
import java.net.*;

public class MathClient {

    public static void main(String[] args) {
        try (Socket s = new Socket("127.0.0.1", 5000)) {
            System.out.println("Connected to Math Server");

            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String msg = "";
            while (true) {
                System.out.print("Enter command (e.g., ADD 2 3): ");
                msg = br.readLine();
                out.writeUTF(msg);

                if (msg.equalsIgnoreCase("exit")) {
                    break;
                }

                String response = in.readUTF();
                System.out.println("Server: " + response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
