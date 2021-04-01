package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class HelloServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		
		String val1 = request.getParameter("val1");
		String val2 = request.getParameter("val2");
		

		String op = request.getParameter("op");
		int res=0;
		
		
		
		

		int day = Integer.valueOf(request.getParameter("day"));
		int month = Integer.valueOf(request.getParameter("month"));
		int year = Integer.valueOf(request.getParameter("year"));
		
		LocalDate ld = LocalDate.of(year, month, day);
		
		int age = Period.between(ld , LocalDate.of(2021, 4, 1) ).getYears();
		int age_m = Period.between(ld , LocalDate.of(2021, 4, 1) ).getMonths();
		
		
		
		
		String htmlcode = "<html> <body> ";
		
		if(val1 != null && val2 != null) {
			
			int sum = 0;
			boolean  error = false; 
			try {
				int val1_int = Integer.valueOf(val1);
						int val2_int = Integer.valueOf(val2);
			sum = val1_int + val2_int;
			
			
			
			switch(op) {
			case "+": res=val1_int  + val2_int  ;
			break;
			case "*" : res = val1_int  * val2_int ;
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
		
		
		htmlcode +="<h1> mon age est " + age +"  en month " + age_m + " </h1> " ;
		
		htmlcode +="<h1> resultat est " + res +" </h1> " ;
		
		
		
		htmlcode += "</body> </html>" ;
		
		
		
		PrintWriter out = response.getWriter();
		out.println(htmlcode);
		
		
	}
}
