package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class CoursesProf extends JFrame {
	private JTable table;
	private JTable table1;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoursesProf frame = new CoursesProf();
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
	public CoursesProf() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Main menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CS487example().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(10, 10, 112, 33);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(435, 10, 127, 33);
		contentPane.add(lblNewLabel_1);


		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(502, 10, 179, 33);
		contentPane.add(label);
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("Admin.ser"));
		    String customerID = reader.readLine();
		    reader.close();
		    label.setText(customerID);
		    
		}
		catch (Exception r) {
			JOptionPane.showMessageDialog(null, "Error, try again");
			r.printStackTrace();
		}
		
		JButton btnNewButton_2 = new JButton("Sign out");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login().setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(691, 18, 85, 21);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("My Courses");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(46, 80, 164, 33);
		contentPane.add(lblNewLabel);
		
		String[][] data = new String[6][4];
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/ORCL", "HR", "oracle");
            PreparedStatement pst = conn.prepareStatement("select * from COURSES");
           	ResultSet rs = pst.executeQuery();
            Statement st = conn.createStatement();
            int i = 0;
            while(rs.next()) {
            	data[i][0] = rs.getString("ID");
            	data[i][1] = rs.getString("CLASS");
            	data[i][2] = rs.getString("PROFESSOR");
            	data[i][3] = rs.getString("GRADE");
            	i++;
            }
	        st.close();
        	conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String[] columnNames = {"ID", "Course", "Professor", "Grade"};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(68, 120, 644, 149);
		getContentPane().add(scrollPane);
		table = new JTable(data,columnNames);
		scrollPane.setViewportView(table);
		
		JLabel lblMyStudents = new JLabel("My Students");
		lblMyStudents.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMyStudents.setBounds(46, 266, 164, 33);
		contentPane.add(lblMyStudents);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			} 
		});
		
		
		
		
		String[][] data1 = new String[6][5];
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/ORCL", "HR", "oracle");
            PreparedStatement pst = conn.prepareStatement("select * from STUDENTS");
           	ResultSet rs = pst.executeQuery();
            Statement st = conn.createStatement();
            int i = 0;
            while(rs.next()) {
            	data1[i][0] = rs.getString("ID");
            	data1[i][1] = rs.getString("NAME");
            	data1[i][2] = rs.getString("EMAIL");
            	data1[i][3] = rs.getString("SEX");
            	data1[i][4] = rs.getString("PHONENUMBER");
            	i++;
            }
	        st.close();
        	conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String[] columnNames1 = {"ID", "Name", "Email", "Sex", "Phonenumber"};
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(68, 309, 644, 149);
		getContentPane().add(scrollPane1);
		table1 = new JTable(data1,columnNames1);
		scrollPane1.setViewportView(table1);
		table1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			} 
		});
	}
}
