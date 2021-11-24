package ru.itis.dis.lab11;

// Техника диспетчеризации событий

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.security.*;

public class MenuBarDemo extends JFrame {

    JPanel pane1;

    public MenuBarDemo() {
        super("Павнели");
        // при закрытии окна - выход
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 800);
        //getContentPane().setLayout(new BorderLayout());
        //getContentPane().setLayout(new BorderLayout());


        JRadioButton radio = new JRadioButton("r1");
        JRadioButton radio2 = new JRadioButton("r2");
        radio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(radio.isSelected());
            }
        });

        pane1 = new JPanel();
        getContentPane().add(pane1);

        ButtonGroup gr = new ButtonGroup();
        pane1.add(radio);
        radio.setSelected(true);
        pane1.add(radio2);
        gr.add(radio);
        gr.add(radio2);

        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        JMenu f = new JMenu("Файл");
        menuBar.add(f);
        JMenu k = new JMenu("Ключи");
        menuBar.add(k);


        JMenuItem open =new JMenuItem("Открыть");
        f.add(open);
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("open");
            }
        });
        JMenuItem close =new JMenuItem("Закрыть");
        f.add(close);
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        JMenuItem generate_key =new JMenuItem("Создать");
        k.add(generate_key);
        generate_key.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateKey();
            }
        });


        setVisible(true);
    }


    private void generateKey() {
        KeyPairGenerator rsa = null;
        try (Writer publicKeyWriter = new FileWriter(new File("publik.key"));
             Writer privateKeyWriter = new FileWriter(new File("private.key"))) {
            rsa = KeyPairGenerator.getInstance("RSA");
            rsa.initialize(1024,new SecureRandom());
            KeyPair keyPair = rsa.generateKeyPair();

            PrivateKey privateKey = keyPair.getPrivate();
            PublicKey publicKey = keyPair.getPublic();


            //privateKeyWriter.write(new String(Hex.encode(privateKey.getEncoded())));
            //publicKeyWriter.write(new String(Hex.encode(publicKey.getEncoded())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() { new MenuBarDemo(); } });
    }
}