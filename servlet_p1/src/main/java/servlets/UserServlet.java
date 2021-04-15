package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.models.User;



public class UserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

	
		String htmlcode = "<html> <body> ";
		htmlcode +="<h1> Userss  </h1>  <ul>" ;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cnx =  DriverManager.getConnection("jdbc:mysql://localhost/supemir", "root","password");
		
		if(cnx !=null) {
			System.out.println("connected to database succes");
			
			
			// get data
			String sqlSelect ;
			
			String id = request.getParameter("id");
			
			if(id !=null) {
				sqlSelect = "SELECT * FROM USERS WHERE id="+id;

			}else {
				sqlSelect = "SELECT * FROM USERS";
			}
			
			Statement statment = cnx.createStatement();
			
			ResultSet resultSet = statment.executeQuery(sqlSelect);
			
			while (resultSet.next()) {
				long idresult = resultSet.getLong("id");
				String firstnameresult = resultSet.getString("firstname");
				String secondnameresult = resultSet.getString("secondname");
				String emailresult = resultSet.getString("email");
				Timestamp createdDate = resultSet.getTimestamp("CREATED_DATE");
				
				User user = new User(idresult, firstnameresult, secondnameresult,emailresult,  createdDate.toLocalDateTime());
				
				
				System.out.println(user);
				
				htmlcode +="<li> " + user + "</li> " ;
				
			}
			
			
		} else {
			System.out.println("connected to database failed");
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}		
		
		htmlcode +="</ul> </body> </html>" ;
		
		
		
		PrintWriter out = response.getWriter();
		out.println(htmlcode);
		
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		
		String htmlcode = "<html> <body> ";
		htmlcode +="<h1> Userss  </h1>  <ul>" ;
		
		try {
		Connection cnx =  DriverManager.getConnection("jdbc:mysql://localhost/supemir", "root","password");
		
		if(cnx !=null) {
			System.out.println("connected to database succes");
			
			
			// insert data
			
			String firstname = request.getParameter("val1");
			String secondname = request.getParameter("val2");
			String email = request.getParameter("email");
			
			Statement statment = cnx.createStatement();
			
			String sqlInsert = "INSERT INTO USERS (FIRSTNAME, SECONDNAME, EMAIL) " +
			"VALUES ('" + firstname + "'," + secondname + "'," + email+"'," + LocalDateTime.now() + "')";
			
			int result = statment.executeUpdate(sqlInsert);
			
			
				htmlcode +="<li>  user added with success</li> " ;
			
			
			
		} else {
			System.out.println("connected to database failed");
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}		
		
		htmlcode +="</ul> </body> </html>" ;
		
		
		
		PrintWriter out = response.getWriter();
		out.println(htmlcode);
	}
      
}

