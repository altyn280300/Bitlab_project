package com.company;
import java.util.*;
import java.io.*;
import java.net.*;

public class Main {
    public static mainFrame frame;
    public static Socket socket;
    public static ObjectOutputStream outStream;
    public static Student st;
    public static ArrayList<Student>students;

    public static void main(String[] args) {
        frame = new mainFrame();
        frame.setVisible(true);

        Scanner sc = new Scanner(System.in);
        try {
            socket = new Socket("127.0.0.1", 2020);
            outStream = new ObjectOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }

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


