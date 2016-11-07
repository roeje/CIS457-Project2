package project2.dreamteam;

/**
 * Created by bcom3_000 on 11/5/2016.
 */
public class FileObject implements java.io.Serializable{
    private String fileName;
    private String description;
    private String user;

    public FileObject(String pName, String pDescription, String pUser) {
        this.fileName = pName;
        this.description = pDescription;
        this.user = pUser;
    }

    public String getFileName() {
        return fileName;
    }

    public String getDescription(){
        return this.description;
    }

    public String getUser(){
        return this.user;
    }
}
