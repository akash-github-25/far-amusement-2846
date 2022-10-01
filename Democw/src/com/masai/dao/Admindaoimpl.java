package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.bean.Admin;
import com.masai.bean.Department;
import com.masai.bean.Employee;
import com.masai.conn.Conn;
import com.masai.exception.Adminexception;
import com.masai.exception.Departmentexception;
import com.masai.exception.Employeexception;

public class Admindaoimpl implements Admindao {
   int leave=1;
	@Override
	public String addDepartment(int did, String dname) {
		// TODO Auto-generated method stub
		String message=null;
		try(Connection conn= Conn.provideConnection()) {
		 
		 
		
		 PreparedStatement ps=conn.prepareStatement("insert into department values(?,?)");
		 ps.setInt(1, did);
	     ps.setString(2,dname);
	     
		int x=ps.executeUpdate();
		 
		 if(x > 0)
			 System.out.println("data inserted in department sucessfully..!");
		 else
			 System.out.println(" data not inserted in department");
		 
		}catch(SQLException e) {
			
			e.printStackTrace();
			message=e.getMessage();
		}
		
		return message;
		
	}
	

	@Override
	public Admin loginAdmin(String username, String password) throws Adminexception {
		// TODO Auto-generated method stub
Admin s1 = null;
		
		try(Connection conn = Conn.provideConnection()) {
			
			
			PreparedStatement ps= conn.prepareStatement("select * from Admin where username = ? AND password = ?");			
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs= ps.executeQuery();
			
			
				if(rs.next()) {
				
				
				String n= rs.getString("username");
				
				String p= rs.getString("password");
				
				
			s1=new Admin(n,p);	
				
				
			}else
				throw new Adminexception("Invalid Username or password.. ");
			
			
			
			
		} catch (SQLException e) {
			throw new Adminexception(e.getMessage());
		}
		
		
		
		return s1;
	}
	public Department viewDepartment(int did) throws Departmentexception {
Department s1 = null;
		
		try(Connection conn = Conn.provideConnection()) {
			
			
			PreparedStatement ps= conn.prepareStatement("select * from department where did = ?");			
			
			ps.setInt(1, did);
			
			
			ResultSet rs= ps.executeQuery();
			
			
				if(rs.next()) {
				
				
				int n= rs.getInt("did");
				
				String p= rs.getString("dname");
				
				
			s1=new Department(n,p);	
				
				
			}else
				throw new Departmentexception("Invalid Username or password.. ");
			
			
			
			
		} catch (SQLException e) {
			throw new Departmentexception(e.getMessage());
		}
		
		
		
		return s1;
	}


	@Override
	public String updateDepartment(String dname, int did) throws Departmentexception {
		// TODO Auto-generated method stub
		String s1=null;
		try(Connection conn= Conn.provideConnection()) {
		 
		 
		
		 PreparedStatement ps=conn.prepareStatement("update department set dname=? where did=?");
		 ps.setString(1,dname);
		 ps.setInt(2, did);
	     
	     
		int x=ps.executeUpdate();
		 
		 if(x > 0)
			 System.out.println("data updated in department sucessfully..!");
		 else
			 System.out.println("updation failed");
		 
		}catch(SQLException e) {
			
			e.printStackTrace();
			s1=e.getMessage();
		}
		
		return s1;
	}


	@Override
	public String registerEmployee(Employee e) throws Employeexception {
		// TODO Auto-generated method stub
String message = "Not Inserted..";
	
		
	
		
		try(Connection conn= Conn.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("insert into employee(empid,ename,email,password,leaverequest,Role) values(?,?,?,?,?,?)");
			
			
			
			ps.setInt(1, e.getEmpid());
			ps.setString(2, e.getEname());
			ps.setString(3, e.getEmail());
			ps.setString(4, "pass-"+e.getEmpid());
			ps.setString(5, "NO");
			ps.setString(6, "TM");
			
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "Employee Registered Sucessfully !";
			
			
			
		} catch (SQLException e1) {
			message = e1.getMessage();
		}
		
		
	
	
		
		return message;
	
	
	
	}


	@Override
	public String registerEmployeeInsideADepartment(int did, int empid) throws Employeexception, Departmentexception {
		// TODO Auto-generated method stub
		String message ="Not Resgistered";
		
		
		try(Connection conn= Conn.provideConnection()) {
			
		 	PreparedStatement ps= conn.prepareStatement("select * from Employee where empid =?");
			
		 	
		 	ps.setInt(1, empid);
		 	
		 	ResultSet rs= ps.executeQuery();
			
		 	if(rs.next()) {
		 		
		 		PreparedStatement ps2= conn.prepareStatement("select * from department where did=?");
		 		
		 		ps2.setInt(1, did);

		 		ResultSet rs2= ps2.executeQuery();
		 		
		 		if(rs2.next()) {
		 			

		 			PreparedStatement ps3= conn.prepareStatement("insert into departemp values(?,?)");
		 			
		 			
		 			ps3.setInt(1, did);
		 			ps3.setInt(2, empid);
		 			
		 			int x= ps3.executeUpdate();
		 			
		 			if(x > 0)
		 				message = "Employee registered inside the Department Sucessfully.. ";
		 			else
		 				throw new Employeexception("Techical error..");
		 			
		 			
		 			
		 		}
		 		else
		 			throw new Departmentexception("Invalid Department...");
		 		
		 		
		 		
		 		
		 	}else
		 		throw new Employeexception("Invalid Employee...");
			
			
			
			
			
			
		} catch (SQLException e) {
			throw new Employeexception(e.getMessage());
		}
		
		
		

		
		
		
		return message;
	}


	@Override
	public String Leaverequest(int empid) throws Employeexception {
		// TODO Auto-generated method stub
		
//			System.out.println(leave);
		String message=null;
		try(Connection conn= Conn.provideConnection()) {
		 
		 
		
		 PreparedStatement ps=conn.prepareStatement("update Employee set leaverequest='Yes' where empid=? AND Role='TL'");
		 
		 ps.setInt(1, empid);
	     
	     
		int x=ps.executeUpdate();
		 
		 if(x > 0)
			 System.out.println("Leave granted sucessfully..!");
		 else
			 System.out.println("you are not authorized for leave");
		 
		}catch(SQLException e) {
			
			e.printStackTrace();
			message=e.getMessage();
		}
		
		return message;
	}
	}

	

	

