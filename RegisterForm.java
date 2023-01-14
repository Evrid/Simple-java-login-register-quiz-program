package RegisterLogin;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class RegisterForm {
	private JFrame frame;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldEmail;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;
	private JTextField textFieldPhone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterForm window = new RegisterForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegisterForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 757, 526);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Register form");
		lblNewLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 61));
		lblNewLabel.setBounds(182, 10, 387, 130);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("MS UI Gothic", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(38, 156, 123, 24);
		frame.getContentPane().add(lblNewLabel_1);

		textFieldFirstName = new JTextField();
		textFieldFirstName.setBounds(153, 153, 116, 37);
		frame.getContentPane().add(textFieldFirstName);
		textFieldFirstName.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Last Name");
		lblNewLabel_1_1.setFont(new Font("MS UI Gothic", Font.PLAIN, 23));
		lblNewLabel_1_1.setBounds(38, 238, 123, 24);
		frame.getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Email");
		lblNewLabel_1_2.setFont(new Font("MS UI Gothic", Font.PLAIN, 23));
		lblNewLabel_1_2.setBounds(38, 321, 123, 24);
		frame.getContentPane().add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Username");
		lblNewLabel_1_3.setFont(new Font("MS UI Gothic", Font.PLAIN, 23));
		lblNewLabel_1_3.setBounds(374, 150, 123, 24);
		frame.getContentPane().add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Password");
		lblNewLabel_1_4.setFont(new Font("MS UI Gothic", Font.PLAIN, 23));
		lblNewLabel_1_4.setBounds(374, 238, 123, 24);
		frame.getContentPane().add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_5 = new JLabel("Phone");
		lblNewLabel_1_5.setFont(new Font("MS UI Gothic", Font.PLAIN, 23));
		lblNewLabel_1_5.setBounds(374, 321, 123, 24);
		frame.getContentPane().add(lblNewLabel_1_5);

		textFieldLastName = new JTextField();
		textFieldLastName.setColumns(10);
		textFieldLastName.setBounds(153, 238, 116, 37);
		frame.getContentPane().add(textFieldLastName);

		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(153, 310, 116, 37);
		frame.getContentPane().add(textFieldEmail);

		textFieldUsername = new JTextField();
		textFieldUsername.setColumns(10);
		textFieldUsername.setBounds(488, 150, 116, 37);
		frame.getContentPane().add(textFieldUsername);

		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(488, 244, 116, 37);
		frame.getContentPane().add(textFieldPassword);

		textFieldPhone = new JTextField();
		textFieldPhone.setColumns(10);
		textFieldPhone.setBounds(488, 310, 116, 37);
		frame.getContentPane().add(textFieldPhone);

		JButton btnRegisterButton = new JButton("Register");
		btnRegisterButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String firstName = textFieldFirstName.getText();
				String lastName = textFieldLastName.getText();
				String emailId = textFieldEmail.getText();
				String userName = textFieldUsername.getText();
				String mobileNumber = textFieldPhone.getText();
				int len = mobileNumber.length();
				String password = textFieldPassword.getText();
				String score = "0"; // default begin score is 0
				String msg = "" + firstName;
				msg += " \n";
				if (len != 10) {
					JOptionPane.showMessageDialog(null, "Your phone number is bit weird");
				}
				try {
					// Connection connection =
					// DriverManager.getConnection("jdbc:mysql://193.23.127.132:3306/swing_demo",
					// "remoteUser", "123456");
					
//---------------------
					 Connection connection = MyConnection.getConnection();

					String query = "SELECT * FROM account WHERE user_name=?";   //we first check to see if username already exist
                    PreparedStatement PreparedStatement1 = MyConnection.getConnection().prepareStatement(query);
                    PreparedStatement1.setString(1, userName); 
                    ResultSet ResultSet1 = PreparedStatement1.executeQuery();
                    //here use like this because in LoginForm.java we use like this too
                    
                  //if username is match with an existing one, ResultSet1.next() value is true, if not correct ResultSet1.next() value is false
                
                    
                    if(ResultSet1.next())   //when username already exist
		            {
		            
		            	
		            	JOptionPane.showMessageDialog(null, "username exist");
		            	
		            }
		            else //when username doesn't exist
		            {
		        
		            	 String query2 = "INSERT INTO account values('" + firstName + "','" + lastName + "','" + userName + "','" +
			                        password + "','" + emailId + "','" + mobileNumber + "','" + score + "')";
                      //we didn't use prepared statement
			                    Statement sta = connection.createStatement();
			                    int x = sta.executeUpdate(query2);
			                    //insert the data into SQL
			                    JOptionPane.showMessageDialog(null, "Welcome, " + msg + "Your account is sucessfully created, now you can login");
			                    connection.close();
			                    frame.dispose();
			    				new LoginForm();

		            }				
					
					
//---------------------

					
				//	connection.close();
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		});
		btnRegisterButton.setFont(new Font("MS UI Gothic", Font.PLAIN, 30));
		btnRegisterButton.setBounds(196, 399, 290, 37);
		frame.getContentPane().add(btnRegisterButton);
	}
}
