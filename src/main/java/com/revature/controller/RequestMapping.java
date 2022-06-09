package com.revature.controller;

import io.javalin.Javalin;
import io.micrometer.prometheus.PrometheusMeterRegistry;

public class RequestMapping {

	public static void configureRoutes(Javalin app, PrometheusMeterRegistry registry) {
		
		app.get("/", ctx -> ctx.result("Hello there!\nWelcome to P1: Expense Reimbursement System\nby Chance M Hill"));
		
		app.get("/metrics", ctx -> {
			ctx.result(registry.scrape());
		});
		
		//Employee user
		app.post("/Employee/login", EmployeeController::authenticateByFormParam);
		
		app.get("/Employee/{username}", EmployeeController::getEmployeeByUsername);
		
		app.get("/Employee/id/{id}", EmployeeController::getEmployeeById);
		
		app.get("/Employees", EmployeeController::getAllEmployees);
		
		app.get("/Employee/{username}/requests", EmployeeController::viewRequests);
		
		app.get("/Employee/{username}/logs", EmployeeController::viewLogs);
		
		app.post("/Request/{username}/{category}/{balance}", EmployeeController::makeRequest);
		
		//Financial Manager user
		app.post("/FinManager/login", FinManagerController::authenticateByFormParam);
		
		app.get("/FinManager/id/{id}", FinManagerController::getFinManagerById);
		
		app.get("/FinManager/{username}", FinManagerController::getFinManagerByUsername);
		
		app.get("/FinManagers", FinManagerController::getAllFinManagers);
		
		app.get("/requests", FinManagerController::getRequestQueue);
		
		app.get("/logs/{isAccepted}", FinManagerController::getLogsByAcceptance);
		
		app.get("/logs", FinManagerController::getLogs);
		
		app.post("/FinManager/{username}/{id}/{isAccepted}", FinManagerController::fromRequestToLog);
		
	}
}
