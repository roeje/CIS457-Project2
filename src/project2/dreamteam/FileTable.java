package project2.dreamteam;
import java.io.Serializable;
import java.util.Vector;

/**
 * Created by bcom3_000 on 11/5/2016.
 */
public class FileTable implements Serializable{
    private static Vector <FileObject> files;
    public FileTable(){
        this.files = new Vector<>();
    }

    public static void addFile(String pName, String pDescription, String pUser){
        FileObject newFile = new FileObject(pName, pDescription, pUser);
        files.add(newFile);
    }

    public void cascadeByUsername(String pUsername){
        for (FileObject file : this.files){
            if(file.getFileName().equals(pUsername)){
                this.files.remove(file);
            }
        }
    }

    public Vector<FileObject> searchByDescription(String pKeyword){
        Vector<FileObject> matches = new Vector<>();
        for (FileObject file : this.files){
            if(file.getDescription().toLowerCase().contains(pKeyword.toLowerCase())){
                matches.add(file);
            }
        }
        return matches;
    }

    public static Vector getFiles () {
        return files;
    }

}
