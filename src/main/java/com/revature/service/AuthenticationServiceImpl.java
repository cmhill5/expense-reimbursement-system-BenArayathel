package com.revature.service;

import com.revature.models.Employee;
import com.revature.models.FinManager;

public class AuthenticationServiceImpl implements AuthenticationService {

	@Override
	public boolean authenticateEmp(Employee emp, String password) {

		boolean authenticated = false;
		
		if(emp.getPassword().equals(password)) {
			authenticated = true;
		}
		else {
			System.out.println("ERROR: Incorrect password");
		}
		return authenticated;
	}

	@Override
	public boolean authenticateFin(FinManager fin, String password) {

		boolean authenticated = false;
		
		if(fin.getPassword().equals(password)) {
			authenticated = true;
		}
		else {
			System.out.println("ERROR: Incorrect password");
		}
		return authenticated;
	}

}
