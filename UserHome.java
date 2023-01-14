package RegisterLogin;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;

import java.sql.Statement;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import Quiz.*;   //new

public class UserHome {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserHome window = new UserHome("evrid1");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param uname 
	 */
	public UserHome(String Username)    //was  public UserHome()
	{
		initialize(Username);  //was   initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String Username1)   //was   private void initialize() 
	//we need declare new string as parameter in every new function
	{
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 817, 523);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeHome = new JLabel("Welcome home");
		lblWelcomeHome.setFont(new Font("MS UI Gothic", Font.BOLD, 53));
		lblWelcomeHome.setBounds(0, 0, 426, 156);
		frame.getContentPane().add(lblWelcomeHome);
		
		JLabel lblLabelFullName = new JLabel("New Label");
		lblLabelFullName.setFont(new Font("MS UI Gothic", Font.PLAIN, 55));
		lblLabelFullName.setBounds(423, 30, 338, 95);
		frame.getContentPane().add(lblLabelFullName);
		
		
		//lblLabelFullName.setText("asdasd");
		lblLabelFullName.setText(Username1);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 frame.dispose();  //new
 				new Quiz().main(null, Username1);   //new
				// new test3();
				
			}
		});
		btnNewButton.setFont(new Font("MS UI Gothic", Font.PLAIN, 29));
		btnNewButton.setBounds(190, 176, 179, 88);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Quiz");
		lblNewLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 38));
		lblNewLabel.setBounds(22, 176, 143, 88);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblCurrentScore = new JLabel("Current score:");
		lblCurrentScore.setFont(new Font("MS UI Gothic", Font.PLAIN, 38));
		lblCurrentScore.setBounds(401, 176, 268, 88);
		frame.getContentPane().add(lblCurrentScore);
		

		
		JLabel lblNewLabel_1 = new JLabel("New");
		lblNewLabel_1.setFont(new Font("MS UI Gothic", Font.PLAIN, 38));
		lblNewLabel_1.setBounds(658, 178, 124, 76);
		frame.getContentPane().add(lblNewLabel_1);
		
	
		
		//---------------------
				try {

					  Connection connection = MyConnection.getConnection();

					 String query =" SELECT score FROM account WHERE user_name=?";   //we first check to see if username already exist
			//		 String query2 =" SELECT score FROM account WHERE user_name="+Username1+""; 
			//		 

					 
			//		 System.out.println(query2);
			//		 System.out.println(query3);
					 
					 PreparedStatement PreparedStatement1 = MyConnection.getConnection().prepareStatement(query);  //prepare the statement
					 PreparedStatement1.setString(1, Username1); 
					 System.out.println(PreparedStatement1);
					
		      	ResultSet ResultSet1 = PreparedStatement1.executeQuery();  //execute query
		      	System.out.println(ResultSet1);
		      	
		   //---------------------
		      	
		      	ResultSetMetaData rsmd = ResultSet1.getMetaData();  //added import java.sql.ResultSetMetaData;
		      	int columnsNumber = rsmd.getColumnCount();
		      	while (ResultSet1.next()) {
		      	    for (int i = 1; i <= columnsNumber; i++) {
		      	        if (i > 1) System.out.print(",  ");
		      	        String columnValue = ResultSet1.getString(i);
		     // 	      System.out.println(columnValue);
		      	      lblNewLabel_1.setText(columnValue);
		      	        System.out.print(columnValue + " " + rsmd.getColumnName(i));
		      	    }
		      	    System.out.println("");
		      	}
		      	 //---------------------
		      	
		   //   	System.out.println(columnValue);
		      	
		      	// System.out.print("Name: "+ResultSet1.getString("score")+", ");
		    	
		      	//here use like this because in LoginForm.java we use like this too
		     	 
		    	//if username is match with an existing one, ResultSet1.next() value is true, if not correct ResultSet1.next() value is false
					 
				} catch (Exception exception) {
					exception.printStackTrace();
				}

		      			 
					 
					 
		//---------------------




		
	}
}
