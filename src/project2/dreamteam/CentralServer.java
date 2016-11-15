package project2.dreamteam;

import java.io.*;
import java.net.* ;

/*
   CIS 457 - Project 1

   Created by:

      Jesse Roe
      Ben Commet
      Brandon Attala

*/

/*

   Client Class that handles logic related to sending and receiving files and commands
   over TCP connections

*/

public final class CentralServer {
    public static void main(String argv[]) throws Exception {
        int port = 3202;

        UserTable users;
        FileTable files;

        String userTableFile = "users.db";
        String fileTableFile = "file.db";

        boolean userExists = new File(userTableFile).exists();
        boolean fileExists = new File(fileTableFile).exists();

        if (fileExists && userExists) {
            users = readUserTable(userTableFile);
            files = readFileTable(fileTableFile);
        }
        else {
            users = new UserTable();
            files =  new FileTable();
        }

        users = new UserTable();
        files = new FileTable();

        // Establish the listen socket.
        ServerSocket socket = new ServerSocket(port);
        System.out.println("Central Server started on port: " + port);

        while (true) {

            try {

                // Listen for a TCP connection request.
                Socket connection = socket.accept();

                // Create FTP request object
                CentralServerThread request = new CentralServerThread(connection, users, files);

                // Create a new thread to process the request.
                Thread thread = new Thread(request);

                // Start the thread.
                thread.start();
            } catch (Exception e) {
                System.out.println(e);
                return;
            }
        }
    }


    private static boolean writeToFile(String fileName, Object object) {
        try {
            final ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));

            try {
                out.writeObject(object);
            } catch (Exception e) {
                return false;
            } finally {
                out.close();
            }
            return true;

        } catch (IOException e) {
            return false;
        }
    }

    private static UserTable readUserTable (String fileName) {
        UserTable tmp;
        try {
            final ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)));
            tmp = (UserTable) in.readObject();

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return tmp;
    }

    private static FileTable readFileTable (String fileName) {
        FileTable tmp;
        try {
            final ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)));
            tmp = (FileTable) in.readObject();

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return tmp;
    }
}
