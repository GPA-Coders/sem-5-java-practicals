package com.pratham;
import java.io.*;  
import javax.servlet.http.*;  
import javax.servlet.annotation.*;

@WebServlet("/servlet2")
public class DisplayServlet extends HttpServlet {  
  

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response){  
    try{  
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	      
	    Cookie ck[]=request.getCookies();  
	    out.println("Hello:"+ck[0].getValue() + " from cookie<br>");  
	  
	    HttpSession session=request.getSession(false);  
        String n=(String)session.getAttribute("uname");  
        out.println("Hello "+n + " from session<br>");  
	    
	    
	    out.close();  
  
    }
    catch(Exception e){
    	System.out.println(e);
    }  
 }  
      
  
}  