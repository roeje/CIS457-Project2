package project2.dreamteam;

import java.io.Serializable;
import java.util.Vector;

/**
 * Created by bcom3_000 on 11/5/2016.
 */
public class UserTable implements Serializable{
    private Vector <UserObject> users;
    public UserTable(){
         this.users = new Vector<>();
    }

    public void addUser(String pUsername, String pConnectionSpeed, String pHostname){
        UserObject newUser = new UserObject(pUsername, pConnectionSpeed, pHostname);
        this.users.add(newUser);
    }

    public boolean removeUser(String pUsername){
        return users.remove(pUsername);
    }
}
