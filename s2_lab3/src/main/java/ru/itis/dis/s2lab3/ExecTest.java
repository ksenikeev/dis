package ru.itis.dis.s2lab3;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExecTest {

    public static void main(String[] args) {
        try {
            Process process = new ProcessBuilder()
                    .command("openssl genrsa -out rootkey/rootca.key 2048".split(" "))
                    .directory(new File("./ca"))
                    .start();

            BufferedReader bf = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String s;
            while ((s = bf.readLine()) != null) {
                System.out.println(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
