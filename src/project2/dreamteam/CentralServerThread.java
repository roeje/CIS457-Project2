package project2.dreamteam;

import java.io.* ;
import java.net.* ;
import java.util.* ;

final class CentralServerThread implements Runnable {
    final static String CRLF = "\r\n";
    String clientName;
    int dataPort;

    Socket controlSocket;

//    protected static FileTable files;
//    protected static UserTable users;

    // Control Connection
    DataInputStream controlIn;
    DataOutputStream controlOut;

    // Constructor
    CentralServerThread(Socket socket, UserTable users, FileTable files) throws Exception {
        try {

//            this.files = files;
//            this.users = users;

            controlSocket = socket;
            controlIn = new DataInputStream(controlSocket.getInputStream());
            controlOut = new DataOutputStream(controlSocket.getOutputStream());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void deregister() {


        String username;
        try {

            Socket dataSocket = new Socket(clientName, dataPort);
            DataInputStream din = new DataInputStream(dataSocket.getInputStream());

            username = din.readUTF();
            System.out.println("Removing user: " + username);

            removeUser(username);
            removeUserFiles(username);



            dataSocket.close();

            System.out.println("User: " + username + " deregister");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void saveUserDetails() {
        System.out.println("User save command received from Client.");

        String username;
        String hostname;
        String connectionSpeed;
        String fileName;
        try {

            Socket dataSocket = new Socket(clientName, dataPort);
            DataInputStream din = new DataInputStream(dataSocket.getInputStream());

            username = din.readUTF();
            hostname = din.readUTF();
            connectionSpeed = din.readUTF();
            fileName = din.readUTF();

            System.out.println(username);
            System.out.println(connectionSpeed);
            System.out.println(hostname);
            System.out.println(fileName);

            removeUser(username);
            removeUserFiles(username);

            addUser(username, hostname, connectionSpeed);
            /*Save data to global data object*/

            String newFileName = username + "_" + fileName;

            int bytes;

            OutputStream out = new FileOutputStream((username + "_" + fileName));
            long sizeOfData = din.readLong();
            byte[] buffer = new byte[1024];
            while (sizeOfData > 0 && (bytes = din.read(buffer, 0, (int) Math.min(buffer.length, sizeOfData))) != -1) {
                out.write(buffer, 0, bytes);
                sizeOfData -= bytes;
            }
            out.close();

            /*Process newly saved file: Need to refactor to bypass the need to save file every time*/

            File file = new File(newFileName);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            String[] elements;
            while ((line = br.readLine()) != null) {
                elements = line.split(",");
                System.out.println(elements[0]);
                addFile(elements[0], elements[1], username);
            }
            System.out.println("Current FileTable");
            Vector<FileObject> tmp = FileTable.getFiles();

            for (FileObject fileO: tmp) {
                System.out.println(fileO.getFileName());
            }

            file.createNewFile();
            file.delete();
            dataSocket.close();

            System.out.println("User Info Saved Successfully...");

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    protected synchronized void addUser (String userName, String hostname, String connectionSpeed) {

        UserTable.addUser(userName, connectionSpeed, hostname);
    }

    protected synchronized void removeUser (String userName) {

        UserTable.removeUser(userName);
    }


    protected synchronized void addFile (String fileName, String description, String userName) {

        FileTable.addFile(fileName, description, userName);
    }

    protected synchronized void removeUserFiles (String userName) {

        FileTable.deleteByUsername(userName);
    }

    protected synchronized Vector<ResultObject> searchForFiles(String keyword) {

         return FileTable.searchByDescription(keyword, UserTable.getUsers());
    }

    void keywordSearchResults() {
        System.out.println("Keyword Results Request Received");

        Vector<ResultObject> results;
        String keyword;

        try {

            Socket dataSocket = new Socket(clientName, dataPort);
            DataInputStream din = new DataInputStream(dataSocket.getInputStream());
            ObjectOutputStream dout = new ObjectOutputStream(dataSocket.getOutputStream());

            keyword = din.readUTF();
            System.out.println(keyword);

            results = searchForFiles(keyword);

            dout.writeObject(results);

            dataSocket.close();

            System.out.println("Keyword search results sent successfully");

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    // Implement logic to list content of current working directory
    void listDirContents() {

        System.out.println("Sending list of all directory files...");

        try {

            // Establish connection to client data TCP socket
            Socket dataSocket = new Socket(clientName, dataPort);
            DataOutputStream dout = new DataOutputStream(dataSocket.getOutputStream());

            // Get array of all files in current directory
            File[] files = new File(".").listFiles();

            for (File file : files) {
                dout.writeUTF(file.getName());
            }
            dout.writeUTF("END");

            dout.close();
            dout.flush();
            controlOut.flush();
            dataSocket.close();

            System.out.println("File List Sent To Client.");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Implement logic to send file to client
    void retreveFile(String fileName) {
        System.out.println("Retrieving File: " + fileName);

        try{

            // Connect to client data TCP socket
            Socket dataSocket = new Socket(clientName, dataPort);
            DataOutputStream dout = new DataOutputStream(dataSocket.getOutputStream());

            File file = new File(fileName);
            byte[] bytes = new byte[(int)file.length()];

            FileInputStream fin = new FileInputStream(file);

            BufferedInputStream buffin = new BufferedInputStream(fin);

            DataInputStream datain = new DataInputStream(buffin);
            datain.readFully(bytes, 0, bytes.length);

            dout.writeLong(bytes.length);
            dout.write(bytes, 0, bytes.length);

            dataSocket.close();
            dout.flush();

            System.out.println("File Sent To Client.");

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    // Implement the run() method of the Runnable interface.
    public void run() {
        // Listen on command connection for Command from client. Trigger correct function based on client command.
        System.out.println("Server Thread Started:");
        while(true) {
            try {

                String cmd = controlIn.readUTF();
                System.out.println("Server received command: " + cmd);

                switch(cmd.toUpperCase()) {
                    case "LIST":
                        listDirContents();
                        break;
                    case "RETR":
                        String fileName = controlIn.readUTF();
                        retreveFile(fileName);
                        break;
                    case "QUIT":
                        System.out.println("Client Disconnecting...");
                        controlSocket.close();
                        return;
                    case "DATA":
                        clientName = controlIn.readUTF();
                        dataPort = Integer.parseInt(controlIn.readUTF());
                        break;
                    case "USER":
                        System.out.println("Calling SaveUserDetails...");
                        saveUserDetails();
                        break;
                    case "KEYWORDSEARCH":
                        keywordSearchResults();
                        break;
                    case "DEREGISTER":
                        deregister();
                        break;
                    case "TEST":
                        break;
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
