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

   Client Class that handles logic related to sending and receiving files and commands
   over TCP connctions

*/

public final class FtpServer {
    public static void main(String argv[]) throws Exception {
        // Get the port number from the command line.
        // int port = (new Integer(argv[0]));

        int port = 3208;

        // Establish the listen socket.
        ServerSocket socket = new ServerSocket(port);
        System.out.println("FTP Server started on port: " + port);

        while (true) {

            try {

                // Listen for a TCP connection request.
                Socket connection = socket.accept();

                // Create FTP request object
                FtpServerThread request = new FtpServerThread(connection);

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
