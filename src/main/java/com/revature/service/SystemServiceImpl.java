package com.revature.service;

import java.util.Arrays;

import com.revature.models.Employee;
import com.revature.models.FinManager;

public class SystemServiceImpl implements SystemService {

	@Override
	public boolean authenticateEmp(Employee emp, String password) {
		
		if(emp.getPassword().equals(password)) {
			return true;
		}
		else {
			System.out.println("ERROR: Incorrect password");
		}
		return false;
	}

	@Override
	public boolean authenticateFin(FinManager fin, String password) {
		
		if(fin.getPassword().equals(password)) {
			return true;
		}
		else {
			System.out.println("ERROR: Incorrect password");
		}
		return false;
	}

	@Override
	public boolean validateBalance(double balance) {
		
		if(balance > 0) {
			return true;
		}
		else {
			System.out.println("ERROR: Requested balance must be a POSITIVE number");
		}
		
		return false;
	}

	@Override
	public boolean validateCategory(String category) {

		String[] categoryList = {"LODGING", "TRAVEL", "FOOD", "OTHER"};
		
		if(Arrays.binarySearch(categoryList, category) > 0 ) {
			return true;
		}
		else {
			System.out.println("ERROR: Invalid category; must be LODGING, TRAVEL, FOOD, or OTHER");
		}
		
		return false;
	}

}
