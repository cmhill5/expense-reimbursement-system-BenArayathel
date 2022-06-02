package com.revature.dao;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDao {

	public Employee selectEmployeeById(int id);
	public Employee selectEmployeeByName(String name);
	public List<Employee> selectAllEmployees();
}
