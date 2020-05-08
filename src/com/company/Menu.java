package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menu extends JFrame {
    public JButton add;
    public JButton list;
    public Menu(){
        setSize(500,500);
        setLayout(null);

        add=new JButton("ADD");
        add.setLocation(100,150);
        add.setSize(300,30);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main.frame.menu.setVisible(false);
                Main.frame.addStudent.setVisible(true);
                Main.frame.repaint();

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
                Main.frame.listStudents.setVisible(true);

            }
        });
        add(list);

    }

}
