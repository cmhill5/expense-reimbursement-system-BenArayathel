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
	private static SystemService sysServ = new SystemServiceImpl();
	
	public boolean employeeLogin(String user, String pass) {
		boolean result = false;
		Employee emp = empDao.selectEmployeeByName(user);
		
		if(emp == null) {
			System.out.println("ERROR: No Employee by this Username");
		}
		else if(sysServ.authenticateEmp(emp, pass)) {
			result = true;
		}
		
		return result;
	}
	
	public Employee getEmployee(String user) {
		Employee emp = empDao.selectEmployeeByName(user);
		emp.setMyRequests(reqDao.selectRequestsByEmployeeId(emp));
		emp.setMyLogs(lDao.selectLogsByEmployeeId(emp));
		
		return emp;
	}
	
	public Employee getEmployee(int id) {
		Employee emp = empDao.selectEmployeeById(id);
		emp.setMyRequests(reqDao.selectRequestsByEmployeeId(emp));
		emp.setMyLogs(lDao.selectLogsByEmployeeId(emp));
		
		return emp;
	}
	
	public List<Employee> getAllEmployees(){
		List<Employee> employeeList = empDao.selectAllEmployees();
		
		for(Employee emp: employeeList) {
			emp.setMyRequests(reqDao.selectRequestsByEmployeeId(emp));
			emp.setMyLogs(lDao.selectLogsByEmployeeId(emp));
		}
		
		return employeeList;
	}
	
	public void viewRequests(Employee emp) {
		List<Request> requestList = emp.getMyRequests();
		
		for(Request req: requestList) {
			System.out.println(req);
		}
	}
	
	public void makeRequest(Employee emp, String category, double balance) {
		if(!sysServ.validateCategory(category)) {
			return;
		}
		if(!sysServ.validateBalance(balance)) {
			return;
		}
		
		Request req = new Request(category, balance, emp.getId());
		
		reqDao.insertRequest(req);
	}
	
	public void viewLogs(Employee emp) {
		List<Log> logList = emp.getMyLogs();
		
		for(Log l: logList) {
			System.out.println(l);
		}
	}
}
