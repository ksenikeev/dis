package ru.itis.dis.lab11.starshipgame;


import javax.swing.*;
import java.awt.*;

public class StarShip extends JFrame {

    public StarShip() {
        super("star ship");

        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //createBufferStrategy(2);
        setLayout(new BorderLayout());

        add(new GameComponent());
        setVisible(true);
    }



    public static void main(String[] args) {
        new StarShip();
    }

}
