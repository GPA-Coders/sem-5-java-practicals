package com.pratham;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class SecondServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String n = req.getParameter("name");
		
		out.println("<html><body><h1>Hello " + n + "</h1></body></html>" );
		
		out.close();
		
	}
	
	
}
