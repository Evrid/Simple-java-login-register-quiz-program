package Quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



import javax.swing.JOptionPane;

import RegisterLogin.UserHome;


public class Quiz 
{    
	public static void main(String[] args, String username1) 
	{        
		Question question0 = new MultipleChoiceQuestion("What is color of a Snowy owl?", "blue", "red", "green", "yellow", "white", "e");        
		//is inheritance,  ParentClass objectName= new ChildClass();
		question0.check();        
		question0.showResults();        
		Question question1 = new MultipleChoiceQuestion("How many species of insects are there been discovered?", "over one million", "over 0.1 million", "over 0.01 million", "1000", "5000", "a");        
		question1.check();        
		question1.showResults();        
		Question question2 = new MultipleChoiceQuestion("How many dogs has queen elizabeth ii owned?", "One", "Ten", "Thirty", "Eight", "Twenty", "c");
        question2.check();        
		question2.showResults();        
		Question question3 = new MultipleChoiceQuestion("how many cats are there in the world?", "600 million", "800 million", "100 million", "60 million", "300 million", "a");        
		question3.check();        
		question3.showResults();        
		Question question4 = new MultipleChoiceQuestion("how many trees are there in the world?", "1.04 trillion", "3.04 trillion", "800 million", "10.08 trillion", "100 million", "b");        
		question4.check();        
		question4.showResults();    
		Question question5=new TrueFalseQuestion ("Most teachers are women.","TRUE");
		question5.check();        
		question5.showResults();   
		Question question6=new TrueFalseQuestion ("There are more cats than people.","FALSE");
		question6.check();        
		question6.showResults(); 
		Question question7=new TrueFalseQuestion ("USA is founded 1776.","TRUE");
		question7.check();        
		question7.showResults();   
		Question question8=new TrueFalseQuestion ("Most cats are preditor.","TRUE");
		question8.check();        
		question8.showResults();   
		Question question9=new TrueFalseQuestion ("China is largest economy.","FALSE");
		question9.check();        
		question9.showResults();   
		Question question10=new TrueFalseQuestion ("People have been to moon.","TRUE");
		question10.check();        
		question10.showResults();   
		
		 try { 

			   Connection connection = MyConnection1.getConnection();
			   
			 
			   //we don't get value, we set value, so we don't use PreparedStatement, we use createStatement
			
			   String query =" UPDATE  account SET score = \""+Question.GiveResults()+"\" WHERE user_name = \""+username1+"\"";   //we first check to see if username already exist
			   
			   System.out.println(query);
			   //we didn't use prepared statement
                   Statement sta = connection.createStatement();
                   
                   
                   
                   sta.executeUpdate(query);
                   //insert the data into SQL
                   JOptionPane.showMessageDialog(null,"now updated your score");

			 
		 } catch (Exception exception) {
			 exception.printStackTrace();
		 }
		 
		 new UserHome(username1); 
}
	}
