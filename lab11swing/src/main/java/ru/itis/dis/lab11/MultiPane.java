package ru.itis.dis.lab11;

// Техника диспетчеризации событий

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultiPane extends JFrame {

    JButton button1, button2,button3, button4,button5, button6;

    JPanel pane1;
    JPanel pane2;
    JPanel pane3;

    public MultiPane() {
        super("Павнели");
        // при закрытии окна - выход
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 800);
        //getContentPane().setLayout(new BorderLayout());
        getContentPane().setLayout(new BorderLayout());

        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");

        pane1 = new JPanel();
        pane1.setLayout(new GridLayout(1,3,5,5));

        pane2 = new JPanel();
        pane2.setLayout(new GridLayout(1,3,5,5));

        pane3 = new JPanel();

        pane1.add(button1);
        pane1.add(button2);
        pane1.add(button3);
        pane2.add(button4);
        pane2.add(button5);
        pane2.add(button6);

        getContentPane().add(pane1, BorderLayout.WEST);
        getContentPane().add(pane2, BorderLayout.EAST);


        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() { new MultiPane(); } });
    }
}