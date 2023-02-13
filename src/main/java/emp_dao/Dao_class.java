package emp_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import emp_bo.AddEmp_BO;
import emp_bo.employeo_bo;

public class Dao_class {

	public static Connection getConnection()
	{
		Connection con=null;
		
		
          try {
        	  Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","54321");
			
			
		}catch(Exception e) {
			
		System.out.println(e);	
			
		}
		
		
          return con;
		
	}
	public static int signup(employeo_bo em) {
		
		int status=0;
		Connection con=Dao_class.getConnection();
		String q="insert into signup(name,email,phone,password)values(?,?,?,?) ";
		try {
			PreparedStatement ps=con.prepareStatement(q);
			
			ps.setString(1, em.getName());
			ps.setString(2, em.getEmail());
			ps.setString(3, em.getPhone());
			ps.setString(4, em.getPassword());
			
			status=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		return status;
	}
	
	public static boolean userlogin(String email, String password) {
		
		boolean status=false;
		
		try {
			
			Connection con=Dao_class.getConnection();
			
			String q="select * from signup where email=? and password=?";
			
			PreparedStatement ps=con.prepareStatement(q);
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			
			status=rs.next();
			
			
		}catch(Exception e) {
			
		System.out.println(e);
		
		}
		
		return status;
	}
	
	
	public static int Addemployee(AddEmp_BO ae) {
		
		int status=0;
		
		Connection con=Dao_class.getConnection();
		String q="insert into  employee_details(name,email,phone,Date_of_Joining,Date_of_birth,Aadhar_no)values(?,?,?,?,?,?) ";
		try {
			PreparedStatement ps=con.prepareStatement(q);
			
			ps.setString(1, ae.getName());
			ps.setString(2, ae.getEmail());
			ps.setString(3, ae.getPhone());
			ps.setString(4, ae.getDoj());
			ps.setString(5, ae.getDob());
			ps.setString(6, ae.getAdhar());
			
			status=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	return status;
	
	}
	
	public static List Getalldata() {
		
		List List=new ArrayList();
		
		try {
			
			Connection con=Dao_class.getConnection();
			
			PreparedStatement ps=con.prepareStatement("select * from employee_details");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				AddEmp_BO ab=new AddEmp_BO();
				
				ab.setId(rs.getInt(1));
				ab.setName(rs.getString(2));
				ab.setEmail(rs.getString(3));
				ab.setPhone(rs.getString(4));
				ab.setDoj(rs.getString(5));
				ab.setDob(rs.getString(6));
				ab.setAdhar(rs.getString(7));
				List.add(ab);
			}

			
		}catch(Exception e) {
			
			System.out.println(e);
			
		}
		
		
		return List;
	}
	
	
	public static AddEmp_BO Edit(int eid) {
		
		AddEmp_BO ab=new AddEmp_BO();
		
		try {
			
			Connection con=Dao_class.getConnection();
			
			String q="Select * from employee_details where id=? ";
			
			PreparedStatement ps=con.prepareStatement(q);
			
			ps.setInt(1, eid);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
			ab.setId(rs.getInt(1));
			ab.setName(rs.getString(2));
			ab.setEmail(rs.getString(3));
			ab.setPhone(rs.getString(4));
			ab.setDoj(rs.getString(5));
			ab.setDob(rs.getString(6));
			ab.setAdhar(rs.getString(7));
			}else {
				
				System.out.println("Id not matched...");
			}
			
		}catch(Exception e) {
			
			System.out.println(e);
			
		}
		
		return ab ;
	}
	
	
public static int update(AddEmp_BO eb) {
		
		
		int status=0;
		
		try {
			
			Connection con=Dao_class.getConnection();
			
			String q="update employee_details set name=?,email=?,phone=?,Date_of_Joining=?,Date_of_birth=?,Aadhar_no=? where id=?";
			
			PreparedStatement ps=con.prepareStatement(q);
			
            ps.setString(1, eb.getName());			
            ps.setString(2, eb.getEmail());			
            ps.setString(3, eb.getPhone());			
            ps.setString(4, eb.getDoj());			
            ps.setString(5, eb.getDob());			
            ps.setString(6, eb.getAdhar());
            
            ps.setInt(7, eb.getId());
            
            status=ps.executeUpdate();
				
		}catch(Exception e) {
			
			System.out.println(e);
			
		}
		
		return status ;
		
}

public static int delete(int id)
{
	int status=0;
	
	try {
		
		Connection con=Dao_class.getConnection();
		String s="delete  from employee_details where id=?";
		
		PreparedStatement ps=con.prepareStatement(s);
		ps.setInt(1, id);
		
		status=ps.executeUpdate();
		
		
		
		
		
		
	} catch (Exception e) 
	{
		System.out.println(e);
	}
	
	
	
	return status;
	
	
	
}


  
	

}
