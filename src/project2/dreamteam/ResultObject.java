package project2.dreamteam;

/**
 * Created by bcom3_000 on 11/5/2016.
 */
public class ResultObject implements java.io.Serializable{
    private String fileName;
    private String description;
    private String connectionType;
    private String user;

    public ResultObject(String fileName, String description, String connectionType, String user) {
        this.fileName = fileName;
        this.description = description;
        this.connectionType = connectionType;
        this.user = user;
    }

    public String getFileName() {
        return fileName;
    }

    public String getDescription(){
        return this.description;
    }

    public String getConnectionType() {
        return this.connectionType;
    }

    public String getUser(){
        return this.user;
    }
}
