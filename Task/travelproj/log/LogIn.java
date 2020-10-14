package log;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import log.ConnDb;

/**
 * Servlet implementation class LogIn
 */
@WebServlet("/aaa")
public class LogIn extends HttpServlet {
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html"); // MIME
        PrintWriter pw= response.getWriter();
	    
		String t1=  request.getParameter("uid");//Sheshadri
	    String t2=  request.getParameter("pid");
	    
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");  
	    	Connection con=DriverManager.getConnection(  
	    	"jdbc:mysql://localhost:3306/test1","root","root");  
	    	 String query="select * from Passengers where UserID=? and Password=?";
	    	  
	    	PreparedStatement ps=con.prepareStatement(query);  
	         ps.setString(1,t1);
	         ps.setString(2,t2);
	    	      
	    	
	    	ResultSet rs=ps.executeQuery();  
	    	 
			if(ConnDb.validate(t1,t2)) {  
			System.out.println("Login Successful..."+t1 +" "+ t2);
			
	       response.sendRedirect("Logsuc.jsp");    
	}  
	else{  
	    System.out.println("Username or Password is not valid..."+t1 +" "+ t2);
	response.sendRedirect("Err.jsp");
	} 
	ps.close(); 
	con.close(); 
} catch (ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} 
}
}