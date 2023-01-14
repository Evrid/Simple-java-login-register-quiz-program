package Quiz;

import java.sql.Connection;
import java.sql.DriverManager;


public class MyConnection1 {
    
    
    // create a function to connect with mysql database
    
    public static Connection getConnection(){
     
        Connection con = null;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://193.23.127.132:3306/swing_demo", "remoteUser", "123456");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return con;
    }
    
}   