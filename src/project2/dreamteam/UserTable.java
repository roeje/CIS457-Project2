package project2.dreamteam;

import java.io.Serializable;
import java.util.Vector;

/**
 * Created by bcom3_000 on 11/5/2016.
 */
public class UserTable implements Serializable{
    private static Vector <UserObject> users;
    public UserTable(){
         this.users = new Vector<>();
    }

    public static void addUser(String pUsername, String pConnectionSpeed, String pHostname){
        UserObject newUser = new UserObject(pUsername, pConnectionSpeed, pHostname);
        users.add(newUser);
    }

    public static boolean removeUser(String username){
        for (UserObject user : users) {
            if (user.getUsername().equals(username)) {
                return users.remove(user);
            }
        }
        return false;
    }

    public static Vector getUsers () {
        return users;
    }
}
