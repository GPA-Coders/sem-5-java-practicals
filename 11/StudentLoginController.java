package com.pratham;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


public class StudentLoginController extends  HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		
		StudentLoginModel m = new StudentLoginModel();
		m.setUsername(name);
		m.setPassword(pwd);
		
		StudentLoginDAO d = new StudentLoginDAO();
		m = d.checkLogin(m);
		
		if(m.isValid()) {
			HttpSession session = req.getSession();
			session.setAttribute("name", name);
			
			resp.sendRedirect("userLoggedIn.jsp");
		}
		else {
			resp.sendRedirect("InvalidLoggedIn.jsp");
		}
	}
	
	

}
