package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFormattedTextField;

public class HealthSafety extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HealthSafety frame = new HealthSafety();
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
	public HealthSafety() {
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
		
		JLabel lblNewLabel = new JLabel("Health Info");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(34, 64, 164, 33);
		contentPane.add(lblNewLabel);
		
		
		JFormattedTextField frmtdtxtfldWelcome = new JFormattedTextField();
		String formatted = "<html><hl align='center'>Welcome				</hl>";
		formatted = formatted + "<hl>Need a prescription or medical care? Stressed out and just want to talk? The Illinois Institute of Technology Student Health and Wellness Center is dedicated to your total well-being. Contact us at 312.567.7550 or student.health@iit.edu. 					The SHWC is still here for you! We have moved to an online platform for your medical, counseling, and administrative needs.				Please email student.health@iit.edu or call 312.567.7550 to set up your remote appointment. </hl>";
		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setText(formatted);
		lblNewLabel_2.setBounds(33, 90, 308, 160);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel();
		lblNewLabel_2_1.setText("<html><hl align='center'> Dear Fellow Community Members,\r\n"
				+ "\r\n"
				+ "In keeping with recent health guidance from the Centers for Disease Control and Prevention (CDC), Illinois Tech will no longer require face coverings indoors or outdoors as of April 5. Of course, campus community members are welcome and encouraged to continue wearing face coverings if they prefer to do so.\r\n"
				+ "\r\n"
				+ "For more information on our university’s full campus COVID-19 policies, please visit iit.edu/reopening.\r\n"
				+ "\r\n"
				+"</hl>");
		lblNewLabel_2_1.setBounds(34, 260, 308, 150);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel();
		lblNewLabel_2_1_1.setText("<html><hl align='center'>IIT Alert is an emergency alert notification system that Illinois Institute of Technology uses to broadcast important information via text, phone, and email in the event of severe weather or an ongoing situation that affects the safety of our campus communities.\r\n"
				+ "\r\n"
				+ "<hl>");
		lblNewLabel_2_1_1.setBounds(435, 91, 308, 102);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblPublicSafetyInfo = new JLabel("Public Safety Info");
		lblPublicSafetyInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPublicSafetyInfo.setBounds(435, 64, 164, 33);
		contentPane.add(lblPublicSafetyInfo);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel();
		lblNewLabel_2_1_1_1.setText("<html><hl align='center'>Public Safety Escort\r\n"
				+ "The Department of Public Safety currently only provides walking escorts for students, faculty, or staff from an on-campus location to another on-campus location, 24 hours a day, 7 days a week.\r\n"
				+ "\r\n"
				+ "Call 312.808.6310</hl>");
		lblNewLabel_2_1_1_1.setBounds(435, 196, 308, 102);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel();
		lblNewLabel_2_1_1_1_1.setText("<html><hl align='center'>Contact Public Safety\r\n"
				+ "PHONE\r\n"
				+ "1.312.808.6363 (Emergency)\r\n"
				+ "1.312.808.6300 (Non-Emergency)\r\n"
				+ "EMAIL\r\n"
				+ "publicsafety@iit.edu\r\n"
				+ "DEPARTMENT TYPE\r\n"
				+ "Administrative\r\n"
				+ "OFFICE LOCATION\r\n"
				+ "Public Safety\r\n"
				+ "Tech Central\r\n"
				+ "3424 South State Street, Suite 115\r\n"
				+ "Chicago, IL 60616</hl>");
		lblNewLabel_2_1_1_1_1.setBounds(435, 308, 308, 102);
		contentPane.add(lblNewLabel_2_1_1_1_1);
	
	}
}
