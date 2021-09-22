package ru.itis.db.lab2;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Client client1 = new Client();
        client1.setClientId(1);
        client1.setName("client1");
        client1.setPhone("111111");

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("client.json"), client1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
