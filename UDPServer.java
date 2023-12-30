import java.net.*;
import java.util.Date;

public class UDPServer {
  public static void main(String[] args) {
    try {
      DatagramSocket serverSocket = new DatagramSocket(9876);

      while (true) {
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

        serverSocket.receive(receivePacket);
        InetAddress clientAddress = receivePacket.getAddress();
        int clientPort = receivePacket.getPort();

        Date currentDate = new Date();
        String dateTimeString = currentDate.toString();

        byte[] sendData = dateTimeString.getBytes();

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
        serverSocket.send(sendPacket);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
