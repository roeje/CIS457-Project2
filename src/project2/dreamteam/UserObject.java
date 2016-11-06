package project2.dreamteam;

import java.io.Serializable;

/**
 * Created by bcom3_000 on 11/5/2016.
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
