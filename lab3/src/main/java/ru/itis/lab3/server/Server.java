package ru.itis.lab3.server;

import ru.itis.lab3.ClientHandler;
import ru.itis.lab3.Message;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Server {

    private static ServerSocket server;


    public static void main(String[] args) {
        // client - dst , messages
        Map<String, List<Message>> queue = new HashMap<>();

        Map<String, Writer> clientStream = new HashMap<>();

        try {
            server = new ServerSocket(10000);
            System.out.println("Сервер запущен!");

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("client " + clientSocket.toString());

                ClientHandler clientHandler = new ClientHandler(clientSocket, queue, clientStream);
                clientHandler.process();

            }
        } catch (IOException e) {
            System.err.println(e);
        }finally {
            System.out.println("Сервер закрыт!");
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}