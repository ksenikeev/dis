package ru.itis.dis.lab12.simpleudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPClient{
    /* Порт сервера, к которому собирается
  подключиться клиентский сокет */
    public final static int SERVICE_PORT = 10000;

    public static void main(String[] args) throws IOException{
        try{
      /* Создайте экземпляр клиентского сокета.
Нет необходимости в привязке к определенному порту */
            DatagramSocket clientSocket = new DatagramSocket();

            // Получите IP-адрес сервера
            InetAddress IPAddress = InetAddress.getByName("localhost");

            // Создайте соответствующие буферы
            byte[] sendingDataBuffer = new byte[1024];
            byte[] receivingDataBuffer = new byte[1024];

      /* Преобразуйте данные в байты
       и разместите в буферах */
            String message = "{\"name\":\"Камиль\"}";
            sendingDataBuffer = message.getBytes();

            // Создайте UDP-пакет
            DatagramPacket sendingPacket = new DatagramPacket(sendingDataBuffer,sendingDataBuffer.length,IPAddress, SERVICE_PORT);

            // Отправьте UDP-пакет серверу
            clientSocket.send(sendingPacket);


            // Получите ответ от сервера, т.е. предложение из заглавных букв
            DatagramPacket receivingPacket = new DatagramPacket(receivingDataBuffer,receivingDataBuffer.length);
            clientSocket.receive(receivingPacket);

            // Выведите на экране полученные данные
            String receivedData = new String(receivingPacket.getData(),0, receivingPacket.getLength(),"UTF-8");
            System.out.println("Sent from the server: "+receivedData);

            // Закройте соединение с сервером через сокет
            clientSocket.close();
        }
        catch(SocketException e) {
            e.printStackTrace();
        }
    }
}