package ru.itis.dis.lab12.udpmessenger;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UDPServer{

    private final static int SERVICE_PORT=50000;

    private final Map<String,User> users = new HashMap<>();

    public static void main(String[] args) throws IOException{
        try{

            while (true) {
                DatagramSocket serverSocket = new DatagramSocket(SERVICE_PORT);
                byte[] receivingDataBuffer = new byte[1024];
                byte[] sendingDataBuffer;

                /* Создайте экземпляр UDP-пакета для хранения клиентских данных с использованием буфера для полученных данных */
                DatagramPacket inputPacket = new DatagramPacket(receivingDataBuffer, receivingDataBuffer.length);
                System.out.println("Waiting for a client to connect...");

                // Получите данные от клиента и сохраните их в inputPacket
                serverSocket.receive(inputPacket);

                // Выведите на экран отправленные клиентом данные
                String receivedData = new String(inputPacket.getData(), 0, inputPacket.getLength(), "UTF-8");

                ObjectMapper mapper = new ObjectMapper();
                User user = mapper.readValue(receivedData, User.class);

                user.setAddress(inputPacket.getAddress().toString());
                user.setPort(inputPacket.getPort());

                System.out.println(user);

                sendingDataBuffer = mapper.writeValueAsString(user).getBytes("UTF-8");

                // Получите IP-адрес и порт клиента
                InetAddress senderAddress = inputPacket.getAddress();
                int senderPort = inputPacket.getPort();
                System.out.println(inputPacket.getAddress() + ":" + inputPacket.getPort());
                serverSocket.close();

                serverSocket = new DatagramSocket(SERVICE_PORT);
                // Создайте новый UDP-пакет с данными, чтобы отправить их клиенту
                DatagramPacket outputPacket = new DatagramPacket(
                        sendingDataBuffer, sendingDataBuffer.length,
                        senderAddress, senderPort
                );

                // Отправьте пакет клиенту
                serverSocket.send(outputPacket);
                // Закройте соединение сокетов
                serverSocket.close();
            }
        }
        catch (SocketException e){
            e.printStackTrace();
        }
    }
}