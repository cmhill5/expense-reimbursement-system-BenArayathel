package com.revature.service;

import com.revature.models.Employee;
import com.revature.models.FinManager;

public interface SystemService {

	boolean authenticateEmp(Employee emp, String password);
	boolean authenticateFin(FinManager fin, String password);
	boolean validateBalance(double balance);
	boolean validateCategory(String category);
}
