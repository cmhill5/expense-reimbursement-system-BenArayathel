package com.revature.controller;

import org.eclipse.jetty.http.HttpStatus;

import com.revature.models.Employee;
import com.revature.service.EmployeeService;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class EmployeeController {
	
	public static void authenticateByFormParam(Context ctx) {
		
		String username = ctx.formParam("username");
		String password = ctx.formParam("password");
		
		boolean access = EmployeeService.employeeLogin(username, password);
		
		if(access) {
			ctx.result("You have access");
			ctx.status(HttpStatus.ACCEPTED_202);
		}else {
			ctx.result("You don't have access!");
			ctx.status(HttpCode.FORBIDDEN);
		}
		
	}
	
	public static void getEmployeeByUsername(Context ctx) {
		
		String username = ctx.pathParam("username");
		Employee emp = EmployeeService.getEmployeeByUsername(username);
		
		if(emp == null) {
			ctx.status(HttpCode.NOT_FOUND);
		}else {
			ctx.json(emp);
		}
	}
	
	public static void getEmployeeById(Context ctx) {
		
		int id = Integer.parseInt(ctx.pathParam("id"));
		Employee emp = EmployeeService.getEmployeeById(id);
		
		if(emp == null) {
			ctx.status(HttpCode.NOT_FOUND);
		}else {
			ctx.json(emp);
		}
	}
	
	public static void getAllEmployees(Context ctx){
		
		ctx.json(EmployeeService.getAllEmployees());
	}
	
	public static void viewRequests(Context ctx) {
		
		String username = ctx.pathParam("username");
		Employee emp = EmployeeService.getEmployeeByUsername(username);
		
		ctx.json(EmployeeService.viewRequests(emp));
	}
	
	public static void viewLogs(Context ctx) {
		
		String username = ctx.pathParam("username");
		Employee emp = EmployeeService.getEmployeeByUsername(username);
		
		ctx.json(EmployeeService.viewLogs(emp));
	}
	
	public static void makeRequest(Context ctx) {
		
//		System.out.println(ctx.body());
		
//		Planet p = ctx.bodyAsClass(Planet.class);
//		planetList.add(p);
//		
//		ctx.status(HttpCode.CREATED);

		String username = ctx.pathParam("username");
		String category = ctx.pathParam("category");
		double balance = Double.parseDouble(ctx.pathParam("balance"));
		
		Employee emp = EmployeeService.getEmployeeByUsername(username);
		
		boolean made = EmployeeService.makeRequest(emp, category, balance);
		
		if(made){
			ctx.status(HttpCode.CREATED);
		}
	}
}
