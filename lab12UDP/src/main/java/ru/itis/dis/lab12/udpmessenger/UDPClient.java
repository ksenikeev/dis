package ru.itis.dis.lab12.udpmessenger;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPClient {
    /* Порт сервера, к которому собирается
  подключиться клиентский сокет */
    public final static int SERER_PORT = 50000;

    public static void main(String[] args) throws IOException{
        try{
      /* Создайте экземпляр клиентского сокета.
Нет необходимости в привязке к определенному порту */
            DatagramSocket clientSocket = new DatagramSocket();
            DatagramSocket clientSocket2 = new DatagramSocket();

            // 1 server
            InetAddress IPAddress = InetAddress.getByName("188.93.211.195");

            byte[] sendingDataBuffer = new byte[1024];
            byte[] receivingDataBuffer = new byte[1024];

            String message = "{\"name\":\"Камиль\"}";
            sendingDataBuffer = message.getBytes();


            new Thread(new Sender(clientSocket2,"188.93.211.195",SERER_PORT,sendingDataBuffer)).start();
            new Thread(new Reader(clientSocket)).start();

/*
            DatagramPacket sendingPacket = new DatagramPacket(sendingDataBuffer,sendingDataBuffer.length,
                    IPAddress, SERER_PORT);
            clientSocket.send(sendingPacket);

            DatagramPacket receivingPacket = new DatagramPacket(receivingDataBuffer,receivingDataBuffer.length);
            clientSocket.receive(receivingPacket);

            String receivedData = new String(receivingPacket.getData(),0, receivingPacket.getLength(),"UTF-8");
            System.out.println("Sent from the server: "+receivedData);

            Scanner in = new Scanner(System.in);
            System.out.println("input client2 ip");
            String ip = in.nextLine();
            System.out.println("input client2 port");
            int port = in.nextInt();

            sendingDataBuffer = "message 1 from client 1".getBytes();
            sendingPacket = new DatagramPacket(sendingDataBuffer,sendingDataBuffer.length,InetAddress.getByName(ip), port);
            clientSocket.send(sendingPacket);

            System.out.println("input 0 for start");
            in.nextInt();

            sendingDataBuffer = "message 2 from client 1".getBytes();
            sendingPacket = new DatagramPacket(sendingDataBuffer,sendingDataBuffer.length,InetAddress.getByName(ip), port);
            clientSocket.send(sendingPacket);

            receivingPacket = new DatagramPacket(receivingDataBuffer,receivingDataBuffer.length);
            clientSocket.receive(receivingPacket);

            // Выведите на экране полученные данные
            receivedData = new String(receivingPacket.getData(),0, receivingPacket.getLength(),"UTF-8");
            System.out.println("Sent from the client 2: "+receivedData);

            clientSocket.close();
*/
        }
        catch(SocketException e) {
            e.printStackTrace();
        }
    }
}

class Reader implements Runnable {

    private DatagramSocket socket;

    public Reader(DatagramSocket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {

            while (true) {
                byte[] receivingDataBuffer = new byte[1024];
                DatagramPacket receivingPacket = new DatagramPacket(receivingDataBuffer,receivingDataBuffer.length);
                socket.receive(receivingPacket);

                String receivedData = new String(receivingPacket.getData(),0, receivingPacket.getLength(),"UTF-8");
                System.out.println("readedr: "+receivedData);            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Sender implements Runnable {

    private DatagramSocket socket;
    private String ip;
    private int port;
    private byte[] message;

    public Sender(DatagramSocket socket, String ip, int port, byte[] message) {
        this.socket = socket;
        this.ip = ip;
        this.port = port;
        this.message = message;
    }

    @Override
    public void run() {
        try {

            while (true) {
                DatagramPacket sendingPacket = new DatagramPacket(message, message.length,
                        InetAddress.getByName(ip), port);
                socket.send(sendingPacket);
                Thread.sleep(500);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}