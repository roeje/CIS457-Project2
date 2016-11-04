package com.company;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
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

public class GuiFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiFrame frame = new GuiFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setToolTipText("Connection");
		panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Connection", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 657, 123);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblServerIp = new JLabel("Server IP: ");
		lblServerIp.setBounds(10, 25, 60, 14);
		panel.add(lblServerIp);

		textField_2 = new JTextField();
		textField_2.setBounds(74, 22, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setBounds(10, 62, 60, 14);
		panel.add(lblUsername);

		textField_3 = new JTextField();
		textField_3.setBounds(74, 59, 86, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblPort = new JLabel("Port: ");
		lblPort.setBounds(249, 25, 46, 14);
		panel.add(lblPort);

		textField_4 = new JTextField();
		textField_4.setBounds(320, 22, 86, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);

		JButton btnConnect = new JButton("Connect");


		btnConnect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {


			}
		});

		btnConnect.setBounds(475, 21, 89, 23);
		panel.add(btnConnect);

		JLabel lblHostname = new JLabel("Hostname: ");
		lblHostname.setBounds(249, 62, 65, 14);
		panel.add(lblHostname);

		textField_5 = new JTextField();
		textField_5.setBounds(320, 59, 86, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);

		JLabel lblSpeed = new JLabel("Speed: ");
		lblSpeed.setBounds(438, 62, 46, 14);
		panel.add(lblSpeed);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(494, 59, 28, 20);
		panel.add(comboBox);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "File Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 145, 657, 185);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblKeyword = new JLabel("Keyword: ");
		lblKeyword.setBounds(10, 24, 56, 14);
		panel_1.add(lblKeyword);

		textField_1 = new JTextField();

		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					// Run Search Command
			    }

			}
		});
		textField_1.setBounds(75, 21, 460, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);

		JButton btnSearch = new JButton("Search");

		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});


		btnSearch.setBackground(new Color(240, 240, 240));
		btnSearch.setBounds(558, 20, 89, 23);
		panel_1.add(btnSearch);

		table = new JTable();
		table.setBounds(10, 54, 637, 120);
		panel_1.add(table);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "FTP", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 341, 657, 178);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		TextArea textArea = new TextArea();
		textArea.setBounds(10, 57, 637, 113);
		panel_2.add(textArea);

		JLabel lblCommand = new JLabel("Command: ");
		lblCommand.setBounds(10, 24, 56, 14);
		panel_2.add(lblCommand);

		textField = new JTextField();

		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {

					// Run FTP Command
			    }
			}
		});

		textField.setBounds(75, 21, 456, 20);
		panel_2.add(textField);
		textField.setColumns(10);

		JButton btnGo = new JButton("Go");

		btnGo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});


		btnGo.setBounds(558, 20, 89, 23);
		panel_2.add(btnGo);
	}


}
