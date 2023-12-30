import java.io.*;
import java.net.*;
import java.util.Scanner;

class TCPServer {
   public static void main(String argv[]) {
      ServerSocket welcomeSocket = null;
      try {
         welcomeSocket = new ServerSocket(1667);
         System.out.println("Waiting for client connection at port number 1667");

         while (true) {
            Socket connectionSocket = welcomeSocket.accept();
            System.out.println("Accepted connection from client");
            Thread clientThread = new Thread(new ClientHandler(connectionSocket));
            clientThread.start();
         }
      } catch (IOException e) {
         System.out.println("Error creating welcome socket");
      } finally {
         try {
            if (welcomeSocket != null)
               welcomeSocket.close();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }
}

class ClientHandler implements Runnable {
   private Socket connectionSocket;

   public ClientHandler(Socket connectionSocket) {
      this.connectionSocket = connectionSocket;
   }

   @Override
   public void run() {
      try (
            Scanner inFromClient = new Scanner(connectionSocket.getInputStream());
            PrintWriter outToClient = new PrintWriter(connectionSocket.getOutputStream(), true)) {
         int num1, num2;
         String input;

         while (true) {
            outToClient.println("Enter number 1 (to end just press enter): ");
            input = inFromClient.nextLine();

            if (input.isEmpty()) {
               System.out.println("Closing connection with client");
               break;
            }

            num1 = Integer.parseInt(input);

            outToClient.println("Enter number 2 (to end just press enter): ");
            input = inFromClient.nextLine();

            if (input.isEmpty()) {
               System.out.println("Closing connection with client");
               break;
            }

            num2 = Integer.parseInt(input);

            int result = num1 + num2;
            outToClient.println(result);
         }
      } catch (IOException e) {
         System.out.println("Error handling client connection");
      } finally {
         try {
            if (connectionSocket != null)
               connectionSocket.close();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }
}