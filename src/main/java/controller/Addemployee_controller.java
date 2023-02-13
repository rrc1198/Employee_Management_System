package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp_bo.AddEmp_BO;
import emp_dao.Dao_class;


@WebServlet("/Addemployee_controller")
public class Addemployee_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Addemployee_controller() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
       response.setContentType("text/html");
		
		PrintWriter pw=response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String doj=request.getParameter("doj");
		String dob =request.getParameter("dob");
		String aadhar=request.getParameter("Aadhar_no");

		
		AddEmp_BO ae=new AddEmp_BO(name, email, phone, doj, dob, aadhar);
		
		int status=Dao_class.Addemployee(ae);
		
		if(status>0) {
			
			pw.write("Data added successfully!!!");
		}else {
			
			pw.write("Something went wrong!!!");
			
		}
		
	}
	
	

}
