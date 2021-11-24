package ru.itis.dis.lab11.calculator;


// Техника диспетчеризации событий
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator extends JFrame {

    private JTextArea out;
    private JButton[] numbers; //0-9
    private JButton plusButton;// +
    private JButton escButton;// C
    private JButton minusButton;// -
    private JButton divButton; // /
    private JButton multButton;// *
    private JButton equallyButton;// =

    private void init() {
        numbers = new JButton[10];
        for(int i = 0; i < 10; i++) {
            numbers[i] = new JButton(String.valueOf(i));
        }

        plusButton = new JButton("+");
        minusButton = new JButton("+");
        multButton = new JButton("+");
        divButton = new JButton("+");
        escButton = new JButton("C");
        escButton.setForeground(Color.BLACK);
        escButton.setBackground(new Color(255, 0, 0));
        equallyButton = new JButton("=");
        escButton.setForeground(Color.BLACK);
        escButton.setBackground(new Color(0, 255, 0));

        numbers[0].setBounds(5,5,20,20);
        numbers[1].setBounds(30,5,20,20);
        numbers[2].setBounds(55,5,20,20);

        numbers[3].setBounds(5,30,20,20);
        numbers[4].setBounds(30,30,20,20);
        numbers[5].setBounds(55,30,20,20);

        numbers[6].setBounds(5,55,20,20);
        numbers[7].setBounds(30,55,20,20);
        numbers[8].setBounds(55,55,20,20);

        numbers[9].setBounds(5,80,20,20);


        for(int i = 0; i < 10; i++) {
            getContentPane().add(numbers[i]);
        }


    }

    public Calculator() {
        super("Калькулятор");
        // при закрытии окна - выход
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // последовательное расположение
        getContentPane().setLayout(null);
        // добавим пару кнопок
        button1 = new JButton("<html> <span style=\"color:'red'\">O</span><span style=\"color:'green'\">K</span></html>");
        button1.setBounds(10,10,100,20);
        button2 = new JButton("Отмена");
        button2.setBounds(110,10,100,20);
        getContentPane().add(button1);
        getContentPane().add(button2);
        JScrollPane scrollPane = new JScrollPane(out = new JTextArea());
        scrollPane.setBounds(10,40, 400,400);
        getContentPane().add(scrollPane);
        // будем следить за нажатиями кнопок
        ComponentDispatcher dispatcher = new ComponentDispatcher();
        button1.addActionListener(dispatcher);
        button2.addActionListener(dispatcher);
        // выводим окно на экран
        //pack();
        setSize(800, 800);

        setVisible(true);
    }
    JButton button1, button2;
    // класс - слушатель нажатия на кнопку
    class ComponentDispatcher implements ActionListener {
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
                    public void run() { new Calculator(); } });
    }
}