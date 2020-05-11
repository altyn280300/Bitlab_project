package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menu extends Container {
    public JButton add;
    public JButton list;
    public Menu(){
        setSize(700,700);
        setLayout(null);

        add=new JButton("ADD");
        add.setLocation(100,150);
        add.setSize(300,30);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main.frame.menu.setVisible(false);
                Main.frame.addStudent.setVisible(true);


            }
        });
        add(add);

        list=new JButton("List");
        list.setLocation(100,190);
        list.setSize(300,30);
        list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main.frame.menu.setVisible(false);
                Main.getList();//лист всех данных студентов
                Main.frame.listFrame.updateList();
                Main.frame.listFrame.setVisible(true);

            }
        });
        add(list);

    }


}
