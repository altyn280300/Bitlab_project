package com.company;

import com.mysql.cj.protocol.a.result.AbstractBufferRow;

import java.sql.*;
import java.util.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server {
    public static Connection connection;

    public static void main(String[] args) {


        try {
            ServerSocket server = new ServerSocket(2020);
            System.out.println("Wainting for client...");
            while(true) {
                Socket socket = server.accept();
                System.out.println("Client connected");
                ClientHandler ch=new ClientHandler(socket);
                ch.start();
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}