	 
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	 
	public class BasicInsert {
	 
	  public static void main(String[] args) throws ClassNotFoundException, SQLException {
	      
	    
		  Class.forName("com.mysql.jdbc.Driver"); // loads mysql driver
	      
	      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root"); // create new connection with test database
	      
	      String query="insert into persons(name, password) values(?,?)";
	      
	      PreparedStatement ps=con.prepareStatement(query);  // generates sql query
	      
	      
	      ps.setString(1,"shesha");
	      ps.setString(2,"123456");
	      
	      ps.executeUpdate(); // execute it on test database
	      System.out.println("successfuly inserted");
	      ps.close();
	      con.close();
	  }
	 
	}
