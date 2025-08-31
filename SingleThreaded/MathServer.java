
import java.io.*;
import java.net.*;

public class MathServer {

    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(5000)) {
            System.out.println("Math Server started... waiting for client");

            Socket s = ss.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            String msg = "";
            while (true) {
                msg = in.readUTF();
                System.out.println("Received: " + msg);

                if (msg.equalsIgnoreCase("exit")) {
                    break;
                }

                String[] parts = msg.split(" ");
                String response = "Invalid command";

                if (parts.length == 3) {
                    try {
                        int a = Integer.parseInt(parts[1]);
                        int b = Integer.parseInt(parts[2]);
                        switch (parts[0].toUpperCase()) {
                            case "ADD":
                                response = String.valueOf(a + b);
                                break;
                            case "SUB":
                                response = String.valueOf(a - b);
                                break;
                            case "MUL":
                                response = String.valueOf(a * b);
                                break;
                            case "DIV":
                                response = b != 0 ? String.valueOf(a / b) : "Error: Divide by zero";
                                break;
                        }
                    } catch (NumberFormatException e) {
                        response = "Error: Invalid numbers";
                    }
                }
                out.writeUTF(response);
            }

            s.close();
            System.out.println("Connection closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
