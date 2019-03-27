package loginPanelPackage;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;



public class loginPanel extends JFrame {

	

	private JPanel contentPane;
	private JTextField pass; 


	
	public static void main(String[] args) {
	
	
		//Initialize the frame
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginPanel frame = new loginPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


//	JFrame Design
	public loginPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 235, 308);
		contentPane = new JPanel();
		contentPane.setDoubleBuffered(false);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblXxxx = new JLabel("Blackbox");
		lblXxxx.setForeground(new Color(255, 255, 255));
		lblXxxx.setFont(new Font("Yu Gothic", Font.PLAIN, 36));
		lblXxxx.setBounds(35, 38, 160, 58);
		contentPane.add(lblXxxx);
		
		pass = new JTextField();
		pass.setBounds(35, 174, 160, 26);
		contentPane.add(pass);
		pass.setColumns(10);
		
		JLabel lblBeta = new JLabel("Build 1.6");
		lblBeta.setBackground(Color.BLACK);
		lblBeta.setForeground(Color.WHITE);
		lblBeta.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblBeta.setBounds(142, 85, 75, 32);
		contentPane.add(lblBeta);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		
		//GO Button & Action Listener
		btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
																	
						try {
																	
						//Initialize the ClassLoader
						ClassLoader classLoader = ClassLoader.getSystemClassLoader();
																	
						//Use ClassLoader to load a file with it's relative path
						//Store .exe in resources folder to be run, rename variables accordingly
						String aimAppPath = "resources/aimApp.exe";
						File aimLauncher = new File (classLoader.getResource(aimAppPath).getFile());
																	
						//Boolean file exists check
						System.out.println("File Found : " + aimLauncher.exists());
							
						
						
						//SQL Driver Connection to PHPmyAdmin
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
						Statement stmt=con.createStatement();
						String sql = "Select * from tblogin where masterkey='"+pass.getText().toString()+"'";
						ResultSet rs=stmt.executeQuery(sql);
																	
								if (rs.next()) {
										Runtime.getRuntime().exec(aimLauncher.getAbsolutePath());
										con.close();
										System.exit(0);
										}
															
						}
						
						catch(Exception e1) {System.out.println(e1);} 
						
			}
		});
		btnNewButton.setBorder(null);
		btnNewButton.setOpaque(false);
		btnNewButton.setIcon(null);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBounds(35, 224, 160, 58);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(-528, -12, 1123, 555);
		contentPane.add(lblNewLabel);
		
		
		setUndecorated(true);
	}
}

