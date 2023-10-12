package com.pratham;
import java.io.*;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class FirstServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String n = req.getParameter("name");
		String p = req.getParameter("pwd");
		
		if(p.equals("hello") && n.equals("Jack")) {
			RequestDispatcher rd = req.getRequestDispatcher("SecondServlet");
			rd.forward(req, resp);
		}
		else {
			out.println("Invalid Username or Password");
			RequestDispatcher rd = req.getRequestDispatcher("/index.html");
			rd.include(req, resp);
		}
	}
}