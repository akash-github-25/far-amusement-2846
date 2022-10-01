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
import com.masai.exception.Employeexception;

public class Employeedaoimpl implements Employeedao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public Employee loginEmployee(String email, String password) throws Employeexception {
		// TODO Auto-generated method stub
Employee student = null;
		
		try(Connection conn = Conn.provideConnection()) {
			
			
			PreparedStatement ps= conn.prepareStatement("select * from Employee where email = ? AND password = ?");			
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs= ps.executeQuery();
			
			
				if(rs.next()) {
				
				int empid=rs.getInt("empid");
				String ename=rs.getString("ename");
				String n= rs.getString("email");
				String p= rs.getString("password");
				String l=rs.getString("leaverequest");
				
				
			student=new Employee(empid,ename,n,p,l);	
				
				
			}else
				throw new Employeexception("Invalid Username or password.. ");
			
			
			
			
		} catch (SQLException e) {
			throw new Employeexception(e.getMessage());
		}
		
		
		
		return student;
	}

	@Override
	public Employee viewEmployee(int empid) throws Employeexception {
		// TODO Auto-generated method stub
Employee student = null;
		
		try(Connection conn = Conn.provideConnection()) {
			
			
			PreparedStatement ps= conn.prepareStatement("select * from employee where empid = ?");			
			
			ps.setInt(1, empid);
			
			
			ResultSet rs= ps.executeQuery();
			
			
				if(rs.next()) {
				
				
					int empid1=rs.getInt("empid");
					String ename=rs.getString("ename");
					String n= rs.getString("email");
					String p= rs.getString("password");
					String l=rs.getString("leaverequest");
				
				
					student=new Employee(empid1,ename,n,p,l);	
				
				
			}else
				throw new Employeexception("Invalid Username or password.. ");
			
			
			
			
		} catch (SQLException e) {
			throw new Employeexception(e.getMessage());
		}
		
		
		
		return student;
	}

	@Override
	public String updateEmployee(String email, String ename) throws Employeexception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String message=null;
				try(Connection conn= Conn.provideConnection()) {
				 
				 
				
				 PreparedStatement ps=conn.prepareStatement("update Employee set email=? where ename=?");
				 ps.setString(1,email);
				 ps.setString(2, ename);
			     
			     
				int x=ps.executeUpdate();
				 
				 if(x > 0)
					 System.out.println("data updated in Employee sucessfully..!");
				 else
					 System.out.println("updation failed");
				 
				}catch(SQLException e) {
					
					e.printStackTrace();
					message=e.getMessage();
				}
				
				return message;
	}

	@Override
	public String updatePassword(String password, String email) throws Employeexception {
		// TODO Auto-generated method stub
		String message=null;
		try(Connection conn= Conn.provideConnection()) {
		 
		 
		
		 PreparedStatement ps=conn.prepareStatement("update Employee set password=? where email=?");
		 ps.setString(1,password);
		 ps.setString(2, email);
	     
	     
		int x=ps.executeUpdate();
		 
		 if(x > 0)
			 System.out.println("Password updated in Employee sucessfully..!");
		 else
			 System.out.println("updation failed");
		 
		}catch(SQLException e) {
			
			e.printStackTrace();
			message=e.getMessage();
		}
		
		return message;
	}

}
