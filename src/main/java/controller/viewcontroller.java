package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp_bo.AddEmp_BO;
import emp_dao.Dao_class;


@WebServlet("/viewcontroller")
public class viewcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public viewcontroller() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		PrintWriter pw=response.getWriter();
		
		pw.print("<Table border='1px' width='100%'>");
		
		pw.print("<tr><th>id</th><th>name</th><th>email</th><th>phone</th><th>doj</th>"
				+ "<th>dob</th><th>aadhar no</th><th>Action</th></tr>");
		
		List <AddEmp_BO>List=Dao_class.Getalldata();
		
		for (AddEmp_BO adb : List) {
			
			pw.print("<tr><td>"+adb.getId()+"</td><td>"+adb.getName()+"</td><td>"+adb.getEmail()+
					"</td><td>"+adb.getPhone()+"</td><td>"+adb.getDoj()+"</td><td>"+adb.getDob()+
					"</td><td>"+adb.getAdhar()+"</td><td>"+"<a href='Edit_Controller?id="+adb.getId()+
					"'>edit</a></td><td>"+"<a href='deletecontroller?id="+adb.getId()+
					"'>delete</a></td></tr>");
			
		}
		
		
		pw.print("</Table>");
		
	
	}

}
