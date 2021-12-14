package ru.itis.dis.lab11;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class TableDemo {

    private JFrame mainFrame;
    private JPanel panel;
    private JTable table;

    public TableDemo() {
        init();
    }

    public void init() {
        mainFrame = new JFrame("TableDemo demo");
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainFrame.setSize(800, 800);
        mainFrame.setLayout(new BorderLayout());

/*
        List<List<String>> tableData = new ArrayList<>();
        List<String> header = new ArrayList<>();
        header.add("col 1");
        header.add("col 2");
        header.add("col 3");

        List<String> row1 = Arrays.asList(new String[]{"item11", "item12", "item13"});
        List<String> row2 = Arrays.asList(new String[]{"item21", "item22", "item23"});
        List<String> row3 = Arrays.asList(new String[]{"item31", "item32", "item33"});
        tableData.add(row1);
        tableData.add(row2);
        tableData.add(row3);
*/

        table = new JTable(new String[][]{{"item11", "item12", "item13"},{"item21", "item22", "item23"},{"item31", "item32", "item33"}}, new String[]{"col 1","col 2","col 3"});


        mainFrame.add(table, BorderLayout.NORTH);

        mainFrame.setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() { new TableDemo(); } });
    }


}

