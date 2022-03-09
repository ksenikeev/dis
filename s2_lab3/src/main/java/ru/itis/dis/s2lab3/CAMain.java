package ru.itis.dis.s2lab3;

import ru.itis.dis.s2lab3.gui.CAFrame;
import javax.swing.*;

public class CAMain {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() { new CAFrame(); } });
    }
}