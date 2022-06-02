package com.revature;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.FinManagerDao;
import com.revature.dao.FinManagerDaoImpl;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;
import com.revature.models.Employee;
import com.revature.models.FinManager;
import com.revature.models.Request;

public class MainDriver {

	public static void main(String[] args) {

		Employee emp = new Employee();
		EmployeeDao empDao = new EmployeeDaoImpl();
		//System.out.println(empDao.selectEmployeeById(1));
		//System.out.println(empDao.selectEmployeeByName("userPatS"));
		//System.out.println(empDao.selectAllEmployees());
		
		Request req = new Request();
		RequestDao reqDao = new RequestDaoImpl();
		emp = empDao.selectEmployeeById(1);
//		req = new Request("testing", 99.8, emp.getId());
//		System.out.println(req);
//		reqDao.insertRequest(req);
		//System.out.println(reqDao.selectRequestsByEmployeeId(emp));
		//System.out.println(reqDao.selectRequestById(2));
//		reqDao.deleteRequest(reqDao.selectRequestById(2));
//		System.out.println(reqDao.selectAllRequests());
		
		FinManager fin = new FinManager();
		FinManagerDao finDao = new FinManagerDaoImpl();
		System.out.println(finDao.selectFinManagerById(1));
		System.out.println(finDao.selectFinManagerByName("userBOSSMT"));
		//System.out.println(finDao.selectAllFinManagers());
	}
}
