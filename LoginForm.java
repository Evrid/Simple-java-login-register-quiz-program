package RegisterLogin;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//------------------------

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//------------------------

public class LoginForm {

	private JFrame frame1;
	private JTextField UserNameField;
	private JTextField PasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm window = new LoginForm();
					window.frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame1 = new JFrame();
		frame1.setVisible(true);
		frame1.setBounds(100, 100, 605, 400);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 18));
		lblNewLabel.setBounds(59, 112, 117, 23);
		frame1.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("MS UI Gothic", Font.BOLD, 18));
		lblPassword.setBounds(59, 184, 117, 23);
		frame1.getContentPane().add(lblPassword);
		
		UserNameField = new JTextField();
		UserNameField.setBounds(172, 112, 117, 23);
		frame1.getContentPane().add(UserNameField);
		UserNameField.setColumns(10);
		
		PasswordField = new JTextField();
		PasswordField.setColumns(10);
		PasswordField.setBounds(172, 188, 117, 23);
		frame1.getContentPane().add(PasswordField);
		
		JButton btnNewButton = new JButton("Login");
		
		//------------------------
		
		

		btnNewButton.addActionListener(new ActionListener() {

		            public void actionPerformed(ActionEvent e) {
		    	        String uname = UserNameField.getText();
		    	        String pass = PasswordField.getText();
		    	     //   System.out.println("clicked"); 
		                try {
				
		                	                    
			        PreparedStatement ps;
			        ResultSet rs;

			        
				  String query = "SELECT * FROM `account` WHERE `user_name` =? AND `password` =?";
			        
				 // System.out.println(query); 
			            ps = MyConnection.getConnection().prepareStatement(query);
			            
			            ps.setString(1, uname);
			            ps.setString(2, pass);
			            
			       //     System.out.println(ps); 
			            
			            rs = ps.executeQuery();

			         //   System.out.println("clicked22"); 
			            
			            if(rs.next())  
			    //rs.next() is true if the value equals provided username and password exist in MySQL (it stores in) rs, makes rs.next() true
			            {
			            	JOptionPane.showMessageDialog(null, "correct!! Welcome");
			            	// System.out.println("correct!!"); 
			            	 frame1.dispose();
				 			new UserHome(uname);  //pass username to UserHome so we know who logged in
			            }
			            else{
			                    JOptionPane.showMessageDialog(null, "Incorrect Username Or Password", "Login Failed", 2);
			                    System.out.println("Incorrect!!");     
			            }
			            
			        } 
			        catch (SQLException ex) {
			          //  Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
			        }
		            }
		});


		            
				//------------------------
		
		btnNewButton.setFont(new Font("MS UI Gothic", Font.BOLD, 21));
		btnNewButton.setBounds(59, 255, 170, 66);
		frame1.getContentPane().add(btnNewButton); 
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame1.dispose();
				new RegisterForm();
			}
		});
		btnRegister.setFont(new Font("MS UI Gothic", Font.BOLD, 21));
		btnRegister.setBounds(346, 255, 170, 66);
		frame1.getContentPane().add(btnRegister);
		
		
	}
	


	


}







	
