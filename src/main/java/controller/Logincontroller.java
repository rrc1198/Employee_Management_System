package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp_dao.Dao_class;


@WebServlet("/Logincontroller")
public class Logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Logincontroller() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text.html");
		PrintWriter pw=response.getWriter();
		
		String email=request.getParameter("user");
		String password=request.getParameter("password");
		
		if(Dao_class.userlogin(email, password)) {
			
			RequestDispatcher rd=request.getRequestDispatcher("Home.html");
			
			rd.forward(request, response);
			
		}else {
			
			pw.print("password or username is wrong !!!");
			
			RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			
			rd.include(request, response);

		}
		
		
	}

}
