package project2.dreamteam;

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

public final class FtpClient {
    public static void main(String argv[]) throws Exception {

   	// Establish the listen socket.
   	// Socket socket = new Socket("localhost", port);
    System.out.println("FTP Client started:");

   	FtpClientThread client = new FtpClientThread();
    	client.run();
    }
}
