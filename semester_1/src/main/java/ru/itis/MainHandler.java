package ru.itis;

import java.net.Socket;

public class MainHandler {

    private Socket clientSocket;
    private Context context;

    public MainHandler(Socket clientSocket, Context context) {
        this.clientSocket = clientSocket;
        this.context = context;

        // read request header

        String resourcePath = null;

        RequestHandler rh = context.getHandlerMap().get(resourcePath);

        if (rh != null) {
            //rh.process(...);
        } else {
            //page not found !
        }
    }

    public void handle() {


    }
}
