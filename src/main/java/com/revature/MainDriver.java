package com.revature;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.FinManagerDao;
import com.revature.dao.FinManagerDaoImpl;
import com.revature.dao.LogDao;
import com.revature.dao.LogDaoImpl;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;
import com.revature.models.Employee;
import com.revature.models.FinManager;
import com.revature.models.Log;
import com.revature.models.Request;
import com.revature.service.EmployeeService;

public class MainDriver {

	public static void main(String[] args) {

		Employee emp = new Employee();
		EmployeeDao empDao = new EmployeeDaoImpl();
		//System.out.println(empDao.selectEmployeeById(1));
//		System.out.println(empDao.selectEmployeeByName("userPatS"));
//		System.out.println(empDao.selectAllEmployees());
		
		Request req = new Request();
		RequestDao reqDao = new RequestDaoImpl();
//		emp = empDao.selectEmployeeById(3);
//		req = new Request("testing1", 33, emp.getId());
//		System.out.println(req);
//		reqDao.insertRequest(req);
		//System.out.println(reqDao.selectRequestsByEmployeeId(emp));
		//System.out.println(reqDao.selectRequestById(2));
//		reqDao.deleteRequest(reqDao.selectRequestById(1));
		System.out.println(reqDao.selectAllRequests());
//		System.out.println(reqDao.selectOldestRequest());
		
		FinManager fin = new FinManager();
		FinManagerDao finDao = new FinManagerDaoImpl();
		//System.out.println(finDao.selectFinManagerById(1));
		//System.out.println(finDao.selectFinManagerByName("userBOSSMT"));
//		System.out.println(finDao.selectAllFinManagers());
		
		Log log = new Log();
		LogDao lDao = new LogDaoImpl();
//		log = new Log(true,"testing",77,1,1);
//		lDao.insertLog(log);
//		System.out.println(lDao.selectLogById(1));
//		System.out.println(lDao.selectLogsByEmployeeId(empDao.selectEmployeeById(2)));
//		System.out.println(lDao.selectLogsByFinManagerId(finDao.selectFinManagerById(2)));
//		System.out.println(lDao.selectAllLogs());
		
		EmployeeService empServ = new EmployeeService();
//		System.out.println(empServ.employeeLogin("userJoeB", "passJoeB"));
//		System.out.println(empServ.employeeLogin("userJoeB", "pass"));
//		System.out.println(empServ.employeeLogin("user", "passJoeB"));
//		System.out.println(empServ.getAllEmployees());
//		emp = empServ.getEmployee(1);
//		empServ.viewRequests(emp);
//		empServ.viewLogs(emp);
	}
}
