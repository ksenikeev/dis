package ru.itis.dis.lab12.udpmessenger;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPClient2 {
    /* Порт сервера, к которому собирается
  подключиться клиентский сокет */
    public final static int SERER_PORT = 3478;

    public static void main(String[] args) throws IOException{
        try{
      /* Создайте экземпляр клиентского сокета.
Нет необходимости в привязке к определенному порту */
            DatagramSocket clientSocket = new DatagramSocket();

            // 1 server
            InetAddress IPAddress = InetAddress.getByName("stun.sipnet.ru");

            System.out.println(IPAddress);

            byte[] sendingDataBuffer = new byte[1024];
            byte[] receivingDataBuffer = new byte[1024];

            String message = "{\"name\":\"Камиль\"}";
            sendingDataBuffer = message.getBytes();

            DatagramPacket sendingPacket = new DatagramPacket(sendingDataBuffer,sendingDataBuffer.length,IPAddress, SERER_PORT);
            clientSocket.send(sendingPacket);

            DatagramPacket receivingPacket = new DatagramPacket(receivingDataBuffer,receivingDataBuffer.length);
            clientSocket.receive(receivingPacket);

            String receivedData = new String(receivingPacket.getData(),0, receivingPacket.getLength(),"UTF-8");
            System.out.println("Sent from the server: "+receivedData);

            Scanner in = new Scanner(System.in);
            System.out.println("input client1 ip");
            String ip = in.nextLine();
            System.out.println("input client1 port");
            int port = in.nextInt();

            sendingDataBuffer = "message 1 from client 2".getBytes();
            sendingPacket = new DatagramPacket(sendingDataBuffer,sendingDataBuffer.length,InetAddress.getByName(ip), port);
            clientSocket.send(sendingPacket);

            System.out.println("input 0 for start");
            in.nextInt();

            sendingDataBuffer = "message 2 from client 2".getBytes();
            sendingPacket = new DatagramPacket(sendingDataBuffer,sendingDataBuffer.length,InetAddress.getByName(ip), port);
            clientSocket.send(sendingPacket);

            receivingPacket = new DatagramPacket(receivingDataBuffer,receivingDataBuffer.length);
            clientSocket.receive(receivingPacket);

            // Выведите на экране полученные данные
            receivedData = new String(receivingPacket.getData(),0, receivingPacket.getLength(),"UTF-8");
            System.out.println("Sent from the client 1: "+receivedData);

            clientSocket.close();
        }
        catch(SocketException e) {
            e.printStackTrace();
        }
    }
}