package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class mainFrame extends JFrame {
    public static AddStudent addStudent;
    public static ListStudents listStudents;
    public static Menu menu;

    public mainFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        setTitle("Student application");
        setSize(500,500);
        setLayout(null);

        menu=new Menu();
        menu.setLocation(0,0);
        menu.setVisible(true);
        add(menu);

        addStudent=new AddStudent();
        addStudent.setLocation(0,0);
        addStudent.setVisible(false);
        add(addStudent);

        listStudents=new ListStudents();
        listStudents.setLocation(0,0);
        listStudents.setVisible(false);
        add(listStudents);



    }




}
