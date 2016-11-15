package project2.dreamteam;

/*
   CIS 457 - Project 2

   Created by:

      Jesse Roe
      Ben Commet
      Brandon Attala

*/

public class ResultObject implements java.io.Serializable{
    private String fileName;
    private String description;
    private String connectionType;
    private String user;
    private String hostName;

    public ResultObject(String fileName, String description, String connectionType, String user, String hostName) {
        this.fileName = fileName;
        this.description = description;
        this.connectionType = connectionType;
        this.user = user;
        this.hostName = hostName;
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

    public String getHostName() {
        return this.hostName;
    }
}
