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

    public static void removeUser(String username){
//        Vector<UserObject> removeList = new Vector<>();
        for (UserObject user : (Vector<UserObject>)users.clone()) {
            if (user.getUsername().equals(username)) {
                users.remove(user);
            }
        }
//        users.removeAll(removeList);
    }

    public static Vector getUsers () {
        return users;
    }

    public static void printUsers() {
        for (UserObject user : users) {
            System.out.println("---------------------------");
            System.out.println(user.getUsername());
            System.out.println("---------------------------");
        }
    }
}
