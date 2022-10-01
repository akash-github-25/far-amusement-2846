package com.masai.use;

import java.util.Scanner;

import com.masai.bean.Admin;
import com.masai.bean.Department;
import com.masai.bean.Employee;
import com.masai.dao.Admindao;
import com.masai.dao.Admindaoimpl;
import com.masai.dao.Employeedao;
import com.masai.dao.Employeedaoimpl;
import com.masai.exception.Adminexception;
import com.masai.exception.Departmentexception;
import com.masai.exception.Employeexception;

public class Employeework {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("WELCOME TO HUMAN RESOURCE MANAGEMENT APP");
		 
		System.out.println("1.Admin 2.Employee");
		System.out.println("choose your option");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:
			System.out.println("ADMIN-LOGIN");
			System.out.println("Give username");
			String uname=sc.next();
			System.out.println("Give Password");
			String pass=sc.next();
			Admindao dao = new Admindaoimpl();
			
			try {
			     Admin s= dao.loginAdmin(uname, pass);
			
		 		System.out.println("WELCOME ADMIN :"+s.getUsername());
		 		
		 		Boolean v=true;
		 		while(v) {
		 		System.out.println("1.ADD DEPARTMENT\r\n"
		 				+ "2.VIEW DEPARTMENT\r\n"
		 				+ " 3.UPDATE DEPARTMENT\r\n"
		 				+ " 4.REGISTER NEW EMPLOYEE \r\n"
		 				+ "5.TRANSFER EMPLOYEE TO DEPARTMENTS\r\n"
		 				+ " 6.GRANT LEAVE \r\n"
		 				+ "7.ADMIN LOGOUT\r\n"
		 				+ "");
		 		
		 		int x=sc.nextInt();
		 		if(x==1) {
		 			System.out.println("Give DepartmentId");
		 			int a1=sc.nextInt();
		 			System.out.println("Give Department Name");
		 			String a2=sc.next();
		 			
		 			String s1 =dao.addDepartment(a1,a2);
		 			if(s1!=null) {
		 			System.out.println(s1);
		 			}
		 		
		 			
		 			
		 		}
		 		if(x==2) {
		 			System.out.println("Give Departmentid To View");
		 			int c1=sc.nextInt();
		 			try {
						Department z=dao.viewDepartment(c1);
						System.out.println(z);
					} catch (Departmentexception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//		 			System.out.println("1.Add department 2.View department 3.update department 4.Register new employee 5.transfer employee6.grant leave");
//		 			x=sc.nextInt();
		 			
		 		
		 		}
		 		if(x==3) {
		 			System.out.println("Give Departmentid For Updation");
		 			int u=sc.nextInt();
		 			System.out.println("Give New Department Name");
		 			String u1=sc.next();
		 			try {
						String mes=dao.updateDepartment(u1, u);
					} catch (Departmentexception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		 		}
		 		if(x==4) {
		 			
		 			
		 			System.out.println("Enter Employee ID:");
		 			int id= sc.nextInt();
		 			System.out.println("Enter Employee Name:");
		 			String sname= sc.next();
		 			System.out.println("Enter Employee Email:");
		 			String email= sc.next();
//		 			System.out.println("Enter Student password:");
//		 			String password= sc.next();
		 			
//		 			StudentDao dao=new StudentDaoImpl();
		 			
		 			
		 			
		 			Employee student= new Employee();
		 			student.setEname(sname);
		 			student.setEmpid(id);
		 			student.setEmail(email);
//		 			student.setPassword(password);
		 			
		 			
		 			
		 			
		 			String result=null;
					try {
						result = dao.registerEmployee(student);
					} catch (Employeexception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		 			if(!result.equals(null)) {
		 			System.out.println(result);
		 			}
		 		}
		 		if(x==5) {
		 			System.out.println("Enter the Departmentid");
		 			int did= sc.nextInt();

		 			System.out.println("Enter the Employeeid");
		 			int empid= sc.nextInt();
		 			String mx=null;
		 			try {
					 mx=dao.registerEmployeeInsideADepartment(did, empid);
					} catch (Employeexception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Departmentexception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		 			
		 			if(!mx.equals(null)) {
		 				System.out.println(mx);
		 			}
		 		}
		 		if(x==6) {
		 			System.out.println("Grant Leave To Employee Having Employeeid -");
		 			int empid=sc.nextInt();
		 			String b=null;
		 			try {
					 b=dao.Leaverequest(empid);
					} catch (Employeexception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		 			if(b!=null) {
		 				System.out.println(b);
		 			}
		 		}
		 		if(x==7) {
		 			v=false;
		 			System.out.println("ADMIN LOGOUT");
		 		}
		 		}
		 	
			}catch (Adminexception e) {
				System.out.println(e.getMessage());
			}
			
		case 2:
			System.out.println("EMPLOYEE-LOGIN");
			System.out.println("Give Username");
			String uname1=sc.next();
			System.out.println("Give Password");
			String pass1=sc.next();
			Employeedao dao1 = new Employeedaoimpl();
			
			try {
				Employee e=dao1.loginEmployee(uname1, pass1);
				System.out.println("Welcome "+e.getEname());
				Boolean v=true;
				while(v) {
					System.out.println("1.View profile \r\n"
							+ "2.update profile \r\n"
							+ "3.change password\r\n"
							+ " 4.request for leave\r\n"
							+ " 5.Exit\r\n"
							+ "");
					int x=sc.nextInt();
					if(x==1) {
//						System.out.println("Give empid to view");
			 			int c1=e.getEmpid();
			 			try {
							Employee z=dao1.viewEmployee(c1);
							System.out.println(z);
						} catch (Employeexception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					if(x==2) {
						System.out.println("Give Employee Name ");
			 			String u=sc.next();
			 			System.out.println("Give New Email");
			 			String u1=sc.next();
			 			try {
							String mes=dao1.updateEmployee(u1, u);
						} catch (Employeexception e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					}
					if(x==3) {
						System.out.println("Give Email ");
			 			String u=sc.next();
			 			System.out.println("Give new Password");
			 			String u1=sc.next();
			 			try {
							String mes=dao1.updatePassword(u1, u);
						} catch (Employeexception e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					}
					if(x==4) {
//						System.out.println();
						int t=e.getEmpid();
						Admindao dao3 = new Admindaoimpl();
						String c=dao3.Leaverequest(t);
						if(c!=null) {
						System.out.println(c);
						}
					}
					if(x==5) {
						v=false;
						System.out.println("Employee Logged Out");
					}
				}
			} catch (Employeexception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			
		}
	}

	
	


