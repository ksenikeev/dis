package ru.itis.lab3;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClientHandler {

    private Socket clientSocket;
    private Map<String, List<Message>> queue;
    private Map<String, Writer> clientStream;

    public ClientHandler(Socket clientSocket, Map<String, List<Message>> queue, Map<String, Writer> clientStream) {
        this.clientSocket = clientSocket;
        this.queue = queue;
        this.clientStream = clientStream;
    }

    public void process() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Принимаем имя клиента
            String name = in.readLine();

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            // фиксируем выходной поток клиента (куда можно писать сообщения)
            clientStream.put(name, out);

            // проверяем сообщения для клиента
            List<Message> lstMessage = queue.get(name);

            if (lstMessage != null && lstMessage.size() > 0) {
                for (Message message : lstMessage) {
                    out.write(new SimpleDateFormat("dd.MM.yyyy HH:mm").format(message.getMsgDate())
                     + ";" + message.getSrcClientName() + ";" + message.getMessageText() + "\n");
                }
            }

            out.write("\n");
            out.flush();

            while (clientSocket.isConnected()) {
                // msg:   dstClient ; messageText
                String msg = in.readLine();

                if (!msg.equals("\n")) {

                    Message message = new Message().writeMessage(msg, name);

                    Writer dstWriter = clientStream.get(message.getDstClientName());

                    if (dstWriter != null) {
                        dstWriter.write(new SimpleDateFormat("dd.MM.yyyy HH:mm").format(message.getMsgDate())
                                + ";" + message.getSrcClientName() + ";" + message.getMessageText() + "\n");
                        dstWriter.flush();
                    } else {
                        List<Message> lst = queue.get(message.getDstClientName());
                        if (lst != null) {
                            lst.add(message);
                        } else {
                            lst = new ArrayList<>();
                            lst.add(message);
                            queue.put(message.getDstClientName(), lst);
                        }
                    }
                }

                out.flush();

            }

            clientStream.remove(name);

            lstMessage.clear();
            queue.remove(name);



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

