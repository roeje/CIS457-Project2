package project2.dreamteam;

/**
 * Created by roeje on 11/4/2016.
 */
import java.awt.event.*;

public class ExitListener extends WindowAdapter {

    FtpClientThread client;

    public ExitListener(FtpClientThread client) {
        this.client = client;
    }

    public void windowClosing(WindowEvent e) {
        client.disconnect();
        System.exit(0);
    }
}

