package ru.itis.dis.s2lab3.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class OpenSSLCMDService {

    private static final String caRootKeyName = "rootkey/rootca.key";

    private Properties properties;

    public OpenSSLCMDService(String properrtiesPath) {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(new File(properrtiesPath)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        properties.putIfAbsent("rootkeydir", "rootkeydir");
        properties.putIfAbsent("rootkey", "rootca.key");
        properties.putIfAbsent("rootcer", "rootca.crt");
        properties.putIfAbsent("cakeydays", "1000");
    }

    //@Inject
    ExecService service = new ExecService("./ca");

    /*
    openssl genrsa -out rootCA.key 2048
     */
    public void generateCAPrivateKey() {
        String cmd = "openssl genrsa -out " + properties.get("rootkeydir") + File.separator + properties.get("rootkey") + " 2048";
        System.out.println(cmd);
        service.exec(cmd);
    }

    /*
        openssl req -x509 -utf8 -new -config ca.cnf -key rootkey/rootca.key -days 10000 -out rootkey/rootca.crt     */
    public void generateCACertificate() {
        String cmd = "openssl req -x509 -utf8 -new -config ca.cnf -key "
                + properties.get("rootkeydir") + File.separator + properties.get("rootkey")
                + " -days "+ properties.get("cakeydays") + " -out "
                + properties.get("rootkeydir") + File.separator + properties.get("rootcer");
        System.out.println(cmd);
        service.exec(cmd);
    }
}
