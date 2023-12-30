import java.io.*;
import java.net.*;
import java.util.Scanner;

class TCPClient {
    public static void main(String argv[]) throws Exception {
        Scanner inFromUser = new Scanner(System.in);

        try (Socket clientSocket = new Socket("localhost", 1667);
                Scanner inFromServer = new Scanner(clientSocket.getInputStream());
                PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream(), true)) {
            String input;

            while (true) {
                String startColIn1 = inFromServer.nextLine();
                System.out.print(startColIn1);
                input = inFromUser.nextLine();
                outToServer.println(input);
                if (input.isEmpty()) {
                    System.out.println("Closing connection with server");
                    break;
                }

                String startColIn2 = inFromServer.nextLine();
                System.out.print(startColIn2);
                input = inFromUser.nextLine();
                outToServer.println(input);
                if (input.isEmpty()) {
                    System.out.println("Closing connection with server");
                    break;
                }

                String result = inFromServer.nextLine();
                System.out.println("The result is " + result);
            }
        } catch (IOException e) {
            System.out.println("Client: Error connecting to server");
        } finally {
            if (inFromUser != null)
                inFromUser.close();
        }
    }
}