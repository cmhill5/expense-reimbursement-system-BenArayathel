package com.revature.service;

import com.revature.models.Employee;
import com.revature.models.FinManager;

public class SystemService{

	public static boolean authenticateEmp(Employee emp, String password) {
		
		if(emp.getPassword().equals(password)) {
			return true;
		}
		else {
			System.out.println("ERROR: Incorrect password");
		}
		return false;
	}

	public static boolean authenticateFin(FinManager fin, String password) {
		
		if(fin.getPassword().equals(password)) {
			return true;
		}
		else {
			System.out.println("ERROR: Incorrect password");
		}
		return false;
	}

	public static boolean validateBalance(double balance) {
		
		if(balance > 0) {
			return true;
		}
		else {
			System.out.println("ERROR: Requested balance must be a POSITIVE number");
		}
		
		return false;
	}

	public static boolean validateCategory(String category) {
		
		if(category.equals("LODGING") || category.equals("TRAVEL") || category.equals("FOOD") || category.equals("OTHER")) {
			return true;
		}
		else {
			System.out.println("ERROR: Invalid category; must be LODGING, TRAVEL, FOOD, or OTHER");
		}
		
		return false;
	}

}
