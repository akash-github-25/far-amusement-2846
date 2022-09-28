package com.masai.dao;

import com.masai.bean.Admin;
import com.masai.bean.Department;
import com.masai.bean.Employee;
import com.masai.exception.Adminexception;
import com.masai.exception.Departmentexception;
import com.masai.exception.Employeexception;

public interface Employeedao {
	public Employee loginEmployee(String email, String password)throws Employeexception;
	public Employee viewEmployee(int empid) throws Employeexception;
	public String updateEmployee(String email,String ename) throws Employeexception;
	public String updatePassword(String password,String email) throws Employeexception;
	
}
