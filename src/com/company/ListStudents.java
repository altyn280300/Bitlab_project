package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListStudents extends JFrame {
    private JLabel label;
    private JButton btn;
    private ArrayList<Student>st;

    public ListStudents()
    {
        ClientHandler ch = null;
        label=new JLabel("List students");
        label.setLocation(100,150);
        label.setSize(300,30);

        setLayout(null);
        setSize(500,500);
        JTextArea txt=new JTextArea();
        st=ch.getStudents();
        for(int i = 0 ;i<st.size();i++)
        {
            txt.append(st.toString());
        }
        add(txt);



        btn = new JButton("Back");
        btn.setLocation(100,450);
        btn.setSize(300,30);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main.frame.listStudents.setVisible(false);
                Main.frame.menu.setVisible(true);
                Main.frame.repaint();
            }
        });


    }



}
