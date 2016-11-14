package project2.dreamteam;
import java.io.Serializable;
import java.util.Vector;

/**
 * Created by bcom3_000 on 11/5/2016.
 */
public class FileTable implements Serializable{
    private static Vector <FileObject> files;
    public FileTable(){
        files = new Vector<>();
    }

    public static void addFile(String pName, String pDescription, String pUser){
        FileObject newFile = new FileObject(pName, pDescription, pUser);
        files.add(newFile);
    }

    public static void deleteByUsername(String pUsername){
        for (FileObject file : (Vector<FileObject>)files.clone()){
            if(file.getUser().equals(pUsername)){
                files.remove(file);
            }
        }
    }

    public static Vector<ResultObject> searchByDescription(String pKeyword, Vector<UserObject> users){
        Vector<ResultObject> matches = new Vector<>();
        for (FileObject file : files){
            if(file.getDescription().toLowerCase().contains(pKeyword.toLowerCase())){
                for (UserObject user : users) {
                    if (user.getUsername().equals(file.getUser())) {
                        ResultObject tmp = new ResultObject(file.getFileName(), file.getDescription(), user.getConnectionSpeed(), user.getUsername());
                        matches.add(tmp);
                        break;
                    }
                }
            }
        }
        return matches;
    }

    public static Vector getFiles () {
        return files;
    }


    public static void printFiles() {
        for (FileObject file : files) {
            System.out.println("---------------------------");
            System.out.println(file.getFileName());
            System.out.println(file.getUser());
            System.out.println(file.getDescription());
        }
    }

}
