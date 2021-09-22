package ru.itis;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Server {
    public void main(String[] args) {

        Context context = new Context();

        context.getHandlerMap().put("/resource1",
                new RequestHandler() {
                    @Override
                    public void process(HTTPRequest request, HTTPResponse response) {
                        try {
                            byte[] resp =
                                    ("<html><body><h1>Hello from simple server!</h1></body></html>").getBytes("UTF8");

                            response.getOutputStream().write(resp);
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }
        );


        //Create ServerSocket

        // while(true) {
        //
        // ClientSocket clienSocket = server.accept()
        // new MainHandler(clientSocket, context).handle();
        // }


    }
}
