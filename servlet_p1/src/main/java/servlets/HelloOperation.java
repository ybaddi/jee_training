package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class HelloOperation extends HttpServlet {

 public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
	 
	 HttpSession session = request.getSession();
	 
	 if(session.isNew()) {
		 System.out.println("la session est new");
	 }else {
		 System.out.println("la session exist deja with id " + session.getId());
	 }
	 
	 handle(request,  response)		;
		
		
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		 handle(request,  response)		;
			
			
			
		}
	
	
	

	private void handle(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String val1 = request.getParameter("val1");
		String val2 = request.getParameter("val2");
		

		String op ;
		
		
		String opFromUrl= request.getParameter("op");
		
		if(opFromUrl !=null) {
			op = opFromUrl;
		}else {
			op = getServletConfig().getInitParameter("operator");
		}
		
		
		
		int res=0;
		
		
		System.out.println(op);
			
		
		
		
		String htmlcode = "<html> <body> ";
		
		if(val1 != null && val2 != null) {
			
			int sum = 0;
			boolean  error = false; 
			try {
				int val1_int = Integer.valueOf(val1);
						int val2_int = Integer.valueOf(val2);
			sum = val1_int + val2_int;
			
			
			
			switch(op) {
			case "plus": res=val1_int  + val2_int  ;
			break;
			case "mul" : res = val1_int  * val2_int ;
			break;
			}
			
			
			
			}catch(NumberFormatException e) {
				htmlcode +="<h1>Error val or val2 is not a number </h1>";	
				error = true;
			}
			
			if(!error) htmlcode +="<h2> sum of "+ val1  + " and "  + val2 + " is " + sum + " </h1> "   ;
			
		}else {
			
			 htmlcode +="<h1> val1 and val2 must be not null</h1> "    ;
		}
		
		
		
		
		htmlcode +="<h1> resultat est " + res +" </h1> " ;
		
		
		
		htmlcode += "</body> </html>" ;
		
		
		
		PrintWriter out = response.getWriter();
		out.println(htmlcode);
		
	}
}
