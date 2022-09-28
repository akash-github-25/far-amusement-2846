package com.masai.dao;

import com.masai.bean.Admin;
import com.masai.bean.Department;
import com.masai.bean.Employee;
import com.masai.exception.Adminexception;
import com.masai.exception.Departmentexception;
import com.masai.exception.Employeexception;

public interface Admindao {
public String addDepartment(int did,String dname);
public Admin loginAdmin(String username, String password)throws Adminexception; 
public Department viewDepartment(int did) throws Departmentexception;
public String updateDepartment(String dname,int did) throws Departmentexception;
public String registerEmployee(Employee e) throws Employeexception;
public String registerEmployeeInsideADepartment(int did, int empid)throws Employeexception,Departmentexception ;
public String Leaverequest(int empid) throws Employeexception;
}
