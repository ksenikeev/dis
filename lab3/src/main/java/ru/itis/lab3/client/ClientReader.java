package ru.itis.lab3.client;

import java.io.BufferedReader;
import java.io.IOException;

public class ClientReader implements Runnable {

    private BufferedReader in;

    public ClientReader(BufferedReader in) {
        this.in = in;
    }

    @Override
    public void run() {
        while (in != null) {
            try {
                String msg = in.readLine();
                System.out.println(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
