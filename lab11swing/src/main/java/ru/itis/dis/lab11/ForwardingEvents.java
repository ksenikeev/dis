package ru.itis.dis.lab11;

// Техника диспетчеризации событий
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ForwardingEvents extends JFrame {

    private JTextArea out;
    public ForwardingEvents() {
        super("ForwardingEvents");
        // при закрытии окна - выход
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // последовательное расположение
        getContentPane().setLayout(null);
        // добавим пару кнопок
        button1 = new JButton("ОК");
        button1.setBounds(10,10,100,20);
        button2 = new JButton("Отмена");
        button2.setBounds(110,10,100,20);
        getContentPane().add(button1);
        getContentPane().add(button2);
        JScrollPane scrollPane = new JScrollPane(out = new JTextArea());
        scrollPane.setBounds(10,40, 400,400);
        getContentPane().add(scrollPane);
        // будем следить за нажатиями кнопок
        Forwarder forwarder = new Forwarder();
        button1.addActionListener(forwarder);
        button2.addActionListener(forwarder);
        // выводим окно на экран
        //pack();
        setSize(800, 800);

        setVisible(true);
    }
    JButton button1, button2;
    // класс - слушатель нажатия на кнопку
    class Forwarder implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            // рассылаем события по методам
            if ( e.getSource() == button1 ) onOK(e);
            if ( e.getSource() == button2 ) onCancel(e);
        }
    }
    // обработка события от кнопки "ОК"
    public void onOK(ActionEvent e) {
        System.out.println("onOK()");
        out.append("1");
    }
    // обработка события от кнопки "Отмена"
    public void onCancel(ActionEvent e) {
        out.append("2");
        System.out.println("onCancel()");
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() { new ForwardingEvents(); } });
    }
}