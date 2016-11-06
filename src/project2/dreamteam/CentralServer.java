package project2.dreamteam;

import java.net.* ;

/*
   CIS 457 - Project 1

   Created by:

      Jesse Roe
      Ben Commet
      Brandon Attala

*/

/*

   Client Class that handles logic related to sending and receving files and commands
   over TCP connctions

*/

public final class CentralServer {
    public static void main(String argv[]) throws Exception {
        int port = 3202;
        UserTable users = new UserTable();

        FileTable files =  new FileTable();

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
             }

        }
   }
}
