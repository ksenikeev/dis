package ru.itis.dis.lab11.graphics;


import javax.swing.*;

import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GraphDemo extends JFrame {

    public GraphDemo() {
        super("game");

        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //createBufferStrategy(2);
        setLayout(new BorderLayout());

        add(new GComponent());
        setVisible(true);
    }



    public static void main(String[] args) {
        new GraphDemo();
    }

}
