package com.company;

import javax.swing.*;
import java.awt.*;


public class Menu extends Container {
    public JButton add;
    public JButton list;
    public Menu(){
        setSize(500,500);
        setLayout(null);

        add=new JButton("ADD");
        add.setLocation(100,150);
        add.setSize(300,30);
        add.addActionListener(actionEvent -> {
            MainFrame.menu.setVisible(false);
            MainFrame.addStudent.setVisible(true);


        });
        add(add);

        list=new JButton("List");
        list.setLocation(100,190);
        list.setSize(300,30);
        list.addActionListener(actionEvent -> {


            MainFrame.menu.setVisible(false);
            MainFrame.listFrame.setVisible(true);
            Main.getList();//лист всех данных студентов
            Main.frame.listFrame.updateList();

        });
        add(list);

    }


}
