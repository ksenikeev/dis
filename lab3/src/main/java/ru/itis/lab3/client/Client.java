package ru.itis.lab3.client;

import java.io.*;
import java.net.Socket;

public class Client {

    private static Socket clientSocket; //сокет для общения
    private static BufferedReader reader; // нам нужен ридер читающий с консоли, иначе как
    // мы узнаем что хочет сказать клиент?
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет

    public static void main(String[] args) {
        try {
            try {
                // адрес - локальный хост, порт - 4004, такой же как у сервера
                clientSocket = new Socket("127.0.0.1", 10000);

                reader = new BufferedReader(new InputStreamReader(System.in));

                // читать соообщения с сервера
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                // писать туда же
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream(),"cp866"));

                System.out.println("Укажите своё имя:");
                String name = reader.readLine();

                out.write(name + "\n"); // отправляем сообщение на сервер
                out.flush();

                // Чтение информации от сервера
                Thread cr = new Thread(new ClientReader(in));
                cr.setDaemon(true);
                cr.start();

                String message = "";
                do {
                    message = reader.readLine();
                    if (!message.equals("\\q")) {
                        out.write(message);
                    }
                } while (!message.equals("\\q"));

            } finally { // в любом случае необходимо закрыть сокет и потоки
                System.out.println("Клиент был закрыт...");
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }

    }
}