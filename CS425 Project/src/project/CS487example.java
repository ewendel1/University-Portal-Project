package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class CS487example extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CS487example frame = new CS487example();
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
	public CS487example() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Main menu");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 10, 112, 33);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("University portal");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(304, 55, 134, 33);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Students");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/ORCL", "HR", "oracle");
					Statement st = conn.createStatement();
					BufferedReader reader = new BufferedReader(new FileReader("Admin.ser"));
				    String customerID = reader.readLine();
				    reader.close();
					ResultSet rs = st.executeQuery("select * from Students");
					if(rs.next() && rs.getString("EMAIL").compareTo(customerID)==0) {	
		                new Courses().setVisible(true);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Access Denied. You must be a student to access the portal.");
					}
					st.close();
	            	conn.close();
	            	
	            	
				} catch (Exception r) {
					r.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(49, 221, 102, 93);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Job search");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JobSearch().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1.setBounds(347, 221, 112, 93);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Health & Safety");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HealthSafety().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnNewButton_1_2.setBounds(541, 221, 102, 93);
		contentPane.add(btnNewButton_1_2);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(435, 10, 127, 33);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("Sign out");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login().setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(691, 18, 85, 21);
		contentPane.add(btnNewButton_2);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(502, 10, 179, 33);
		contentPane.add(label);
		
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("Admin.ser"));
		    String customerID = reader.readLine();
		    reader.close();
		    label.setText(customerID);
		    
		    JButton btnNewButton_1_3 = new JButton("Professors");
		    btnNewButton_1_3.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/ORCL", "HR", "oracle");
						Statement st = conn.createStatement();
						BufferedReader reader = new BufferedReader(new FileReader("Admin.ser"));
					    String customerID = reader.readLine();
					    reader.close();
						ResultSet rs = st.executeQuery("select * from Professor");
						if(rs.next() && rs.getString("EMAIL").compareTo(customerID)==0) {	
			                new CoursesProf().setVisible(true);
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "Access Denied. You must be a professor to access the portal.");
						}
						st.close();
		            	conn.close();
		            	
		            	
					} catch (Exception r) {
						r.printStackTrace();
					}
		    		
		    	}
		    });
		    btnNewButton_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		    btnNewButton_1_3.setBounds(191, 221, 102, 93);
		    contentPane.add(btnNewButton_1_3);
		    
		    JLabel lblNewLabel_1_1 = new JLabel("Courses:");
		    lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		    lblNewLabel_1_1.setBounds(129, 178, 127, 33);
		    contentPane.add(lblNewLabel_1_1);
		    
		}
		catch (Exception r) {
			JOptionPane.showMessageDialog(null, "Error, try again");
			r.printStackTrace();
		}
           
	}
}
