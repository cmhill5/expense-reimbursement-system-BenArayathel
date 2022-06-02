package com.revature.service;

import com.revature.models.Employee;
import com.revature.models.FinManager;

public interface AuthenticationService {

	boolean authenticateEmp(Employee emp, String password);
	boolean authenticateFin(FinManager fin, String password);
}
