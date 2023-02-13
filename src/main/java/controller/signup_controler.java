package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp_bo.employeo_bo;
import emp_dao.Dao_class;


@WebServlet("/controler")
public class signup_controler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public signup_controler() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		
		PrintWriter pw=response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String password=request.getParameter("password");
		
		//pw.print(name+" "+email+" "+phone+" "+password);
		
		employeo_bo em=new employeo_bo();
		
		
		em.setName(name);
		em.setEmail(email);
		em.setPhone(phone);
		em.setPassword(password);
		
		int status=Dao_class.signup(em);
		
		if(status>0) {
			
			pw.print("signup successfully");
		}else {
			
			pw.print("something went wrong");
		//	response.sendRedirect("signup.html");
		}
		
	}

}
