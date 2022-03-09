package ru.itis.dis.s2lab3.gui;

import ru.itis.dis.s2lab3.service.OpenSSLCMDService;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CAFrame extends JFrame implements ActionListener{

    private OpenSSLCMDService service = new OpenSSLCMDService("./ca/ca.properties");

    private JTextArea out;
    JButton button1;
    JButton button2;


    public CAFrame() {
        super("Удостоверяющий центр");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // последовательное расположение
        getContentPane().setLayout(null);

        button1 = new JButton("<html> <span style=\"color:'red'\">Создать закрытый ключ Удостоверяющего центра</span></html>");
        button1.setBounds(10,10,300,40);
        button1.addActionListener(this);

        getContentPane().add(button1);

        button2 = new JButton("<html> <span style=\"color:'red'\">Создать сертификат Удостоверяющего центра</span></html>");
        button2.setBounds(10,50,300,40);
        button2.addActionListener(this);

        getContentPane().add(button2);

        JScrollPane scrollPane = new JScrollPane(out = new JTextArea());
        scrollPane.setBounds(10,80, 400,400);
        getContentPane().add(scrollPane);

        setSize(800, 800);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (button1.equals(e.getSource())) {
            service.generateCAPrivateKey();
        } else if (button2.equals(e.getSource())) {
            service.generateCACertificate();
        }

    }
}