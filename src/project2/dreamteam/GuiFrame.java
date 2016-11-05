package project2.dreamteam;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.TextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiFrame extends JFrame {

	private JPanel contentPane;
	private JTextField commandField;
	private JTextField keywordField;
	private JTable table;
	private JTextField serverIPField;
	private JTextField usernameField;
	private JTextField portField;
	private JTextField hostnameField;
	private JTextField fileListNameField;

	public static FtpRequestClient client;


	/**
	 * Create the frame.
	 */
	public GuiFrame(FtpRequestClient clientInstance) {

		this.client = clientInstance;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 690);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setToolTipText("Connection");
		panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Connection", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 721, 142);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblServerIp = new JLabel("Server IP: ");
		lblServerIp.setBounds(10, 25, 60, 14);
		panel.add(lblServerIp);

		serverIPField = new JTextField();

		/*Set Default IP address*/
		serverIPField.setText("localhost");
		serverIPField.setBounds(74, 22, 86, 20);
		panel.add(serverIPField);
		serverIPField.setColumns(10);

		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setBounds(10, 62, 60, 14);
		panel.add(lblUsername);

		usernameField = new JTextField();

		/*Set Default User*/
		usernameField.setText("testUser");
		usernameField.setBounds(74, 59, 86, 20);
		panel.add(usernameField);
		usernameField.setColumns(10);

		JLabel lblPort = new JLabel("Port: ");
		lblPort.setBounds(249, 25, 46, 14);
		panel.add(lblPort);

		portField = new JTextField();

		portField.setText("3202");
		portField.setBounds(320, 22, 86, 20);
		panel.add(portField);
		portField.setColumns(10);

		JButton btnConnect = new JButton("Connect");


		btnConnect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				String ip = serverIPField.getText();
				int port = Integer.parseInt(portField.getText());
				client.connectToServer(port, ip);

			}
		});

		btnConnect.setBounds(10, 101, 89, 23);
		panel.add(btnConnect);

		JLabel lblHostname = new JLabel("Hostname: ");
		lblHostname.setBounds(249, 62, 65, 14);
		panel.add(lblHostname);

		hostnameField = new JTextField();
		hostnameField.setBounds(320, 59, 86, 20);
		panel.add(hostnameField);
		hostnameField.setColumns(10);

		JLabel lblSpeed = new JLabel("Speed: ");
		lblSpeed.setBounds(476, 25, 46, 14);
		panel.add(lblSpeed);

		JComboBox speedDropdown = new JComboBox();

		speedDropdown.addItem("Ethernet");
		speedDropdown.addItem("T1");
		speedDropdown.addItem("DSL");
		speedDropdown.addItem("Dial-Up");

		speedDropdown.setBounds(566, 22, 107, 20);
		panel.add(speedDropdown);

		JButton btnDisconnect = new JButton("Disconnect");

		btnDisconnect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {


			}
		});

		btnDisconnect.setBounds(109, 101, 89, 23);
		panel.add(btnDisconnect);

		JLabel lblFileListName = new JLabel("File List Name:");
		lblFileListName.setBounds(476, 62, 84, 14);
		panel.add(lblFileListName);

		fileListNameField = new JTextField();
		fileListNameField.setBounds(566, 59, 107, 20);
		panel.add(fileListNameField);
		fileListNameField.setColumns(10);

		JButton btnUnregister = new JButton("Unregister");


		btnUnregister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {


			}
		});


		btnUnregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUnregister.setBounds(584, 101, 89, 23);
		panel.add(btnUnregister);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "File Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 164, 721, 236);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblKeyword = new JLabel("Keyword: ");
		lblKeyword.setBounds(10, 24, 56, 14);
		panel_1.add(lblKeyword);

		keywordField = new JTextField();

		keywordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					// Run Search Command
				}

			}
		});
		keywordField.setBounds(75, 21, 537, 20);
		panel_1.add(keywordField);
		keywordField.setColumns(10);

		JButton btnSearch = new JButton("Search");

		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});


		btnSearch.setBackground(new Color(240, 240, 240));
		btnSearch.setBounds(622, 20, 89, 23);
		panel_1.add(btnSearch);

		table = new JTable();
		table.setBounds(10, 54, 701, 171);
		panel_1.add(table);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "FTP", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 410, 721, 230);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		TextArea textArea = new TextArea();
		textArea.setBounds(10, 57, 701, 163);
		panel_2.add(textArea);

		JLabel lblCommand = new JLabel("Command: ");
		lblCommand.setBounds(10, 24, 69, 14);
		panel_2.add(lblCommand);

		commandField = new JTextField();

		commandField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {

					// Run FTP Command
				}
			}
		});

		commandField.setBounds(89, 21, 523, 20);
		panel_2.add(commandField);
		commandField.setColumns(10);

		JButton btnGo = new JButton("Go");

		btnGo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});


		btnGo.setBounds(622, 20, 89, 23);
		panel_2.add(btnGo);
	}

	public void startGui() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiFrame frame = new GuiFrame(client);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiFrame frame = new GuiFrame(client);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
