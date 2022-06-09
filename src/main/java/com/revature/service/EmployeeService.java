package com.revature.service;

import com.revature.models.Employee;
import com.revature.models.Log;
import com.revature.models.Request;

import java.util.List;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.LogDao;
import com.revature.dao.LogDaoImpl;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;

public class EmployeeService {

	private static EmployeeDao empDao = new EmployeeDaoImpl();
	private static RequestDao reqDao = new RequestDaoImpl();
	private static LogDao lDao = new LogDaoImpl();
	
	public static boolean employeeLogin(String user, String pass) {
		boolean result = false;
		Employee emp = empDao.selectEmployeeByName(user);
		
		if(emp == null) {
			System.out.println("ERROR: No Employee by this Username");
		}
		else if(SystemService.authenticateEmp(emp, pass)) {
			result = true;
		}
		
		return result;
	}
	
	public static Employee getEmployeeByUsername(String user) {
		Employee emp = empDao.selectEmployeeByName(user);
		
		if(emp == null) {
			return null;
		}
		
		emp.setMyRequests(reqDao.selectRequestsByEmployeeId(emp));
		emp.setMyLogs(lDao.selectLogsByEmployeeId(emp));
		
		return emp;
	}
	
	public static Employee getEmployeeById(int id) {
		Employee emp = empDao.selectEmployeeById(id);
		
		if(emp == null) {
			return null;
		}
		
		emp.setMyRequests(reqDao.selectRequestsByEmployeeId(emp));
		emp.setMyLogs(lDao.selectLogsByEmployeeId(emp));
		
		return emp;
	}
	
	public static List<Employee> getAllEmployees(){
		List<Employee> employeeList = empDao.selectAllEmployees();
		
//		for(Employee emp: employeeList) {
//			emp.setMyRequests(reqDao.selectRequestsByEmployeeId(emp));
//			emp.setMyLogs(lDao.selectLogsByEmployeeId(emp));
//		}
		
		return employeeList;
	}
	
	public static List<Request> viewRequests(Employee emp) {
		List<Request> requestList = emp.getMyRequests();
		
		return requestList;
		
//		for(Request req: requestList) {
//			System.out.println(req);
//		}
	}
	
	public static List<Log> viewLogs(Employee emp) {
		List<Log> logList = emp.getMyLogs();
		
		return logList;
		
//		for(Log l: logList) {
//			System.out.println(l);
//		}
	}
	
	public static boolean makeRequest(Employee emp, String category, double balance) {
		if(!SystemService.validateCategory(category)) {
			return false;
		}
		if(!SystemService.validateBalance(balance)) {
			return false;
		}
		
		Request req = new Request(category, balance, emp.getId());
		
		reqDao.insertRequest(req);
		
		return true;
	}
}
