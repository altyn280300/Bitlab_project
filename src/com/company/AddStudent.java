package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import javax.swing.*;

public class AddStudent extends JFrame {
    private static JButton btn;


   Scanner in = new Scanner(System.in);
    public AddStudent(){
        Student st =null;
        setLayout(null);
        setSize(500,500);

       JLabel label = new JLabel("Name:");
        label.setLocation(100,100);
        label.setSize(90,30);
        add(label);

       JTextField txt=new JTextField();
        txt.setLocation(200,100);
        txt.setSize(300,30);

       JLabel label2 =new JLabel("Surname: ");
        label2.setLocation(100,140);
        label2.setSize(100,30);
        add(label2);

        JTextField txt2=new JTextField();
        txt2.setSize(300,30);
        txt2.setLocation(200,140);
        add(txt2);

        JLabel label3=new JLabel("Age:");
        label3.setSize(80,30);
        label3.setLocation(100,180);
        add(label3);

        JTextField txt3=new JTextField();
        txt3.setSize(300,30);
        txt3.setLocation(200,180);




         btn = new JButton("Back");
        btn.setLocation(100,150);
        btn.setSize(50,30);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                Main.frame.addStudent.setVisible(false);
                Main.frame.menu.setVisible(true);

            }
        });
        add(btn);


        btn = new JButton("Add");
        btn.setLocation(160,150);
        btn.setSize(50,30);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String name =in.next();
                Long  id=in.nextLong();
                String surname=in.next();
                int age=in.nextInt();
                st.setId(id);
                st.setName(name);
                st.setSurname(surname);
                st.setAge(age);

                Main.addStudent(st);
                Main.frame.addStudent.setVisible(false);
                Main.frame.menu.setVisible(true);
                Main.frame.repaint();

            }
        });
        add(btn);
    }
}
