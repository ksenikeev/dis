package ru.itis.dis.s2lab3.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExecService {

    private String rootDirectory;

    public ExecService(String rootDirectory) {
        this.rootDirectory = rootDirectory;
    }

    /**
     *
     * @param cmd example "openssl genrsa -out rootkey/rootca.key 2048"
     */
    public void exec(String cmd) {
        try {
            Process process = new ProcessBuilder()
                    .command(cmd.split(" "))
                    .directory(new File(rootDirectory))
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
