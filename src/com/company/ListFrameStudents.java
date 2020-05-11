package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListFrameStudents extends Container {
    private  JLabel label;
    private  JButton btn;
    public  JTextArea txt;
    private static ArrayList<Student>st;//он ниодин и тот же студент который в main

    public ListFrameStudents()
    {
        try {
            st = Main.students;
            label = new JLabel("List students");
            label.setLocation(100, 150);
            label.setSize(300, 30);

            setLayout(null);
            setSize(700, 700);

            txt= new JTextArea();


            add(txt);


        }catch(Exception e)
        {
            e.printStackTrace();
        }



        btn = new JButton("Back");
        btn.setLocation(100,690);
        btn.setSize(150,30);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main.frame.listFrame.setVisible(false);
                Main.frame.menu.setVisible(true);
                Main.frame.repaint();
            }
        });


    }
    public  void updateList()
    {
        st=Main.students;
        for (int i = 0; i < st.size(); i++)
        {
            txt.append(st.get(i).toString());
        }

    }

}
