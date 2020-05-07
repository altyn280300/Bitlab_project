package com.company;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;

public class Clienthandler extends Thread {
    private Socket socket;
    private static Connection connection;

    public Clienthandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            PackageData pd = null;
            while ((pd = (PackageData) inStream.readObject()) != null) {
                if (pd.getOperationType().equals("ADD ")) {
                    System.out.println(pd.getStudent().toString());
                    addStudentToDataBase(pd.getStudent());
                } else if (pd.getOperationType().equals("LISt")) {
                    System.out.println(getStudents());

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void connectDatabase()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/bitlab_project?useUnicode=true&serverTimezone=UTC","root","");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }


    public static void addStudentToDataBase(Student student) {
        try {
            Statement st = connection.createStatement();
            //String sql = "insert into student(name,surname,age) values(\"" + student.getName() + "\",\"" + student.getSurname() + "\",\"" + student.getAge() + "\")";
            PreparedStatement statement=connection.prepareStatement(""+
                    "INSERT INTO students(id,name,price)"+"VALUES(NULL,?,?,?)");
            statement.setString(1,student.getName());
            statement.setString(2,student.getSurname());
            statement.setInt(3,student.getAge());
            int row=statement.executeUpdate();
            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /////////////////////////////////////////////////////////////////////////////
    public static ArrayList<Student> getStudents() {
        ArrayList<Student> studentList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("Select *FROM students");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int age = resultSet.getInt("age");
                studentList.add(new Student(id, name, surname, age));
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;


    }
}
