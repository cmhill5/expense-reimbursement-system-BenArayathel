package com.revature.controller;

import org.eclipse.jetty.http.HttpStatus;

import com.revature.models.FinManager;
import com.revature.service.FinManagerService;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class FinManagerController {

	public static void authenticateByFormParam(Context ctx) {
		
		String username = ctx.formParam("username");
		String password = ctx.formParam("password");
		
		boolean access = FinManagerService.finmanagerLogin(username, password);
		
		if(access) {
			ctx.result("You have access");
			ctx.status(HttpStatus.ACCEPTED_202);
		}else {
			ctx.result("You don't have access!");
			ctx.status(HttpCode.FORBIDDEN);
		}
		
	}
	
	public static void getFinManagerById(Context ctx) {
		
		int id = Integer.parseInt(ctx.pathParam("id"));
		FinManager fin = FinManagerService.getFinManagerById(id);
		
		if(fin == null) {
			ctx.status(HttpCode.NOT_FOUND);
		}else {
			ctx.json(fin);
		}
	}
	
	public static void getFinManagerByUsername(Context ctx) {
		
		String username = ctx.pathParam("username");
		FinManager emp = FinManagerService.getFinManagerByUsername(username);
		
		if(emp == null) {
			ctx.status(HttpCode.NOT_FOUND);
		}else {
			ctx.json(emp);
		}
	}
	
	public static void getAllFinManagers(Context ctx) {
		
		ctx.json(FinManagerService.getAllFinManagers());
	}
	
	public static void getRequestQueue(Context ctx){
		
		ctx.json(FinManagerService.getRequestQueue());
	}
	
	public static void getLogsByAcceptance(Context ctx){

		boolean isAccepted = Boolean.parseBoolean(ctx.pathParam("isAccepted"));
		
		ctx.json(FinManagerService.getLogsByAcceptance(isAccepted));
	}
	
	public static void getLogs(Context ctx){
		
		ctx.json(FinManagerService.getLogs());
	}
	
	public static void fromRequestToLog(Context ctx) {
		
		String username = ctx.pathParam("username");
		int req_id = Integer.parseInt(ctx.pathParam("id"));
		boolean isAccepted = Boolean.parseBoolean(ctx.pathParam("isAccepted"));
		
		FinManager fin = FinManagerService.getFinManagerByUsername(username);

		boolean confirmed = FinManagerService.fromRequestToLog(fin, req_id, isAccepted);
		
		if(confirmed){
			ctx.status(HttpCode.CREATED);
		}
	}
}
