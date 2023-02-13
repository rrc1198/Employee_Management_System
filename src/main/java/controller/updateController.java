package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp_bo.AddEmp_BO;
import emp_dao.Dao_class;


@WebServlet("/updateController")
public class updateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public updateController() {
        super();

    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		PrintWriter pw=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String doj=request.getParameter("doj");
		String dob=request.getParameter("dob");
		String adhar=request.getParameter("adhar");
		
		AddEmp_BO eb=new AddEmp_BO();
		
		eb.setId(id);
		eb.setName(name);
		eb.setEmail(email);
		eb.setPhone(phone);
		eb.setDoj(doj);
		eb.setDob(dob);
		eb.setAdhar(adhar);
		
		int status=Dao_class.update(eb);
		
		if(status>0) {
			
			RequestDispatcher rd=request.getRequestDispatcher("viewcontroller");
			rd.forward(request, response);
			
		}
		
		
		


	}

}
