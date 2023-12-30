import java.net.*;

public class UDPClient {
   public static void main(String[] args) {
      try {
         DatagramSocket clientSocket = new DatagramSocket();
         InetAddress serverAddress = InetAddress.getByName("localhost");

         byte[] sendData = new byte[1024];
         DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9876);
         clientSocket.send(sendPacket);

         byte[] receiveData = new byte[1024];
         DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
         clientSocket.receive(receivePacket);

         String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());
         System.out.println(serverResponse);

         clientSocket.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
