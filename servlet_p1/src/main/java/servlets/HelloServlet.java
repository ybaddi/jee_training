package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String htmlcode ="<html> <body> <h1> hello baddi </h1> </body> </html>"    ;
		
		
		PrintWriter out = response.getWriter();
		out.println(htmlcode);
		
		
	}
}
