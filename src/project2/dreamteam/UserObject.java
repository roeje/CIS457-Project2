package project2.dreamteam;

import java.io.Serializable;

/*
   CIS 457 - Project 2

   Created by:

      Jesse Roe
      Ben Commet
      Brandon Attala

*/

public class UserObject implements java.io.Serializable{
    private String username;
    private String connectionSpeed;
    private String hostname;
    public UserObject(String pUsername, String pConnectionSpeed, String pHostname){
        this.username = pUsername;
        this.connectionSpeed = pConnectionSpeed;
        this.hostname = pHostname;
    }

    public String getUsername(){
        return this.username;
    }

    public String getConnectionSpeed(){
        return this.connectionSpeed;
    }

    public String getHostname(){
        return this.hostname;
    }
}
