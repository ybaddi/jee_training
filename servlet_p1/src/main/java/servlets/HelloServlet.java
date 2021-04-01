package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		
		String val1 = request.getParameter("val1");
		String val2 = request.getParameter("val2");
		
		String htmlcode = "<html> <body> ";
		
		if(val1 != null && val2 != null) {
			
			int sum = 0;
			boolean  error = false; 
			try {
			sum = Integer.valueOf(val1) + Integer.valueOf(val2);
			}catch(NumberFormatException e) {
				htmlcode +="<h1>Error val or val2 is not a number </h1>";	
				error = true;
			}
			
			if(!error) htmlcode +="<h2> sum of "+ val1  + " and "  + val2 + " is " + sum + " </h1> "   ;
			
		}else {
			
			 htmlcode +="<h1> val1 and val2 must be not null</h1> "    ;
		}
		
		
		
		
		
		htmlcode += "</body> </html>" ;
		
		
		
		PrintWriter out = response.getWriter();
		out.println(htmlcode);
		
		
	}
}
