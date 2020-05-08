package com.company;
import java.util.*;
import java.io.*;
import java.net.*;

public class Main {
    public static MainFrame frame;
    public static Socket socket;
    public static ObjectOutputStream outStream;
    public static Student st;
    public static ArrayList<Student>students;

    public static void main(String[] args) {
        try {
            socket = new Socket("localhost", 1998);
            outStream = new ObjectOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        frame = new MainFrame();
        frame.setVisible(true);

        Scanner sc = new Scanner(System.in);

//
    }

    public static void addStudent(Student st) {

        PackageData pd = new PackageData();
        pd.setOperationType("ADD");
        pd.setStudent(st);
        students.add(st);
        pd.setStudentList(students);

        try {
            outStream.writeObject(pd);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}


