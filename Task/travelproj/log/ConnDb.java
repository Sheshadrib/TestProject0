package log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnDb {
	
	public static boolean validate(String name, String pass) throws ClassNotFoundException, SQLException{
		
		boolean status= false;
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","root");  
			 String query="select * from Passengers where UserID=? and Password=?";
			  
			PreparedStatement ps=con.prepareStatement(query);  
		    ps.setString(1,name);  
			ps.setString(2,pass);  
			      
			
			ResultSet rs=ps.executeQuery();  
			status=rs.next(); 
			ps.close(); 
			con.close(); 
			 }         
			catch(Exception e){System.out.println(e);}  
			  
			return status;
		
	}

}
